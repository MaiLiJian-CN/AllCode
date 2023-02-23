package kmclient

import (
	"github.com/hyperledger/fabric/core/chaincode/shim"
)

func GetSecureState(stub shim.ChaincodeStubInterface, name string, key string) ([]byte, error) {
	sv, err := stub.GetStateVersion(key)
	if err != nil {
		return nil, err
	}
	if sv == nil {
		return nil, nil
	}
	historyTxID, err := stub.GetHistoryTxIDByBlockNumTxNum(sv.BlockNum, sv.TxNum)
	if err != nil {
		return nil, err
	}
	historySecret, err := GetSecretByVersion(stub, name, historyTxID, sv)
	if err != nil {
		return nil, err
	}
	s, err := stub.GetState(key)
	if err != nil {
		return nil, err
	}
	s, err = AesDecrypt(s, historySecret, historyTxID)
	if err != nil {
		return nil, err
	}
	return s, nil
}

func GetSecurePrivateData(stub shim.ChaincodeStubInterface, name string, coll, key string) ([]byte, error) {
	sv, err := stub.GetPrivateDataVersion(coll, key)
	if err != nil {
		return nil, err
	}
	if sv == nil {
		return nil, nil
	}
	historyTxID, err := stub.GetHistoryTxIDByBlockNumTxNum(sv.BlockNum, sv.TxNum)
	if err != nil {
		return nil, err
	}
	historySecret, err := GetSecretByVersion(stub, name, historyTxID, sv)
	if err != nil {
		return nil, err
	}
	s, err := stub.GetPrivateData(coll, key)
	if err != nil {
		return nil, err
	}
	s, err = AesDecrypt(s, historySecret, historyTxID)
	if err != nil {
		return nil, err
	}
	return s, nil
}
