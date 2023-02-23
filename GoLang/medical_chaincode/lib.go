package main

import (
	//"encoding/json"
	"errors"
	"github.com/hyperledger/fabric/core/chaincode/shim"
)

//HistoryTransaction-ALL
type HistoryTransaction struct {
	EID   string `json:"eID"`   //eID
	CreateDate   string `json:"createDate"`   //创建日期
	IDNumber string `json:"IDNumber"` //身份证号
	UserName string `json:"userName"` //患者名
	Gender string `json:"gender"` //性别
	Age string `json:"age"` //年龄
	Job string `json:"job"` //职业
	Marriage string `json:"marriage"` //婚姻状况
	Birthplace string `json:"birthplace"` //出生地
	Operator string `json:"operator"`     //医生
	Organization string `json:"organization"`  //医院名称
	AdmissionDate string `json:"admissionDate"` //受理日期
	RecordTime string `json:"recordTime"` //记录日期
	MobilePhone string `json:"mobilePhone"` //手机号
	SelfReported   string `json:"selfReported"`   //病情自诉
	PHI string `json:"PHI"` //健康信息
	PreviousHistory string `json:"previousHistory"` //前科诊断
	PersonalHistory string `json:"personalHistory"` //个人历史
	FamilyHistory string `json:"familyHistory"` //家庭史
	PhysicalExamination string `json:"physicalExamination"` //身体检查
	Medicine string `json:"Medicine"` //药物
	TreatMent string `json:"treatMent"` //诊疗方案
}

//HistoryTransaction-PUB
type HistoryTransactionPUB struct {
	RFID   string `json:"RFID"`   //RFID of items
	SerialNumber string `json:"SerialNumber"` //serial number
	StartTime string `json:"StartTime"` //the earliest time of the item to collect
	EndTime string `json:"EndTime"` //deadline of the item to return
	PositionID string `json:"PositionID"` //ID of the position
	Address string `json:"Address"` //location of the machine
	Machine string `json:"Machine"` //smart lockers Machine
	LockerNumber string `json:"LockerNumber"` //number of the locker
	Action string `json:"Action"` //Owner Action
	OperateDate string `json:"OperateDate"` //date of operation
	OperateTime string `json:"OperateTime"` //time of operation
}
//HistoryTransaction-PRI
type HistoryTransactionPRI struct {
	RFID   string `json:"RFID"`   //RFID of items
	ItemDescription string `json:"ItemDescription"` //item description
	NickName string `json:"NickName"` //nick name
	Owner string `json:"Owner"` //owner of the item
	AuthCode string `json:"AuthCode"` //the code to collect items
	DelegatedTo string `json:"DelegatedTo"` //Delegated To
}

type QueryParam struct {
	EID string `json:"eID"` //keys start
}

//生成Key
func generateKey(stub shim.ChaincodeStubInterface, keyPrefix string, keyArray []string) (error, string) {
	if keyPrefix == "" {
		return errors.New("Invalid object name"), ""
	}
	key, _ := stub.CreateCompositeKey(keyPrefix, keyArray)
	return nil, key
}

