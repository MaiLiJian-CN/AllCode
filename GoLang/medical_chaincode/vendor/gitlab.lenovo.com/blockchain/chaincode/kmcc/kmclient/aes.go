package kmclient

import (
	"bytes"
	"crypto/aes"
	"crypto/cipher"
	"errors"
)

func pkcs5Padding(ciphertext []byte, blockSize int) []byte {
	padding := blockSize - len(ciphertext)%blockSize
	padtext := bytes.Repeat([]byte{byte(padding)}, padding)
	return append(ciphertext, padtext...)
}

func pkcs5UnPadding(origData []byte) []byte {
	length := len(origData)
	unpadding := int(origData[length-1])
	return origData[:(length - unpadding)]
}

//AesEncrypt use AES-CBC to encrypt data, tx[0:blockSize] as the iv
func AesEncrypt(data []byte, key []byte, tx string) ([]byte, error) {
	block, err := aes.NewCipher(key[0:32])
	if err != nil {
		return data, err
	}
	bc := block.BlockSize()
	paddingData := pkcs5Padding(data, bc)
	paddingIV := pkcs5Padding([]byte(tx), bc)

	bm := cipher.NewCBCEncrypter(block, paddingIV[0:bc])

	out := make([]byte, len(paddingData))
	bm.CryptBlocks(out, paddingData)
	return out, nil
}

//AesDecrypt use AES-CBC to decrypt data, tx[0:blockSize] as the iv
func AesDecrypt(data []byte, key []byte, tx string) ([]byte, error) {
	block, err := aes.NewCipher(key[0:32])
	if err != nil {
		return data, err
	}
	bc := block.BlockSize()
	if len(data)%bc != 0 {
		return nil, errors.New("len(data) should be a mutipler of block size")
	}
	paddingIV := pkcs5Padding([]byte(tx), bc)

	bm := cipher.NewCBCDecrypter(block, paddingIV[0:bc])
	out := make([]byte, len(data))
	bm.CryptBlocks(out, data)

	return pkcs5UnPadding(out), nil
}
