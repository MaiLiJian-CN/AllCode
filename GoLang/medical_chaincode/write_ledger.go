package main

import (
	//"errors"
	"fmt"
	"encoding/json"

	"github.com/hyperledger/fabric/core/chaincode/shim"
	//"github.com/hyperledger/fabric/core/chaincode/shim/ext/statebased"
	pb "github.com/hyperledger/fabric/protos/peer"
	"gitlab.lenovo.com/blockchain/chaincode/kmcc/kmclient"
	"encoding/base64"
)

// History Transaction
/*
func AppendDataStateDB(stub shim.ChaincodeStubInterface, args []string) pb.Response {
	if len(args) != 1 {
			 return shim.Error("Incorrect number of arguments. Expecting json to create/update Material Pulling Object")
	}
	jsonStr := args[0]
	var historytranss []HistoryTransaction

	err := json.Unmarshal([]byte(jsonStr), &historytranss)
	if err != nil {
		return shim.Error(err.Error())
	}
	
	var historytransPUB HistoryTransactionPUB
	var historytransPRI HistoryTransactionPRI
	for _, historytrans := range historytranss {
		if historytrans.RFID != "" {
			err, timekey := generateKey(stub, RFID_KEY, []string{historytrans.RFID, historytrans.Timestamp, historytrans.Randomtext})
			fmt.Println("write HistoryTransaction data for RFID - " + timekey)
			if err != nil {
				return shim.Error(err.Error())
			}
			fulldata, _ := json.Marshal(historytrans)
			err = json.Unmarshal([]byte(fulldata), &historytransPUB)
			if err != nil {
				return shim.Error(err.Error())
			}
			err = json.Unmarshal([]byte(fulldata), &historytransPRI)
			if err != nil {
				return shim.Error(err.Error())
			}
			historytransPUB.RFID = historytrans.RFID
			historytransPUB.SerialNumber = historytrans.SerialNumber
			historytransPUB.StartTime = historytrans.StartTime
			historytransPUB.EndTime = historytrans.EndTime
			historytransPUB.PositionID = historytrans.PositionID
			historytransPUB.Address = historytrans.Address
			historytransPUB.Machine = historytrans.Machine
			historytransPUB.LockerNumber = historytrans.LockerNumber
			historytransPUB.Action = historytrans.Action
			historytransPUB.OperateDate = historytrans.OperateDate
			historytransPUB.OperateTime = historytrans.OperateTime
			historytransPRI.RFID = historytrans.RFID
			historytransPRI.ItemDescription = historytrans.ItemDescription
			historytransPRI.NickName = historytrans.NickName
			historytransPRI.Owner = historytrans.Owner
			historytransPRI.AuthCode = historytrans.AuthCode
			historytransPRI.DelegatedTo = historytrans.DelegatedTo
			var valuePUB []byte
			valuePUB, _ = json.Marshal(historytransPUB)
			err = stub.PutState(timekey, valuePUB)
			if err != nil {
				return shim.Error(err.Error())
			}
			var valuePRI []byte
			valuePRI, _ = json.Marshal(historytransPRI)
			err = stub.PutPrivateData("PrivateCollection", timekey, valuePRI)
			if err != nil {
				return shim.Error(err.Error())
			}
		} else {
			return shim.Error("RFID is required")
		}
	}
	return shim.Success(nil)
}
*/

// History Transaction Ledger
func AppendDataLedger(stub shim.ChaincodeStubInterface, args []string) pb.Response {
	if len(args) != 1 {
		return shim.Error("Incorrect number of arguments. Expecting json to create/update Material Pulling Object")
	}
	jsonStr := args[0]
	var historytranss []HistoryTransaction
	err := json.Unmarshal([]byte(jsonStr), &historytranss)
	if err != nil {
		return shim.Error(err.Error())
	}
	fmt.Println(historytranss)
	for _, historytrans := range historytranss {
		if historytrans.EID != "" {
			err, key := generateKey(stub, EID_KEY, []string{historytrans.EID})
			fmt.Println("write HistoryTransaction data for eID - " + key)
			if err != nil {
				return shim.Error(err.Error())
			}
			currentSecret, err := kmclient.GetSecret(stub, "PrivateCollection", stub.GetTxID())
			if err != nil {
				return shim.Error(err.Error())
			}
            fmt.Println(historytrans.Operator)
			CreateDate, _ := kmclient.AesEncrypt([]byte(historytrans.CreateDate),currentSecret, stub.GetTxID())
			IDNumber, _  := kmclient.AesEncrypt([]byte(historytrans.IDNumber),currentSecret, stub.GetTxID())
			UserName, _  := kmclient.AesEncrypt([]byte(historytrans.UserName),currentSecret, stub.GetTxID())
			Gender, _  := kmclient.AesEncrypt([]byte(historytrans.Gender),currentSecret, stub.GetTxID())
			Age, _  := kmclient.AesEncrypt([]byte(historytrans.Age),currentSecret, stub.GetTxID())
			Job, _ := kmclient.AesEncrypt([]byte(historytrans.Job),currentSecret, stub.GetTxID())
			Marriage, _  := kmclient.AesEncrypt([]byte(historytrans.Marriage),currentSecret, stub.GetTxID())
			Birthplace, _  := kmclient.AesEncrypt([]byte(historytrans.Birthplace),currentSecret, stub.GetTxID())
			Operator, _  := kmclient.AesEncrypt([]byte(historytrans.Operator),currentSecret, stub.GetTxID())
			Organization, _  := kmclient.AesEncrypt([]byte(historytrans.Organization),currentSecret, stub.GetTxID())
			AdmissionDate, _  := kmclient.AesEncrypt([]byte(historytrans.AdmissionDate),currentSecret, stub.GetTxID())
			RecordTime, _  := kmclient.AesEncrypt([]byte(historytrans.RecordTime),currentSecret, stub.GetTxID())
			MobilePhone, _  := kmclient.AesEncrypt([]byte(historytrans.MobilePhone),currentSecret, stub.GetTxID())
			SelfReported, _  := kmclient.AesEncrypt([]byte(historytrans.SelfReported),currentSecret, stub.GetTxID())
			PHI, _  := kmclient.AesEncrypt([]byte(historytrans.PHI),currentSecret, stub.GetTxID())
			PreviousHistory, _ := kmclient.AesEncrypt([]byte(historytrans.PreviousHistory),currentSecret, stub.GetTxID())
			PersonalHistory, _  := kmclient.AesEncrypt([]byte(historytrans.PersonalHistory),currentSecret, stub.GetTxID())
			FamilyHistory, _  := kmclient.AesEncrypt([]byte(historytrans.FamilyHistory),currentSecret, stub.GetTxID())
			PhysicalExamination, _  := kmclient.AesEncrypt([]byte(historytrans.PhysicalExamination),currentSecret, stub.GetTxID())
			Medicine, _  := kmclient.AesEncrypt([]byte(historytrans.Medicine),currentSecret, stub.GetTxID())
			TreatMent, _  := kmclient.AesEncrypt([]byte(historytrans.TreatMent),currentSecret, stub.GetTxID())

			historytrans.CreateDate = base64.StdEncoding.EncodeToString(CreateDate)
			historytrans.IDNumber = base64.StdEncoding.EncodeToString(IDNumber)
			historytrans.UserName = base64.StdEncoding.EncodeToString(UserName)
			historytrans.Gender = base64.StdEncoding.EncodeToString(Gender)
			historytrans.Age = base64.StdEncoding.EncodeToString(Age)
			historytrans.Job = base64.StdEncoding.EncodeToString(Job)
			historytrans.Marriage = base64.StdEncoding.EncodeToString(Marriage)
			historytrans.Birthplace = base64.StdEncoding.EncodeToString(Birthplace)
			historytrans.Operator = base64.StdEncoding.EncodeToString(Operator)
			historytrans.Organization = base64.StdEncoding.EncodeToString(Organization)
			historytrans.AdmissionDate = base64.StdEncoding.EncodeToString(AdmissionDate)
			historytrans.RecordTime = base64.StdEncoding.EncodeToString(RecordTime)
			historytrans.MobilePhone = base64.StdEncoding.EncodeToString(MobilePhone)
			historytrans.SelfReported = base64.StdEncoding.EncodeToString(SelfReported)
			historytrans.PHI = base64.StdEncoding.EncodeToString(PHI)
			historytrans.PreviousHistory = base64.StdEncoding.EncodeToString(PreviousHistory)
			historytrans.PersonalHistory = base64.StdEncoding.EncodeToString(PersonalHistory)
			historytrans.FamilyHistory = base64.StdEncoding.EncodeToString(FamilyHistory)
			historytrans.PhysicalExamination = base64.StdEncoding.EncodeToString(PhysicalExamination)
			historytrans.Medicine = base64.StdEncoding.EncodeToString(Medicine)
			historytrans.TreatMent = base64.StdEncoding.EncodeToString(TreatMent)

			var value []byte
			value, _ = json.Marshal(historytrans)
			err = stub.PutState(key, value)
			if err != nil {
				return shim.Error(err.Error())
			}
		} else {
			return shim.Error("eID is required")
		}
	}
	return shim.Success(nil)
}




