package kmcc

import (
	"errors"
	"time"

	"github.com/hyperledger/fabric/core/chaincode/shim"
	pb "github.com/hyperledger/fabric/protos/peer"
	"gitlab.lenovo.com/blockchain/chaincode/invoke"

	logging "github.com/op/go-logging"
)

const (
	//ChaincodeName is pre-defined chaincode name
	ChaincodeName = "kmcc"
)

var (
	//ErrSeedNotFound the error when we couldn't find a seed value is the TransientMap
	ErrSeedNotFound = errors.New("essential seed value not found in TransientMap")

	chaincodeLogger = logging.MustGetLogger("kmcc")
)

//KMCC the chaincode to manage key and its seed
type KMCC struct {
	invoker *invoke.Invoker
}

//NewKMCC return a instance of KMCC
func NewKMCC() *KMCC {
	cc := &KMCC{
		invoker: invoke.NewInvoker(),
	}
	cc.invoker.Add(invoke.NewSpec("deploySeed", cc.DeploySeed))
	cc.invoker.Add(invoke.NewSpec("querySeed", cc.QuerySeed))
	cc.invoker.Add(invoke.NewSpec("getSecret", cc.GetSecret))
	cc.invoker.Add(invoke.NewSpec("getSecretByVersion", cc.GetSecretByVersion))
	return cc
}

//Init implements Chaincode.Init
func (kc *KMCC) Init(stub shim.ChaincodeStubInterface) pb.Response {
	return shim.Success([]byte("Ok"))
}

//Invoke implemtns Chaincode.Invoke
func (kc *KMCC) Invoke(stub shim.ChaincodeStubInterface) pb.Response {
	st := time.Now()
	args := stub.GetStringArgs()

	chaincodeLogger.Infof("handle invocaion, args: %v", args)

	name, input, err := kc.invoker.DecomposeStringArgs(args)
	if err != nil {
		chaincodeLogger.Errorf("chaincode args error: %s", err.Error())
		shim.Error(err.Error())
	}

	chaincodeLogger.Infof("kmcc invocaion costs: %dms", millisecondElapsed(st))
	return kc.invoker.Invoke(stub, name, input)
}
