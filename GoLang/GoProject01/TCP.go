package main

import (
	"bufio"
	"net"
)

func main() {
	server, err := net.Listen("tcp", "127.0.0.1:8080")
	if err != nil {
		panic(err)
	}
	for {
		client, err := server.Accept()
		if err != nil {
			panic(err)
			continue
		}
		go process(client)
	}
}
func process(con net.Conn) {
	defer con.Close()
	reader := bufio.NewReader(con)
	for {
		b, err := reader.ReadByte()
		if err != nil {
			break
		}
		_, err = con.Write([]byte{b})
		if err != nil {
			break
		}
	}
}
