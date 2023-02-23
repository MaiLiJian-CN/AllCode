package kmcc

import pb "github.com/hyperledger/fabric/protos/peer"

const (
	//SeedKey is the seed key name when store the seed value into a collection
	SeedKey = "seed"
	//HistoryKeyPattern is the format pattern used to gen the real key when a history
	//seed value is stored into a collection
	HistoryKeyPattern = "seed_%d"
)

//SeedValue try to link all the history seed values as a linkedlist, so it can be
//traversed
type SeedValue struct {
	//current seed value
	Seed []byte `json:"seed"`

	//pre seed version
	PreVersion *pb.StateVersion `json:"pre"`
}
