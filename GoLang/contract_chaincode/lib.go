package main

//ContractLedger-ALL
type ContractLedger struct {
	ContractNumber   string `json:"ContractNumber"`   //合同编号
	SignDate         string `json:"SignDate"`         //签署日期
	ContractHash     string `json:"ContractHash"`   //合同摘要
}

type QueryParam struct {
	ContractNumber string `json:"ContractNumber"` //合同编号
}

