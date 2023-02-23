/*
Copyright IBM Corp. 2016 All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

		 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package gm

import (
	"crypto/sha256"
	"crypto/sha512"
	"hash"
	"reflect"

	"github.com/hyperledger/fabric/bccsp"
	"github.com/hyperledger/fabric/common/flogging"
	"github.com/pkg/errors"
	"github.com/tjfoc/gmsm/sm3"
	"golang.org/x/crypto/sha3"
)

var (
	logger = flogging.MustGetLogger("bccsp_gm")
)

// NewDefaultSecurityLevel returns a new instance of the software-based BCCSP
// at security level 256, hash family SHA2 and using FolderBasedKeyStore as KeyStore.
func NewDefaultSecurityLevel(keyStorePath string) (bccsp.BCCSP, error) {
	ks := &fileBasedKeyStore{}
	if err := ks.Init(nil, keyStorePath, false); err != nil {
		return nil, errors.Wrapf(err, "Failed initializing key store at [%v]", keyStorePath)
	}

	return New(256, "GMSM3", ks)
}

// NewDefaultSecurityLevel returns a new instance of the software-based BCCSP
// at security level 256, hash family SHA2 and using the passed KeyStore.
func NewDefaultSecurityLevelWithKeystore(keyStore bccsp.KeyStore) (bccsp.BCCSP, error) {
	return New(256, "GMSM3", keyStore)
}

// New bccsp.BCCSP
func New(securityLevel int, hashFamily string, keyStore bccsp.KeyStore) (bccsp.BCCSP, error) {

	// Init config
	conf := &config{}
	err := conf.setSecurityLevel(securityLevel, hashFamily)
	if err != nil {
		return nil, errors.Wrapf(err, "Failed initializing configuration at [%v,%v]", securityLevel, hashFamily)
	}

	// Check KeyStore
	if keyStore == nil {
		return nil, errors.Errorf("Invalid bccsp.KeyStore instance. It must be different from nil.")
	}

	// Set the encryptors
	encryptors := make(map[reflect.Type]Encryptor)
	encryptors[reflect.TypeOf(&gmsm4PrivateKey{})] = &gmsm4Encryptor{} //sm4 encryptor

	// Set the decryptors
	decryptors := make(map[reflect.Type]Decryptor)
	decryptors[reflect.TypeOf(&gmsm4PrivateKey{})] = &gmsm4Decryptor{} //sm4 decryptor

	// Set the signers
	signers := make(map[reflect.Type]Signer)
	signers[reflect.TypeOf(&gmsm2PrivateKey{})] = &gmsm2Signer{} //sm2 signer

	// Set the verifiers
	verifiers := make(map[reflect.Type]Verifier)
	verifiers[reflect.TypeOf(&gmsm2PrivateKey{})] = &gmsm2PrivateKeyVerifier{}
	verifiers[reflect.TypeOf(&gmsm2PublicKey{})] = &gmsm2PublicKeyKeyVerifier{}

	// Set the hashers
	hashers := make(map[reflect.Type]Hasher)
	hashers[reflect.TypeOf(&bccsp.SHAOpts{})] = &hasher{hash: conf.hashFunction}
	hashers[reflect.TypeOf(&bccsp.GMSM3Opts{})] = &hasher{hash: sm3.New} //sm3
	hashers[reflect.TypeOf(&bccsp.SHA256Opts{})] = &hasher{hash: sha256.New}
	hashers[reflect.TypeOf(&bccsp.SHA384Opts{})] = &hasher{hash: sha512.New384}
	hashers[reflect.TypeOf(&bccsp.SHA3_256Opts{})] = &hasher{hash: sha3.New256}
	hashers[reflect.TypeOf(&bccsp.SHA3_384Opts{})] = &hasher{hash: sha3.New384}

	CSP := &CSP{
		conf:       conf,
		ks:         keyStore,
		encryptors: encryptors,
		decryptors: decryptors,
		signers:    signers,
		verifiers:  verifiers,
		hashers:    hashers}

	// Set the key generators
	keyGenerators := make(map[reflect.Type]KeyGenerator)
	keyGenerators[reflect.TypeOf(&bccsp.GMSM2KeyGenOpts{})] = &gmsm2KeyGenerator{}
	keyGenerators[reflect.TypeOf(&bccsp.GMSM4KeyGenOpts{})] = &gmsm4KeyGenerator{length: 32}
	CSP.keyGenerators = keyGenerators

	// Set the key derivers
	keyDerivers := make(map[reflect.Type]KeyDeriver)
	CSP.keyDerivers = keyDerivers

	// Set the key importers
	keyImporters := make(map[reflect.Type]KeyImporter)
	keyImporters[reflect.TypeOf(&bccsp.GMSM4ImportKeyOpts{})] = &gmsm4ImportKeyOptsKeyImporter{}
	keyImporters[reflect.TypeOf(&bccsp.GMSM2PrivateKeyImportOpts{})] = &gmsm2PrivateKeyImportOptsKeyImporter{}
	keyImporters[reflect.TypeOf(&bccsp.GMSM2PublicKeyImportOpts{})] = &gmsm2PublicKeyImportOptsKeyImporter{}
	keyImporters[reflect.TypeOf(&bccsp.X509PublicKeyImportOpts{})] = &x509PublicKeyImportOptsKeyImporter{bccsp: CSP}

	CSP.keyImporters = keyImporters

	return CSP, nil
}

type CSP struct {
	conf          *config                    //bccsp config
	ks            bccsp.KeyStore             //key store
	encryptors    map[reflect.Type]Encryptor //encryptor
	decryptors    map[reflect.Type]Decryptor //decryptor
	signers       map[reflect.Type]Signer    //signer
	verifiers     map[reflect.Type]Verifier  //verifier
	hashers       map[reflect.Type]Hasher    //hash
	keyGenerators map[reflect.Type]KeyGenerator
	keyDerivers   map[reflect.Type]KeyDeriver
	keyImporters  map[reflect.Type]KeyImporter
}

//KeyGen generates a key using opts.
func (csp *CSP) KeyGen(opts bccsp.KeyGenOpts) (k bccsp.Key, err error) {
	// Validate arguments
	if opts == nil {
		return nil, errors.New("Invalid Opts parameter. It must not be nil.")
	}

	keyGenerator, found := csp.keyGenerators[reflect.TypeOf(opts)]
	if !found {
		return nil, errors.Errorf("Unsupported 'KeyGenOpts' provided [%v]", opts)
	}

	k, err = keyGenerator.KeyGen(opts)
	if err != nil {
		return nil, errors.Wrapf(err, "Failed generating key with opts [%v]", opts)
	}

	// If the key is not Ephemeral, store it.
	if !opts.Ephemeral() {
		// Store the key
		err = csp.ks.StoreKey(k)
		if err != nil {
			return nil, errors.Wrapf(err, "Failed storing key [%s]", opts.Algorithm())
		}
	}

	return k, nil
}

// KeyDeriv derives a key from k using opts.
// The opts argument should be appropriate for the primitive used
func (csp *CSP) KeyDeriv(k bccsp.Key, opts bccsp.KeyDerivOpts) (dk bccsp.Key, err error) {
	// Validate arguments
	if k == nil {
		return nil, errors.New("Invalid Key. It must not be nil.")
	}
	if opts == nil {
		return nil, errors.New("Invalid opts. It must not be nil.")
	}

	keyDeriver, found := csp.keyDerivers[reflect.TypeOf(k)]
	if !found {
		return nil, errors.Errorf("Unsupported 'Key' provided [%v]", k)
	}

	k, err = keyDeriver.KeyDeriv(k, opts)
	if err != nil {
		return nil, errors.Wrapf(err, "Failed deriving key with opts [%v]", opts)
	}

	// If the key is not Ephemeral, store it.
	if !opts.Ephemeral() {
		// Store the key
		err = csp.ks.StoreKey(k)
		if err != nil {
			return nil, errors.Wrapf(err, "Failed storing key [%s]", opts.Algorithm())
		}
	}

	return k, nil
}

// KeyImport imports a key from its raw representation using opts.
// The opts argument should be appropriate for the primitive used.
func (csp *CSP) KeyImport(raw interface{}, opts bccsp.KeyImportOpts) (k bccsp.Key, err error) {
	// Validate arguments
	if raw == nil {
		return nil, errors.New("Invalid raw. It must not be nil.")
	}
	if opts == nil {
		return nil, errors.New("Invalid opts. It must not be nil.")
	}

	keyImporter, found := csp.keyImporters[reflect.TypeOf(opts)]
	if !found {
		return nil, errors.Errorf("Unsupported 'KeyImportOpts' provided [%v]", opts)
	}

	k, err = keyImporter.KeyImport(raw, opts)
	if err != nil {
		return nil, errors.Wrapf(err, "Failed importing key with opts [%v]", opts)
	}

	// If the key is not Ephemeral, store it.
	if !opts.Ephemeral() {
		// Store the key
		err = csp.ks.StoreKey(k)
		if err != nil {
			return nil, errors.Wrapf(err, "Failed storing imported key with opts [%v]", opts)
		}
	}

	return
}

//GetKey returns the key this CSP associates to
// the Subject Key Identifier ski.
func (csp *CSP) GetKey(ski []byte) (k bccsp.Key, err error) {
	k, err = csp.ks.GetKey(ski)
	if err != nil {
		return nil, errors.Wrapf(err, "Failed getting key for SKI [%v]", ski)
	}

	return
}

// Hash hashes messages msg using options opts.
func (csp *CSP) Hash(msg []byte, opts bccsp.HashOpts) (digest []byte, err error) {
	// Validate arguments
	if opts == nil {
		return nil, errors.New("Invalid opts. It must not be nil.")
	}

	hasher, found := csp.hashers[reflect.TypeOf(opts)]
	if !found {
		return nil, errors.Errorf("Unsupported 'HashOpt' provided [%v]", opts)
	}

	digest, err = hasher.Hash(msg, opts)
	if err != nil {
		return nil, errors.Wrapf(err, "Failed hashing with opts [%v]", opts)
	}

	return
}

// GetHash returns and instance of hash.Hash using options opts.
// If opts is nil then the default hash function is returned.
func (csp *CSP) GetHash(opts bccsp.HashOpts) (h hash.Hash, err error) {
	// Validate arguments
	if opts == nil {
		return nil, errors.New("Invalid opts. It must not be nil.")
	}

	hasher, found := csp.hashers[reflect.TypeOf(opts)]
	if !found {
		return nil, errors.Errorf("Unsupported 'HashOpt' provided [%v]", opts)
	}

	h, err = hasher.GetHash(opts)
	if err != nil {
		return nil, errors.Wrapf(err, "Failed getting hash function with opts [%v]", opts)
	}

	return
}

// Sign signs digest using key k.
// The opts argument should be appropriate for the primitive used.
// Note that in SM2 signing, instead of digest, message need to be provided in this interface
func (csp *CSP) Sign(k bccsp.Key, msg []byte, opts bccsp.SignerOpts) (signature []byte, err error) {
	// Validate arguments
	if k == nil {
		return nil, errors.New("Invalid Key. It must not be nil.")
	}
	if len(msg) == 0 {
		return nil, errors.New("Invalid msg. Cannot be empty.")
	}

	signer, found := csp.signers[reflect.TypeOf(k)]
	if !found {
		return nil, errors.Errorf("Unsupported 'SignKey' provided [%s]", k)
	}

	signature, err = signer.Sign(k, msg, opts)
	if err != nil {
		return nil, errors.Wrapf(err, "Failed signing with opts [%v]", opts)
	}

	return
}

// Verify verifies signature against key k and digest
// Note that in SM2 verifying, instead of digest, message need to be provided in this interface
func (csp *CSP) Verify(k bccsp.Key, signature, msg []byte, opts bccsp.SignerOpts) (valid bool, err error) {
	// Validate arguments
	if k == nil {
		return false, errors.New("Invalid Key. It must not be nil.")
	}
	if len(signature) == 0 {
		return false, errors.New("Invalid signature. Cannot be empty.")
	}
	if len(msg) == 0 {
		return false, errors.New("Invalid msg. Cannot be empty.")
	}

	verifier, found := csp.verifiers[reflect.TypeOf(k)]
	if !found {
		return false, errors.Errorf("Unsupported 'VerifyKey' provided [%v]", k)
	}

	valid, err = verifier.Verify(k, signature, msg, opts)
	if err != nil {
		return false, errors.Wrapf(err, "Failed verifing with opts [%v]", opts)
	}

	return
}

// Encrypt encrypts plaintext using key k.
// The opts argument should be appropriate for the primitive used.
func (csp *CSP) Encrypt(k bccsp.Key, plaintext []byte, opts bccsp.EncrypterOpts) (ciphertext []byte, err error) {
	// Validate arguments
	if k == nil {
		return nil, errors.New("Invalid Key. It must not be nil.")
	}

	encryptor, found := csp.encryptors[reflect.TypeOf(k)]
	if !found {
		return nil, errors.Errorf("Unsupported 'EncryptKey' provided [%v]", k)
	}

	return encryptor.Encrypt(k, plaintext, opts)
}

// Decrypt decrypts ciphertext using key k.
// The opts argument should be appropriate for the primitive used.
func (csp *CSP) Decrypt(k bccsp.Key, ciphertext []byte, opts bccsp.DecrypterOpts) (plaintext []byte, err error) {
	// Validate arguments
	if k == nil {
		return nil, errors.New("Invalid Key. It must not be nil.")
	}

	decryptor, found := csp.decryptors[reflect.TypeOf(k)]
	if !found {
		return nil, errors.Errorf("Unsupported 'DecryptKey' provided [%v]", k)
	}

	plaintext, err = decryptor.Decrypt(k, ciphertext, opts)
	if err != nil {
		return nil, errors.Wrapf(err, "Failed decrypting with opts [%v]", opts)
	}

	return
}
