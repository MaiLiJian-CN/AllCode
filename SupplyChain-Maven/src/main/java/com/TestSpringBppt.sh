#!/bin/bash
#根据凭证历史id获取信息
getReceiptHistoryDetail(){
	read -p "请输入历史凭证：" rhID
	curl "${dir}getReceiptHistoryDetail?rhId=${rhID}"
	printf "\n"
}
#凭证id获取凭证交易历史
getAllReceiptHistoryIds(){
	read -p "请输入凭证Id：" rid
	#echo "${dir}getAllReceiptHistoryIds"
	curl "${dir}getAllReceiptHistoryIds?rid=${rid}"
	printf "\n"
}
#获取所有凭证交易历史
getAllReceiptHistory(){
	curl "${dir}getAllReceiptHistory"
	printf "\n"
}
#根据凭证id获取凭证信息
getReceiptDetail(){
	read -p "请输入凭证id：" rid
	curl "${dir}getReceiptDetail?rid=${rid}"
	printf "\n"
}

#交易部分
trans(){
success="Success"
#状态码
   message=`curl -i -k  -o /dev/null -s -w %{http_code} -H "Content-type: application/json" -X POST -d '{"rid":"2","send-company":"0x9cd28a5abbe8726b47973aaafd20a8ebb68044e6","receive-company":"0x378452addb98d9e58901c4bec04cb7c0563db097","account":"1"}' "${dir}trans" | awk -F ',' '{print}'`

   echo ${message}

 if [[ message -eq 200  ]]
then
	echo "Success"
	#echo ${message}
else
	echo "Error"
	#echo ${message}
fi

}

#启动函数
Init(){
dir="192.168.2.17:8080/index/"
methods=("getReceiptHistoryDetail" "getAllReceiptHistoryIds" "getAllReceiptHistory" "getReceiptDetail" "trans")
select TestName in ${methods[*]}
do
	case $TestName in
		"getReceiptHistoryDetail")
			getReceiptHistoryDetail
			;;
		"getAllReceiptHistoryIds")
			getAllReceiptHistoryIds
			;;
		"getAllReceiptHistory")
			getAllReceiptHistory
			;;
		"getReceiptDetail")
			getReceiptDetail
			;;
		"trans")
			trans
			;;
		*)
			echo "hhh"
	esac
done
}

Init

