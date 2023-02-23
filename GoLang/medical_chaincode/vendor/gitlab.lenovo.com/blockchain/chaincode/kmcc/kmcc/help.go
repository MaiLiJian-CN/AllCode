package kmcc

import (
	"crypto/sha256"
	"encoding/json"
	"strings"
	"time"
)

func (kc *KMCC) pack(v *SeedValue) ([]byte, error) {
	return json.Marshal(v)
}

func (kc *KMCC) unpack(b []byte) (*SeedValue, error) {
	sv := &SeedValue{}
	err := json.Unmarshal(b, sv)
	return sv, err
}

func (kc *KMCC) generateSecret(seed, txid []byte) []byte {
	buf := []byte{}
	buf = append(buf, seed...)
	buf = append(buf, txid...)
	secret := sha256.Sum256(buf)
	return secret[:]
}

func (kc *KMCC) pvtdataNotAvailableErr(err error) bool{
	subStr := "private data matching public hash version is not available"
	if err == nil {
		return false
	}
	return strings.Contains(err.Error(), subStr)
}

func millisecondElapsed(last time.Time) int64 {
	return time.Now().Sub(last).Nanoseconds() / 1e6
}
