package invoke

import (
	"bytes"
	"encoding/json"
	"fmt"
	"reflect"

	"github.com/hyperledger/fabric/core/chaincode/shim"
	pb "github.com/hyperledger/fabric/protos/peer"
)

type InvokeSpec struct {
	name      string        //name for this invoke
	runner    reflect.Value //func to run this invoke
	numOfArgs int           //num of argument to run this invoke
	template  string        //jsoned argement template
	inArg     reflect.Type
}

func NewSpec(name string, f interface{}) *InvokeSpec {
	if f == nil {
		return nil
	}

	self := &InvokeSpec{name: name}
	self.runner = reflect.ValueOf(f)
	if self.runner.Kind() != reflect.Func {
		return nil
	}
	rt := self.runner.Type()

	if rt.NumIn() != 2 ||
		rt.In(1).Kind() != reflect.Struct {
		return nil
	}
	self.inArg = rt.In(1)
	self.numOfArgs = self.inArg.NumField()

	buf := bytes.NewBuffer([]byte{})
	buf.WriteString("{")
	for i := 0; i < self.numOfArgs; i++ {
		sf := self.inArg.Field(i)
		key := fmt.Sprintf("\"%v\"", sf.Name)
		buf.WriteString(key)
		if sf.Type.Kind() != reflect.String {
			buf.WriteString(":%v")
		} else {
			buf.WriteString(":\"%v\"")
		}
		if i != self.numOfArgs-1 {
			buf.WriteString(",")
		}
	}
	buf.WriteString("}")
	self.template = buf.String()
	return self
}

func (self *InvokeSpec) Name() string {
	return self.name
}

func (self *InvokeSpec) Template() string {
	return self.template
}

func (self *InvokeSpec) NumOfArguments() int {
	return self.numOfArgs
}

func (self *InvokeSpec) Args(args []string) (*reflect.Value, error) {
	if len(args) != self.numOfArgs {
		return nil, NumOfArgumentsMismatch
	}

	iv := []interface{}{}
	for i := 0; i < len(args); i++ {
		iv = append(iv, args[i])
	}
	jsonStr := fmt.Sprintf(self.template, iv...)

	val := reflect.New(self.inArg).Interface()
	err := json.Unmarshal([]byte(jsonStr), val)
	if err != nil {
		return nil, TypeOfArgumentsMismatch
	}
	inval := reflect.Indirect(reflect.ValueOf(val))
	return &inval, nil
}

func (self *InvokeSpec) Invoke(stub shim.ChaincodeStubInterface, v *reflect.Value) pb.Response {
	if !self.runner.IsValid() {
		panic(IllegalInvocation)
	}
	args := []reflect.Value{reflect.ValueOf(stub), *v}
	rets := self.runner.Call(args)

	if len(rets) != 1 {
		panic(IllegalInvocation)
	}

	return rets[0].Interface().(pb.Response)
}

type Invoker struct {
	specs map[string]*InvokeSpec
}

func NewInvoker() *Invoker {
	return &Invoker{
		specs: map[string]*InvokeSpec{},
	}
}

func (self *Invoker) Add(spec *InvokeSpec) bool {
	if spec == nil {
		return false
	}
	self.specs[spec.Name()] = spec
	return true
}

func (self *Invoker) DecomposeStringArgs(args []string) (string, []string, error) {
	if len(args) == 0 {
		return "", nil, MissingSpecName
	}
	return args[0], args[1:], nil
}

func (self *Invoker) Invoke(stub shim.ChaincodeStubInterface, name string, args []string) pb.Response {
	spec, ok := self.specs[name]
	if !ok {
		return shim.Error(NotFound.Error())
	}
	varg, err := spec.Args(args)
	if err != nil {
		return shim.Error(err.Error())
	}

	return spec.Invoke(stub, varg)
}
