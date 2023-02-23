package main

import (
	"fmt"
	"github.com/hyperledger/fabric/core/chaincode/shim"
	pb "github.com/hyperledger/fabric/protos/peer"
)

var logger = shim.NewLogger("contract")

type SmartContract struct {
}

func (t *SmartContract) Init(stub shim.ChaincodeStubInterface) pb.Response {
	// do nothing
	return shim.Success(nil)
}

func (t *SmartContract) Invoke(stub shim.ChaincodeStubInterface) pb.Response {
	function, args := stub.GetFunctionAndParameters()
	fmt.Println("starting invoke, for - " + function)
	fmt.Println("starting invoke, args - ", args)
	if function == "init" {
		return t.Init(stub)
	} else if function == "CreateContract" {
		return AppendDataLedger(stub, args)
	} else if function == "SearchContract" {
		return QueryDataLedger(stub, args)
	} 
	fmt.Println("Received unknown invoke function name - " + function)
	return shim.Error("Received unknown invoke function name - '" + function + "'")
}

func (t *SmartContract) query(stub shim.ChaincodeStubInterface) pb.Response {
	return shim.Error("Unknown supported call - Query()")
}

func main() {
	err := shim.Start(new(SmartContract))
	if err != nil {
		logger.Errorf("Error starting smartcontract chaincode: %s", err)
	}
}
