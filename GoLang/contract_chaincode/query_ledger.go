package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"github.com/hyperledger/fabric/core/chaincode/shim"
	pb "github.com/hyperledger/fabric/protos/peer"
)


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
	if param.ContractNumber == "" {
		return shim.Error("Query condition is required")
	}
	queryKey := string(param.ContractNumber)
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
		buffer.WriteString(string(queryResponse.Value))
		bArrayMemberAlreadyWritten = true
	}
	buffer.WriteString("]")
	return shim.Success(buffer.Bytes())
}
