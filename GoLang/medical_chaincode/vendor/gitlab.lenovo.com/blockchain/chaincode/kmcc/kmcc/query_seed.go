package kmcc

import (
	"encoding/hex"
	"time"

	"github.com/hyperledger/fabric/core/chaincode/shim"
	pb "github.com/hyperledger/fabric/protos/peer"
)

//QuerySeedRequest the request protocol when to query a seed
type QuerySeedRequest struct {
	Name string
}

//QuerySeed is the handler method when we try to invoke querySeed command
func (kc *KMCC) QuerySeed(stub shim.ChaincodeStubInterface, arg QuerySeedRequest) pb.Response {
	st := time.Now()

	chaincodeLogger.Infof("querying seed, name: %s", arg.Name)

	valueBytes, err := stub.GetPrivateData(arg.Name, SeedKey)
	if err != nil {
		chaincodeLogger.Errorf(
			"[%s] getting seed value fails",
			stub.GetTxID())
		return shim.Error("getting seed value fails")
	}
	if valueBytes == nil {
		chaincodeLogger.Errorf(
			"[%s] no such seed key",
			stub.GetTxID())
		return shim.Error("deploy a seed before using it")
	}
	sv, err := kc.unpack(valueBytes)
	if err != nil {
		chaincodeLogger.Errorf(
			"[%s] unmarshal seed value fails, err:%s",
			stub.GetTxID(),
			err.Error(),
		)
		return shim.Error(err.Error())
	}

	chaincodeLogger.Infof("querying seed costs: %dms", millisecondElapsed(st))
	return shim.Success([]byte(hex.EncodeToString(sv.Seed)))
}
