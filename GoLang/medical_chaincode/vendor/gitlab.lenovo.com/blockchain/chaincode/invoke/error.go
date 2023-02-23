package invoke

import "errors"

var (
	MissingSpecName         = errors.New("missing spec name")
	IllegalInvocation       = errors.New("illegal invocation")
	NotFound                = errors.New("No such invocation")
	NumOfArgumentsMismatch  = errors.New("num of invocation arguments mismatch")
	TypeOfArgumentsMismatch = errors.New("type of invocation arguments mismatch")
)
