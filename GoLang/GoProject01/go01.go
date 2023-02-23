package main

import (
	"encoding/json"
	"errors"
	"fmt"
	"math"
	"net/http"
	"os"
	"os/exec"
)

func main01() {
	http.Handle("/", http.FileServer(http.Dir(".")))
	http.ListenAndServe("localhost:8080", nil)
}
func main02() {
	fmt.Println("HelloWorld")
}
func main03() {
	var a = "initial"
	var b, c int = 1, 2
	var d = true
	var e float64
	f := float32(e)
	g := a + "foo"
	fmt.Println(a, b, c, d, e, f, g)
	const s string = "constant"
	const h = 500000
	const i = 3e20 / h
	fmt.Println(s, h, i, math.Sin(h), math.Sin(i))
}
func main04() {
	var a [5]int
	a[4] = 100
	fmt.Println(a[4], len(a))

	b := [5]int{1, 2, 3, 4, 5}
	fmt.Println(b)

	var towD [3][3]int
	for i := 0; i < len(towD); i++ {
		for j := 0; j < len(towD[i]); j++ {
			towD[i][j] = i + j
		}
	}
	fmt.Println("2D:", towD)

}

//切片
func main05() {
	s := make([]string, 3)
	s[0] = "a"
	s[1] = "b"
	s[2] = "c"
	fmt.Println("get:", s[2])
	fmt.Println("len:", len(s))

	s = append(s, "d")
	s = append(s, "e", "f")
	fmt.Println(s)

	c := make([]string, len(s))
	copy(c, s)
	fmt.Println(c)

	fmt.Println(s[2:5])
	fmt.Println(s[:5])
	fmt.Println(s[2:])

	good := []string{"g", "o", "o", "d"}
	fmt.Println(good)
}

//map
func main06() {
	m := make(map[string]int)
	m["one"] = 1
	m["two"] = 2
	fmt.Println(m)
	fmt.Println(len(m))
	fmt.Println(m["one"])
	fmt.Println(m["unknown"])

	r, ok := m["unknown"]
	fmt.Println(r, ok)

	delete(m, "one")

	m2 := map[string]int{"one": 1, "two": 2}
	var m3 = map[string]int{"one": 1, "two": 2}
	fmt.Println(m2, m3)
}

//range
func main07() {
	nums := []int{2, 3, 4}
	sum := 0
	for i, num := range nums {
		sum += num
		if num == 4 {
			fmt.Println("index:", i, "num", num)
		}
	}
	fmt.Println(sum)

	m := map[string]string{"a": "A", "b": "B"}
	for k, v := range m {
		fmt.Println("key:", k, "value:", v)
	}
	for k := range m {
		fmt.Println("key", k)
	}
}

//函数
func add(a int, b int) int {
	return a + b
}
func add2(a, b int) int {
	return a + b
}
func exists(m map[string]string, k string) (v string, ok bool) {
	v, ok = m[k]
	return v, ok
}
func main08() {
	res := add(2, 3)
	fmt.Println(res)

	v, ok := exists(map[string]string{"a": "A"}, "a")
	fmt.Println(v, ok)
}

//指针
func add2ptr(p *int) {
	*p++
}
func main09() {
	n := 5
	add2ptr(&n)
	fmt.Println(n)
}

//结构体
type user struct {
	name     string
	password string
}

func checkPasswd(u user, pwd string) bool {
	return u.password == pwd
}
func checkPasswd2(u *user, pwd string) bool {
	return u.password == pwd
}
func main10() {
	a := user{name: "麦立健", password: "mlj5201314"}
	b := user{"mlj", "123"}
	c := user{name: "mlj"}
	c.password = "1234"
	var d user
	d.name = "d"
	d.password = "dd"
	fmt.Println(a, b, c, d)
	fmt.Println(checkPasswd(a, "aa"))
	fmt.Println(checkPasswd2(&a, "haha"))
}

//错误处理机制
func findUser(users []user, name string) (v *user, err error) {
	for _, u := range users {
		if u.name == name {
			return &u, nil
		}
	}
	return nil, errors.New("not Found")
}
func main11() {
	u, err := findUser([]user{{"wang", "123"}}, "wang")
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Println(u.name)

	if u, err := findUser([]user{{"wang", "123"}}, "wang"); err != nil {
		fmt.Println(err)
		return
	} else {
		fmt.Println(u)
	}
}

//字符串格式化
type point struct {
	x, y int
}

func main12() {
	p := point{1, 2}
	s := "Hello"
	n := 123
	fmt.Printf("p=%v\n", p)
	fmt.Printf("p=%+v\n", p)
	fmt.Printf("p=%#v\n", p)
	fmt.Printf("s=%v\n", s)
	fmt.Printf("n=%v\n", n)

	f := 3.14159265358
	fmt.Printf("%.2f", f)
}

//JSON处理
type userInfo struct {
	Name  string   `json:"name"`
	Age   int      `json:"age"`
	Hobby []string `json:"hobby"`
}

func main13() {
	a := userInfo{Age: 18, Name: "mlj", Hobby: []string{"Golang", "TypeScript"}}
	buf, err := json.Marshal(a)
	if err != nil {
		fmt.Println(err)
	}
	fmt.Println(buf)
	fmt.Println(string(buf))

	buf, err = json.MarshalIndent(a, "", "\t")
	if err != nil {
		panic(err)
	}
	fmt.Printf(string(buf))

	var b userInfo
	err = json.Unmarshal(buf, &b)
	if err != nil {
		panic(err)
	}
	fmt.Printf("%v\n", b)
}

func main14() {
	fmt.Println(os.Args)
	fmt.Println(os.Getenv("PATH"))
	buf, err := exec.Command("grep", "NodeJs", os.Getenv("PATH")).CombinedOutput()
	if err != nil {
		panic(err)
	}
	fmt.Printf(string(buf))
}
