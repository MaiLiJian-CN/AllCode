package main

import (
	"fmt"
	"encoding/json"
	"github.com/hyperledger/fabric/core/chaincode/shim"
	pb "github.com/hyperledger/fabric/protos/peer"
)


// History Transaction Ledger
func AppendDataLedger(stub shim.ChaincodeStubInterface, args []string) pb.Response {
	if len(args) != 1 {
		return shim.Error("Incorrect number of arguments. Expecting json to create/update Material Pulling Object")
	}
	jsonStr := args[0]
	var contractledgers []ContractLedger
	err := json.Unmarshal([]byte(jsonStr), &contractledgers)
	if err != nil {
		return shim.Error(err.Error())
	}
	for _, contractledger := range contractledgers {
		if contractledger.ContractNumber != "" {
			key := string(contractledger.ContractNumber)
			if err != nil {
				return shim.Error(err.Error())
			}
			fmt.Println("write ContractLedger data for Contract - " + key)
			var value []byte
			value, _ = json.Marshal(contractledger)
			err = stub.PutState(key, value)
			if err != nil {
				return shim.Error(err.Error())
			}
		} else {
			return shim.Error("ContractNumber is required")
		}
	}
	return shim.Success(nil)
}




