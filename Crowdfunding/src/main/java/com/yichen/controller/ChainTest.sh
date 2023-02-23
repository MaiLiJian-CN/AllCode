#!/bin/bah

getDoneeCount(){
  echo "测试获取募资数量的方法"
  sleep 1
  echo  "当前募资的数量为："
  curl --request GET -sL \
       -G --url '192.168.2.17:8080/getDoneeCount'
  printf "\n"
}

setD_ee(){
  echo "设置募资人和募资金额"
  curl -X POST -H "Content-Type: application/json; charset=UTF-8" -d '{"addr":"0x9cd28a5abbe8726b47973aaafd20a8ebb68044e6","gold":2000,"name":"Shell脚本测试"}' 192.168.2.17:8080/addDone
  printf "\n"
}

donate(){
  echo "出资人捐赠"
  curl -X POST -H "Content-Type: application/json; charset=UTF-8" -d '{"doneID":2,"amount":1000}' 192.168.2.17:8080/donate
  printf "\n"
}

getDonee(){
  echo "获取募资项目信息"
  curl -X GET -H "Content-Type: application/json;charset=UTF-8" 192.168.2.17:8080/getDonee?dId=2
  printf "\n"
}

setStatus(){
  echo "修改状态"
  curl -X POST -H "Content-Type: application/json;charset=UTF-8" -d '{"dId":2,"status":"true"}' 192.168.2.17:8080/setStatus
  printf "\n"
}

getStatus(){
  echo "获取项目状态"
  curl -G -X GET -H "Content-Type: application/json;charset=UTF-8" 192.168.2.17:8080/getStatus?dId=2
}


init(){
  echo "先获取测试之前本有的筹募数量"
  getDoneeCount
  sleep 3
  echo "创建筹募项目"
  setD_ee
  sleep 3
  echo "查看状态"
  getStatus
  sleep 3
  echo "修改状态"
  setStatus
  sleep 3
  echo "再次查看状态"
  getStatus
  sleep 3
  echo "出资"
  donate
  sleep 3
  echo "查看项目"
  getDonee
  sleep 3
  echo "最后获取项目数量"
  getDoneeCount

}
init
