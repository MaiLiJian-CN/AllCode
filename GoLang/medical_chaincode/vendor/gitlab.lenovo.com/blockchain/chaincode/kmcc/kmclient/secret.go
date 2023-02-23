package kmclient

import (
	"crypto/sha256"
	"encoding/json"
	"errors"

	"github.com/hyperledger/fabric/core/chaincode/shim"
	pb "github.com/hyperledger/fabric/protos/peer"
	"gitlab.lenovo.com/blockchain/chaincode/kmcc/kmcc"
)

//GetSecret the client-side method to get the named secret
func GetSecret(stub shim.ChaincodeStubInterface, name, tx string) ([]byte, error) {
	res := stub.InvokeChaincode(
		kmcc.ChaincodeName,
		[][]byte{[]byte("getSecret"), []byte(name), []byte(tx)},
		stub.GetChannelID())
	if res.Status != 200 {
		return nil, errors.New(res.Message)
	}
	return res.Payload[0:sha256.Size], nil
}

//GetSecretByVersion the client-side method to get the named secret with version
func GetSecretByVersion(stub shim.ChaincodeStubInterface, name, tx string, v *pb.StateVersion) ([]byte, error) {
	if v == nil {
		return nil, errors.New("version value is nil")
	}
	sv := &kmcc.SecretVersion{
		BlockNum: v.BlockNum,
		TxNum:    v.TxNum,
	}
	vbyte, err := json.Marshal(sv)
	if err != nil {
		return nil, err
	}
	res := stub.InvokeChaincode(kmcc.ChaincodeName,
		[][]byte{
			[]byte("getSecretByVersion"),
			[]byte(name), []byte(tx), vbyte},
		stub.GetChannelID())
	if res.Status != 200 {
		return nil, errors.New(res.Message)
	}
	return res.Payload[0:sha256.Size], nil
}
