package kmcc

import (
	"errors"
	"fmt"
	"time"

	"github.com/hyperledger/fabric/core/chaincode/shim"
	pb "github.com/hyperledger/fabric/protos/peer"
)

//GetSecretRequest is the parameter protocol when we try to call GetSecret
type GetSecretRequest struct {
	Name string //the expected seed collection name
	TxID string //current tx id
}

//GetSecret generates a one-time key for the tx identitied by TxID
/**
 * secret = sha256(seed, txid)
 */
func (kc *KMCC) GetSecret(stub shim.ChaincodeStubInterface, arg GetSecretRequest) pb.Response {
	st := time.Now()

	chaincodeLogger.Infof("handle to get secret for tx:%s with seed name: %s", arg.TxID, arg.Name)
	//get current seed value
	valueBytes, err := stub.GetPrivateData(arg.Name, SeedKey)
	if err != nil {
		chaincodeLogger.Errorf(
			"[%s] gettting current seed value fails, err:%s",
			err.Error())
		return shim.Error("getting current seed value fails")
	}
	if valueBytes == nil {
		chaincodeLogger.Errorf(
			"[%s] no such key found in collection:%s",
			stub.GetTxID(),
			arg.Name)
		return shim.Error("need a seed before using get_secret")
	}
	sv, err := kc.unpack(valueBytes)
	if err != nil {
		chaincodeLogger.Errorf(
			"[%s] unpacking value bytes fails, err:%s",
			err.Error())
		return shim.Error("unpacking value bytes fails")
	}

	gsStartTime := time.Now()
	secret := kc.generateSecret(sv.Seed, []byte(arg.TxID))
	chaincodeLogger.Infof("generating secret costs: %dms", millisecondElapsed(gsStartTime))

	chaincodeLogger.Infof("getting secret costs: %dms", millisecondElapsed(st))
	return shim.Success(secret)
}

//SecretVersion is the version type we use to get a versioned secret
type SecretVersion struct {
	BlockNum uint64
	TxNum    uint64
}

//GetVersionedSecretRequest is the parameter protocol when we try to call GetSecretByVersion
type GetVersionedSecretRequest struct {
	Name    string
	TxID    string
	Version SecretVersion
}

//GetSecretByVersion is the handler method when we try to invoke getSecretByVersion command
func (kc *KMCC) GetSecretByVersion(stub shim.ChaincodeStubInterface,
	arg GetVersionedSecretRequest) pb.Response {
	st := time.Now()
	chaincodeLogger.Infof(
		"handle to get versioned secret from seed:%s for tx_id:%s, and its block_num:%d, tx_num:%d",
		arg.Name, arg.TxID, arg.Version.BlockNum, arg.Version.TxNum)
	cv, err := stub.GetPrivateDataVersion(arg.Name, SeedKey)
	if err != nil {
		chaincodeLogger.Errorf(
			"[%s] failed to load current seed version, err:%s",
			stub.GetTxID(), err.Error())
		return shim.Error(err.Error())
	}
	if cv == nil {
		chaincodeLogger.Errorf(
			"[%s] no such seed key found in collection:%s",
			stub.GetTxID(),
			arg.Name)
		return shim.Error("need a seed before using get_secret")
	}

	valueBytes, err := stub.GetPrivateData(arg.Name, SeedKey)
	if err != nil {
		chaincodeLogger.Errorf(
			"[%s] getting current seed value err: %s",
			stub.GetTxID(),
			err.Error())
		return shim.Error("getting current seed value error")
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
	var seed []byte
	if arg.Version.BlockNum > cv.BlockNum {
		chaincodeLogger.Infof("[%s] use current seed", stub.GetTxID())
		seed = sv.Seed
	} else {
		sv, err := kc.GetHistorySeed(
			stub,
			arg.Name,
			sv.PreVersion,
			&pb.StateVersion{
				BlockNum: arg.Version.BlockNum,
				TxNum:    arg.Version.TxNum,
			})
		if err != nil {
			chaincodeLogger.Errorf(
				"[%s] get history [%d] seed value err:%s",
				stub.GetTxID(), err.Error())
			return shim.Error("no such seed")
		}
		if sv != nil {
			seed = sv.Seed
		}
	}

	gsStartTime := time.Now()
	secret := kc.generateSecret(seed, []byte(arg.TxID))
	chaincodeLogger.Infof("generating secret costs: %dms", millisecondElapsed(gsStartTime))

	chaincodeLogger.Infof("getting versioned secret costs: %dms", millisecondElapsed(st))
	return shim.Success(secret)
}

//GetHistorySeed return a history seed
func (kc *KMCC) GetHistorySeed(
	stub shim.ChaincodeStubInterface,
	coll string,
	history *pb.StateVersion,
	expect *pb.StateVersion) (*SeedValue, error) {
	st := time.Now()

	chaincodeLogger.Infof("get history seed, block_num:%d, tx_num:%d",
		history.BlockNum, history.TxNum)

	if history.BlockNum == 0 {
		return nil, errors.New("no seed in block 0")
	}

	key := fmt.Sprintf(HistoryKeyPattern, history.BlockNum)

	valueBytes, err := stub.GetPrivateData(coll, key)
	if err != nil {
		return nil, err
	}
	if valueBytes == nil {
		return nil, fmt.Errorf("no such history seed: %s", key)
	}
	sv, err := kc.unpack(valueBytes)
	if err != nil {
		return nil, err
	}
	if history.BlockNum < expect.BlockNum {
		return sv, nil
	}
	sv, err = kc.GetHistorySeed(stub, coll, sv.PreVersion, expect)
	chaincodeLogger.Infof("getting history seed cost: %dms", millisecondElapsed(st))
	return sv, err
}
