package kmcc

import (
	"encoding/hex"
	"fmt"
	"time"

	"github.com/hyperledger/fabric/core/chaincode/shim"
	pb "github.com/hyperledger/fabric/protos/peer"
)

//DeploySeedRequest the request protocol when to deploy a seed
type DeploySeedRequest struct {
	Name string
}

//DeploySeed is the handler method when we try to invoke deploySeed command
func (kc *KMCC) DeploySeed(stub shim.ChaincodeStubInterface, arg DeploySeedRequest) pb.Response {
	st := time.Now()

	chaincodeLogger.Infof("handle to deploy a new seed, seed_name:%s", arg.Name)
	tm, err := stub.GetTransient()
	if err != nil {
		chaincodeLogger.Errorf(
			"[%s] fetching transient data err:%s",
			stub.GetTxID(), err.Error())
		return shim.Error(err.Error())
	}

	seedStr, ok := tm[SeedKey]
	if !ok {
		chaincodeLogger.Errorf("[%s] seed value not found", stub.GetTxID())
		return shim.Error(ErrSeedNotFound.Error())
	}
	chaincodeLogger.Infof("new seed value found")

	seedBytes, err := hex.DecodeString(string(seedStr))
	if err != nil {
		chaincodeLogger.Errorf(
			"[%s] decoding hex string to []byte fails",
			err.Error())
		return shim.Error(err.Error())
	}

	oldVersion, err := stub.GetPrivateDataVersion(arg.Name, SeedKey)

	if err != nil {
		chaincodeLogger.Infof("[%s] failed to load current seed version, err:%s", stub.GetTxID(), err.Error())
		if !kc.pvtdataNotAvailableErr(err) {
			return shim.Error(err.Error())
		}
		chaincodeLogger.Infof("pvtdata not found")
		oldVersion = nil  //reset to nil
	}

	if oldVersion == nil {
		chaincodeLogger.Infof("first time to deploy a seed")
		//this is the first we set the seed, so we just put the seed into the private date collection
		sv := &SeedValue{
			Seed: seedBytes,
			PreVersion: &pb.StateVersion{
				BlockNum: 0,
				TxNum:    0,
			},
		}
		valueBytes, err := kc.pack(sv)
		if err != nil {
			chaincodeLogger.Errorf(
				"[%s] marshal seed values err: %s",
				stub.GetTxID(),
				err.Error())
			return shim.Error(err.Error())
		}
		stub.PutPrivateData(arg.Name, SeedKey, valueBytes)
		chaincodeLogger.Infof("deploying seed done")
		stub.SetEvent("seed_created", []byte(""))
		chaincodeLogger.Infof("deploying seed costs: %dms", millisecondElapsed(st))
		return shim.Success([]byte("Ok"))
	}

	chaincodeLogger.Infof("alread have a older seed, which deployed at block %d with tx %d",
		oldVersion.BlockNum, oldVersion.TxNum)

	//we have already deployed an seed, so this is a re-deploy process
	old, err := stub.GetPrivateData(arg.Name, SeedKey)
	if err != nil {
		chaincodeLogger.Errorf(
			"[%s] getting current seed value err: %s",
			stub.GetTxID(),
			err.Error())
		return shim.Error("getting current seed value error")
	}
	resp := kc.redeploySeed(stub, arg.Name, seedBytes, oldVersion, old)
	chaincodeLogger.Infof("deploying seed costs: %dms", millisecondElapsed(st))
	return resp
}

/**
 * redeploy the encryptgraphical seed
 * 1. save the old seed value into the private collection data identified
 * by seed_${block_num}
 * 2. save the new seed value into private collection with the seed key
 */
func (kc *KMCC) redeploySeed(stub shim.ChaincodeStubInterface, coll string, newSeed []byte, oldVersion *pb.StateVersion, oldValue []byte) pb.Response {
	//save the old value to seed_${block_num}
	st := time.Now()

	historyKey := fmt.Sprintf(HistoryKeyPattern, oldVersion.BlockNum)
	err := stub.PutPrivateData(coll, historyKey, oldValue)
	if err != nil {
		chaincodeLogger.Errorf(
			"[%s] saving current seed value as a historyone fails, err:%s",
			stub.GetTxID(),
			err.Error())
		return shim.Error("saving current seed value as a history one fails")
	}
	chaincodeLogger.Infof("backup the history seed to %s", historyKey)
	//save the new seed
	sv := &SeedValue{
		Seed:       newSeed,
		PreVersion: oldVersion,
	}
	valueBytes, err := kc.pack(sv)
	if err != nil {
		chaincodeLogger.Errorf(
			"[%s] marshal seed values err:%s",
			stub.GetTxID(),
			err.Error())
		return shim.Error(err.Error())
	}
	err = stub.PutPrivateData(coll, SeedKey, valueBytes)
	if err != nil {
		chaincodeLogger.Errorf("[%s] save the new seed err:%s",
			stub.GetTxID(),
			err.Error())
		return shim.Error("saving new seed value fails")
	}

	chaincodeLogger.Infof("re-deploying seed done")
	//alert the seed change issue with a event and the event payload is empty
	stub.SetEvent("seed_change", []byte(""))
	chaincodeLogger.Infof("re-deploying seed costs: %dms", millisecondElapsed(st))
	return shim.Success([]byte("Ok"))
}
