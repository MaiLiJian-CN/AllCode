// Code generated by protoc-gen-go. DO NOT EDIT.
// source: ledger/queryresult/kv_query_result.proto

package queryresult // import "github.com/hyperledger/fabric/protos/ledger/queryresult"

import proto "github.com/golang/protobuf/proto"
import fmt "fmt"
import math "math"
import timestamp "github.com/golang/protobuf/ptypes/timestamp"

// Reference imports to suppress errors if they are not otherwise used.
var _ = proto.Marshal
var _ = fmt.Errorf
var _ = math.Inf

// This is a compile-time assertion to ensure that this generated file
// is compatible with the proto package it is being compiled against.
// A compilation error at this line likely means your copy of the
// proto package needs to be updated.
const _ = proto.ProtoPackageIsVersion2 // please upgrade the proto package

// KV -- QueryResult for range/execute query. Holds a key and corresponding value.
type KV struct {
	Namespace            string   `protobuf:"bytes,1,opt,name=namespace,proto3" json:"namespace,omitempty"`
	Key                  string   `protobuf:"bytes,2,opt,name=key,proto3" json:"key,omitempty"`
	Value                []byte   `protobuf:"bytes,3,opt,name=value,proto3" json:"value,omitempty"`
	XXX_NoUnkeyedLiteral struct{} `json:"-"`
	XXX_unrecognized     []byte   `json:"-"`
	XXX_sizecache        int32    `json:"-"`
}

func (m *KV) Reset()         { *m = KV{} }
func (m *KV) String() string { return proto.CompactTextString(m) }
func (*KV) ProtoMessage()    {}
func (*KV) Descriptor() ([]byte, []int) {
	return fileDescriptor_kv_query_result_edefcebf79bb7949, []int{0}
}
func (m *KV) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_KV.Unmarshal(m, b)
}
func (m *KV) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_KV.Marshal(b, m, deterministic)
}
func (dst *KV) XXX_Merge(src proto.Message) {
	xxx_messageInfo_KV.Merge(dst, src)
}
func (m *KV) XXX_Size() int {
	return xxx_messageInfo_KV.Size(m)
}
func (m *KV) XXX_DiscardUnknown() {
	xxx_messageInfo_KV.DiscardUnknown(m)
}

var xxx_messageInfo_KV proto.InternalMessageInfo

func (m *KV) GetNamespace() string {
	if m != nil {
		return m.Namespace
	}
	return ""
}

func (m *KV) GetKey() string {
	if m != nil {
		return m.Key
	}
	return ""
}

func (m *KV) GetValue() []byte {
	if m != nil {
		return m.Value
	}
	return nil
}

// KeyModification -- QueryResult for history query. Holds a transaction ID, value,
// timestamp, and delete marker which resulted from a history query.
type KeyModification struct {
	TxId                 string               `protobuf:"bytes,1,opt,name=tx_id,json=txId,proto3" json:"tx_id,omitempty"`
	Value                []byte               `protobuf:"bytes,2,opt,name=value,proto3" json:"value,omitempty"`
	Timestamp            *timestamp.Timestamp `protobuf:"bytes,3,opt,name=timestamp,proto3" json:"timestamp,omitempty"`
	IsDelete             bool                 `protobuf:"varint,4,opt,name=is_delete,json=isDelete,proto3" json:"is_delete,omitempty"`
	BlockNum             uint64               `protobuf:"varint,5,opt,name=block_num,json=blockNum,proto3" json:"block_num,omitempty"`
	TxNum                uint64               `protobuf:"varint,6,opt,name=tx_num,json=txNum,proto3" json:"tx_num,omitempty"`
	XXX_NoUnkeyedLiteral struct{}             `json:"-"`
	XXX_unrecognized     []byte               `json:"-"`
	XXX_sizecache        int32                `json:"-"`
}

func (m *KeyModification) Reset()         { *m = KeyModification{} }
func (m *KeyModification) String() string { return proto.CompactTextString(m) }
func (*KeyModification) ProtoMessage()    {}
func (*KeyModification) Descriptor() ([]byte, []int) {
	return fileDescriptor_kv_query_result_edefcebf79bb7949, []int{1}
}
func (m *KeyModification) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_KeyModification.Unmarshal(m, b)
}
func (m *KeyModification) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_KeyModification.Marshal(b, m, deterministic)
}
func (dst *KeyModification) XXX_Merge(src proto.Message) {
	xxx_messageInfo_KeyModification.Merge(dst, src)
}
func (m *KeyModification) XXX_Size() int {
	return xxx_messageInfo_KeyModification.Size(m)
}
func (m *KeyModification) XXX_DiscardUnknown() {
	xxx_messageInfo_KeyModification.DiscardUnknown(m)
}

var xxx_messageInfo_KeyModification proto.InternalMessageInfo

func (m *KeyModification) GetTxId() string {
	if m != nil {
		return m.TxId
	}
	return ""
}

func (m *KeyModification) GetValue() []byte {
	if m != nil {
		return m.Value
	}
	return nil
}

func (m *KeyModification) GetTimestamp() *timestamp.Timestamp {
	if m != nil {
		return m.Timestamp
	}
	return nil
}

func (m *KeyModification) GetIsDelete() bool {
	if m != nil {
		return m.IsDelete
	}
	return false
}

func (m *KeyModification) GetBlockNum() uint64 {
	if m != nil {
		return m.BlockNum
	}
	return 0
}

func (m *KeyModification) GetTxNum() uint64 {
	if m != nil {
		return m.TxNum
	}
	return 0
}

func init() {
	proto.RegisterType((*KV)(nil), "queryresult.KV")
	proto.RegisterType((*KeyModification)(nil), "queryresult.KeyModification")
}

func init() {
	proto.RegisterFile("ledger/queryresult/kv_query_result.proto", fileDescriptor_kv_query_result_edefcebf79bb7949)
}

var fileDescriptor_kv_query_result_edefcebf79bb7949 = []byte{
	// 320 bytes of a gzipped FileDescriptorProto
	0x1f, 0x8b, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x02, 0xff, 0x64, 0x51, 0x4b, 0x4b, 0xeb, 0x40,
	0x14, 0x26, 0x6d, 0x53, 0x9a, 0xe9, 0x85, 0x7b, 0x99, 0x7b, 0x2f, 0x84, 0x2a, 0x18, 0xba, 0xca,
	0x6a, 0x46, 0x74, 0xa1, 0x6b, 0x71, 0xa3, 0xc5, 0x2e, 0x82, 0xb8, 0x70, 0x13, 0xf2, 0x38, 0x4d,
	0x87, 0x64, 0x3a, 0x71, 0x1e, 0x25, 0xf9, 0x85, 0xfe, 0x2d, 0xe9, 0x4c, 0x6b, 0x03, 0xee, 0xce,
	0xf7, 0x3a, 0x7c, 0x9c, 0x83, 0xe2, 0x06, 0xca, 0x0a, 0x24, 0xfd, 0x30, 0x20, 0x7b, 0x09, 0xca,
	0x34, 0x9a, 0xd6, 0xfb, 0xd4, 0xc2, 0xd4, 0x61, 0xd2, 0x4a, 0xa1, 0x05, 0x9e, 0x0f, 0x2c, 0x8b,
	0xab, 0x4a, 0x88, 0xaa, 0x01, 0x6a, 0xa5, 0xdc, 0x6c, 0xa8, 0x66, 0x1c, 0x94, 0xce, 0x78, 0xeb,
	0xdc, 0xcb, 0x67, 0x34, 0x5a, 0xbd, 0xe1, 0x4b, 0x14, 0xec, 0x32, 0x0e, 0xaa, 0xcd, 0x0a, 0x08,
	0xbd, 0xc8, 0x8b, 0x83, 0xe4, 0x4c, 0xe0, 0x3f, 0x68, 0x5c, 0x43, 0x1f, 0x8e, 0x2c, 0x7f, 0x18,
	0xf1, 0x3f, 0xe4, 0xef, 0xb3, 0xc6, 0x40, 0x38, 0x8e, 0xbc, 0xf8, 0x57, 0xe2, 0xc0, 0xf2, 0xd3,
	0x43, 0xbf, 0x57, 0xd0, 0xbf, 0x88, 0x92, 0x6d, 0x58, 0x91, 0x69, 0x26, 0x76, 0xf8, 0x2f, 0xf2,
	0x75, 0x97, 0xb2, 0xf2, 0xb8, 0x75, 0xa2, 0xbb, 0xa7, 0xf2, 0x1c, 0x1f, 0x0d, 0xe2, 0xf8, 0x1e,
	0x05, 0xdf, 0xed, 0xec, 0xe2, 0xf9, 0xcd, 0x82, 0xb8, 0xfe, 0xe4, 0xd4, 0x9f, 0xbc, 0x9e, 0x1c,
	0xc9, 0xd9, 0x8c, 0x2f, 0x50, 0xc0, 0x54, 0x5a, 0x42, 0x03, 0x1a, 0xc2, 0x49, 0xe4, 0xc5, 0xb3,
	0x64, 0xc6, 0xd4, 0xa3, 0xc5, 0x07, 0x31, 0x6f, 0x44, 0x51, 0xa7, 0x3b, 0xc3, 0x43, 0x3f, 0xf2,
	0xe2, 0x49, 0x32, 0xb3, 0xc4, 0xda, 0x70, 0xfc, 0x1f, 0x4d, 0x75, 0x67, 0x95, 0xa9, 0x55, 0x7c,
	0xdd, 0xad, 0x0d, 0x7f, 0xa8, 0xd1, 0xb5, 0x90, 0x15, 0xd9, 0xf6, 0x2d, 0x48, 0x77, 0x78, 0xb2,
	0xc9, 0x72, 0xc9, 0x0a, 0x57, 0x44, 0x91, 0x23, 0x39, 0x38, 0xf5, 0xfb, 0x5d, 0xc5, 0xf4, 0xd6,
	0xe4, 0xa4, 0x10, 0x9c, 0x0e, 0x82, 0xd4, 0x05, 0xdd, 0x07, 0x14, 0xfd, 0xf9, 0xc6, 0x7c, 0x6a,
	0xa5, 0xdb, 0xaf, 0x00, 0x00, 0x00, 0xff, 0xff, 0x22, 0x79, 0xba, 0xd4, 0xe3, 0x01, 0x00, 0x00,
}
