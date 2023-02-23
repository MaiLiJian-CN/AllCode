package main

import (
	"bytes"
	"encoding/json"
	"errors"
	"fmt"
	"strings"
	"github.com/hyperledger/fabric/core/chaincode/shim"
	pb "github.com/hyperledger/fabric/protos/peer"
	"github.com/hyperledger/fabric/protos/ledger/queryresult"
	"gitlab.lenovo.com/blockchain/chaincode/kmcc/kmclient"
	"encoding/base64"
)
/*
func QueryDataStateDB(stub shim.ChaincodeStubInterface, args []string) pb.Response {
	if len(args) != 2 {
		return shim.Error("Incorrect number of arguments.")
	}
	arg := args[0]
	keyPrefix := args[1]
	if keyPrefix == "" {
		return shim.Error("Invalid object name")
	}
	param := QueryParam{}
	err := json.Unmarshal([]byte(arg), &param)
	if err != nil {
		return shim.Error(err.Error())
	}
	if param.RFID == "" {
		return shim.Error("Query condition is required")
	}
	var rfidkey []string
	rfidkey = append(rfidkey,param.RFID)
	resultsIterator, err := stub.GetStateByPartialCompositeKey(keyPrefix, rfidkey)
	if err != nil {
		return shim.Error(err.Error())
	}
	defer resultsIterator.Close()

	var buffer bytes.Buffer
	buffer.WriteString("[")

	bArrayMemberAlreadyWritten := false
	for resultsIterator.HasNext() {
		queryResponse, err := resultsIterator.Next()
		if err != nil {
			return shim.Error(err.Error())
		}
		// Add a comma before array members, suppress it for the first array member
		if bArrayMemberAlreadyWritten == true {
			buffer.WriteString(",")
		}
		// Record is a JSON object, so we write as-is
		err, valAsbytes := integratePrivateData(stub, queryResponse.Value, queryResponse.Key)
		buffer.WriteString(string(valAsbytes))
		bArrayMemberAlreadyWritten = true
	}
	buffer.WriteString("]")
	return shim.Success(buffer.Bytes())
}


func integratePrivateData(stub shim.ChaincodeStubInterface, valAsbytes []byte, key string) (error, []byte) {
	result := HistoryTransaction{}
	err := json.Unmarshal(valAsbytes, &result)
	if err != nil {
		return errors.New(err.Error()), nil
	}
	resultPrivate := HistoryTransactionPRI{}
	privatebytes, err := stub.GetPrivateData("PrivateCollection", key)
	if err == nil && privatebytes != nil {
		err = json.Unmarshal(privatebytes, &resultPrivate)
		result.ItemDescription = resultPrivate.ItemDescription
		result.NickName = resultPrivate.NickName
		result.Owner = resultPrivate.Owner
		result.AuthCode = resultPrivate.AuthCode
		result.DelegatedTo = resultPrivate.DelegatedTo
	} else {
		result.ItemDescription = "No Permission"
		result.NickName = "No Permission"
		result.Owner = "No Permission"
		result.AuthCode = "No Permission"
		result.DelegatedTo = "No Permission"
	}
	value, _ := json.Marshal(result)
	return nil, value
}
*/

func QueryDataLedger(stub shim.ChaincodeStubInterface, args []string) pb.Response {
	if len(args) != 2 {
		return shim.Error("Incorrect number of arguments.")
	}
	arg := args[0]
	keyPrefix := args[1]
	if keyPrefix == "" {
		return shim.Error("Invalid object name")
	}
	param := QueryParam{}
	err := json.Unmarshal([]byte(arg), &param)
	if err != nil {
		return shim.Error(err.Error())
	}
	if param.EID == "" {
		return shim.Error("Query condition is required")
	}
	err, queryKey := generateKey(stub, strings.ToUpper(keyPrefix), []string{param.EID})
	fmt.Println(queryKey)
	resultsIterator, err := stub.GetHistoryForKey(queryKey)
	if err != nil {
		return shim.Error(err.Error())
	}
	defer resultsIterator.Close()

	var buffer bytes.Buffer
	buffer.WriteString("[")

	bArrayMemberAlreadyWritten := false
	for resultsIterator.HasNext() {
		queryResponse, err := resultsIterator.Next()
		if err != nil {
			return shim.Error(err.Error())
		}
		// Add a comma before array members, suppress it for the first array member
		if bArrayMemberAlreadyWritten == true {
			buffer.WriteString(",")
		}
		// Record is a JSON object, so we write as-is
		err, valAsbytes := integrateKMCCData(stub, queryResponse, queryKey)
		buffer.WriteString(string(valAsbytes))
		bArrayMemberAlreadyWritten = true
	}
	buffer.WriteString("]")
	return shim.Success(buffer.Bytes())
}

func integrateKMCCData(stub shim.ChaincodeStubInterface, response *queryresult.KeyModification, key string) (error, []byte) {
	sv, err := stub.GetStateVersion(key)
	fmt.Println(sv)
	fmt.Println(response)
	sv.BlockNum = response.BlockNum
	sv.TxNum = response.TxNum
	
	
	result := HistoryTransaction{}
	err = json.Unmarshal(response.Value, &result)
	if err != nil {
		fmt.Println("------ERROR---------")
		return errors.New(err.Error()), nil
	}
	fmt.Println(result)
    fmt.Println("------Start to get Secret---------")
	historySecret, err := kmclient.GetSecretByVersion(stub, "PrivateCollection", response.TxId, sv)
	if err != nil {
		result.CreateDate = "No Permission"
		result.IDNumber = "No Permission"
		result.UserName = "No Permission"
		result.Gender = "No Permission"
		result.Age = "No Permission"
		result.Job = "No Permission"
		result.Marriage = "No Permission"
		result.Birthplace = "No Permission"
		result.Operator = "No Permission"
		result.Organization = "No Permission"
		result.AdmissionDate = "No Permission"
		result.RecordTime = "No Permission"
		result.MobilePhone = "No Permission"
		result.SelfReported = "No Permission"
		result.PHI = "No Permission"
		result.PreviousHistory = "No Permission"
		result.PersonalHistory = "No Permission"
		result.FamilyHistory = "No Permission"
		result.PhysicalExamination = "No Permission"
		result.Medicine = "No Permission"
		result.TreatMent = "No Permission"
	} else {
		fmt.Println("------Got Secret---------")
		fmt.Println(historySecret)
		fmt.Println(result.CreateDate)
		fmt.Println([]byte(result.CreateDate))
		CreateDate,_ := base64.StdEncoding.DecodeString(result.CreateDate)
		IDNumber,_ := base64.StdEncoding.DecodeString(result.IDNumber)
		UserName,_ := base64.StdEncoding.DecodeString(result.UserName)
		Gender,_ := base64.StdEncoding.DecodeString(result.Gender)
		Age,_ := base64.StdEncoding.DecodeString(result.Age)
		Job,_ := base64.StdEncoding.DecodeString(result.Job)
		Marriage,_ := base64.StdEncoding.DecodeString(result.Marriage)
		Birthplace,_ := base64.StdEncoding.DecodeString(result.Birthplace)
		Operator,_ := base64.StdEncoding.DecodeString(result.Operator)
		Organization,_ := base64.StdEncoding.DecodeString(result.Organization)
		AdmissionDate,_ := base64.StdEncoding.DecodeString(result.AdmissionDate)
		RecordTime,_ := base64.StdEncoding.DecodeString(result.RecordTime)
		MobilePhone,_ := base64.StdEncoding.DecodeString(result.MobilePhone)
		SelfReported,_ := base64.StdEncoding.DecodeString(result.SelfReported)
		PHI,_ := base64.StdEncoding.DecodeString(result.PHI)
		PreviousHistory,_ := base64.StdEncoding.DecodeString(result.PreviousHistory)
		PersonalHistory,_ := base64.StdEncoding.DecodeString(result.PersonalHistory)
		FamilyHistory,_ := base64.StdEncoding.DecodeString(result.FamilyHistory)
		PhysicalExamination,_ := base64.StdEncoding.DecodeString(result.PhysicalExamination)
		Medicine,_ := base64.StdEncoding.DecodeString(result.Medicine)
		TreatMent,_ := base64.StdEncoding.DecodeString(result.TreatMent)
		fmt.Println("------DecodeString Success---------")

		CreateDate, _ = kmclient.AesDecrypt(CreateDate,historySecret, response.TxId)
		IDNumber, _  = kmclient.AesDecrypt(IDNumber,historySecret, response.TxId)
		UserName, _  = kmclient.AesDecrypt(UserName,historySecret, response.TxId)
		Gender, _  = kmclient.AesDecrypt(Gender,historySecret, response.TxId)
		Age, _  = kmclient.AesDecrypt(Age,historySecret, response.TxId)
		Job, _ = kmclient.AesDecrypt(Job,historySecret, response.TxId)
		Marriage, _  = kmclient.AesDecrypt(Marriage,historySecret, response.TxId)
		Birthplace, _  = kmclient.AesDecrypt(Birthplace,historySecret, response.TxId)
		Operator, _  = kmclient.AesDecrypt(Operator,historySecret, response.TxId)
		Organization, _  = kmclient.AesDecrypt(Organization,historySecret, response.TxId)
		AdmissionDate, _  = kmclient.AesDecrypt(AdmissionDate,historySecret, response.TxId)
		RecordTime, _  = kmclient.AesDecrypt(RecordTime,historySecret, response.TxId)
		MobilePhone, _  = kmclient.AesDecrypt(MobilePhone,historySecret, response.TxId)
		SelfReported, _  = kmclient.AesDecrypt(SelfReported,historySecret, response.TxId)
		PHI, _  = kmclient.AesDecrypt(PHI,historySecret, response.TxId)
		PreviousHistory, _ = kmclient.AesDecrypt(PreviousHistory,historySecret, response.TxId)
		PersonalHistory, _  = kmclient.AesDecrypt(PersonalHistory,historySecret, response.TxId)
		FamilyHistory, _  = kmclient.AesDecrypt(FamilyHistory,historySecret, response.TxId)
		PhysicalExamination, _  = kmclient.AesDecrypt(PhysicalExamination,historySecret, response.TxId)
		Medicine, _  = kmclient.AesDecrypt(Medicine,historySecret, response.TxId)
		TreatMent, _  = kmclient.AesDecrypt(TreatMent,historySecret, response.TxId)
		fmt.Println("------AesDecrypt Success---------")

		result.CreateDate = string(CreateDate)
		result.IDNumber = string(IDNumber)
		result.UserName = string(UserName)
		result.Gender = string(Gender)
		result.Age = string(Age)
		result.Job = string(Job)
		result.Marriage = string(Marriage)
		result.Birthplace = string(Birthplace)
		result.Operator = string(Operator)
		result.Organization = string(Organization)
		result.AdmissionDate = string(AdmissionDate)
		result.RecordTime = string(RecordTime)
		result.MobilePhone = string(MobilePhone)
		result.SelfReported = string(SelfReported)
		result.PHI = string(PHI)
		result.PreviousHistory = string(PreviousHistory)
		result.PersonalHistory = string(PersonalHistory)
		result.FamilyHistory = string(FamilyHistory)
		result.PhysicalExamination = string(PhysicalExamination)
		result.Medicine = string(Medicine)
		result.TreatMent = string(TreatMent)
		fmt.Println(result.Operator)
	}
	value, _ := json.Marshal(result)
	return nil, value
}