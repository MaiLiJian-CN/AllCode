package com.yichen.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.Charset;


@Slf4j
@RequestMapping("/index")
@RestController
public class AuctionController {

    private final String CONTRACT_NAME="Actor";
    private final String CONTRACT_ADDRESS="0xdd882735b32e8ed0201096a20e74377a2636863d";
    private final String USER_ADDRESS="0x56e0155a1a5ac57d858a83cfaf08a6ccda827564";
//    private final String CONTRACT_ABI="[{\"constant\":false,\"inputs\":[{\"name\":\"_id\",\"type\":\"uint256\"},{\"name\":\"_name\",\"type\":\"string\"},{\"name\":\"_limit\",\"type\":\"uint256\"},{\"name\":\"_message\",\"type\":\"string\"}],\"name\":\"putOn\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"currentStone\",\"outputs\":[{\"name\":\"id\",\"type\":\"uint256\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"limit\",\"type\":\"uint256\"},{\"name\":\"message\",\"type\":\"string\"},{\"name\":\"result\",\"type\":\"bool\"},{\"name\":\"winner\",\"type\":\"address\"},{\"name\":\"price\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"pickAddr\",\"type\":\"address\"},{\"name\":\"_price\",\"type\":\"uint256\"}],\"name\":\"pick\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"isStart\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"history\",\"outputs\":[{\"name\":\"id\",\"type\":\"uint256\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"limit\",\"type\":\"uint256\"},{\"name\":\"message\",\"type\":\"string\"},{\"name\":\"result\",\"type\":\"bool\"},{\"name\":\"winner\",\"type\":\"address\"},{\"name\":\"price\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"start\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"end\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";
//    private final String CONTRACT_ABI="[{\"constant\":false,\"inputs\":[{\"name\":\"_id\",\"type\":\"uint256\"},{\"name\":\"_name\",\"type\":\"string\"},{\"name\":\"_limit\",\"type\":\"uint256\"},{\"name\":\"_message\",\"type\":\"string\"}],\"name\":\"putOn\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"currentStone\",\"outputs\":[{\"name\":\"id\",\"type\":\"uint256\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"limit\",\"type\":\"uint256\"},{\"name\":\"message\",\"type\":\"string\"},{\"name\":\"result\",\"type\":\"bool\"},{\"name\":\"winner\",\"type\":\"address\"},{\"name\":\"price\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"pickAddr\",\"type\":\"address\"},{\"name\":\"_price\",\"type\":\"uint256\"}],\"name\":\"pick\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"isStart\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"history\",\"outputs\":[{\"name\":\"id\",\"type\":\"uint256\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"limit\",\"type\":\"uint256\"},{\"name\":\"message\",\"type\":\"string\"},{\"name\":\"result\",\"type\":\"bool\"},{\"name\":\"winner\",\"type\":\"address\"},{\"name\":\"price\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"start\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"end\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";
    private final String CONTRACT_ABI="[{\"constant\":false,\"inputs\":[{\"name\":\"_id\",\"type\":\"uint256\"},{\"name\":\"_name\",\"type\":\"string\"},{\"name\":\"_limit\",\"type\":\"uint256\"},{\"name\":\"_message\",\"type\":\"string\"}],\"name\":\"putOn\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"currentStone\",\"outputs\":[{\"name\":\"id\",\"type\":\"uint256\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"limit\",\"type\":\"uint256\"},{\"name\":\"message\",\"type\":\"string\"},{\"name\":\"result\",\"type\":\"bool\"},{\"name\":\"winner\",\"type\":\"address\"},{\"name\":\"price\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"pickAddr\",\"type\":\"address\"},{\"name\":\"_price\",\"type\":\"uint256\"}],\"name\":\"pick\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"id\",\"type\":\"uint256\"}],\"name\":\"getMessage\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"isStart\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"start\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"end\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";
    private final String URL="http://192.168.22.131:5002/WeBASE-Front/trans/handle";

    @ResponseBody
    @PostMapping("/putOn")
    public String putOn(@RequestBody JSONObject jsonObject){

        JSONObject _outJson=new JSONObject();
        if (jsonObject==null){
            _outJson.put("error","the data is invalid");
            return _outJson.toJSONString();
        }
        JSONObject _httpJson=new JSONObject();
        Object id = jsonObject.get("id");
        Object name = jsonObject.get("name");
        Object limit = jsonObject.get("limit");
        Object message = jsonObject.get("message");

        Object[] param={id,name,limit,message};
        _httpJson.put("contractName",CONTRACT_NAME);
        _httpJson.put("contractAbi", JSONArray.parseArray(CONTRACT_ABI));
        _httpJson.put("contractAddress",CONTRACT_ADDRESS);
        _httpJson.put("funcName","putOn");
        _httpJson.put("user",USER_ADDRESS);
        _httpJson.put("funcParam",param);
        String response = httpPost(URL, _httpJson.toJSONString());
        JSONObject object = JSON.parseObject(response);
        String info  = object.getString("message");
        if (info.equals("Success")){
            _outJson.put("info",object);
        }else {
            _outJson.put("error",object);
        }
        return _outJson.toJSONString();
    }


    @ResponseBody
    @PostMapping("/start")
    public String start(){
        JSONObject _outJson=new JSONObject();
        JSONObject _httpJson=new JSONObject();


        _httpJson.put("contractName",CONTRACT_NAME);
        _httpJson.put("contractAbi", JSONArray.parseArray(CONTRACT_ABI));
        _httpJson.put("contractAddress",CONTRACT_ADDRESS);
        _httpJson.put("funcName","start");
        _httpJson.put("user",USER_ADDRESS);
        String response = httpPost(URL, _httpJson.toJSONString());
        JSONObject object = JSON.parseObject(response);
        String info  = object.getString("message");
        if (info.equals("Success")){
            _outJson.put("info",object);
        }else {
            _outJson.put("error",object);
        }
        return _outJson.toJSONString();
    }

    @ResponseBody
    @PostMapping("/pick")
    public String pick(@RequestBody JSONObject jsonObject){

        JSONObject _outJson=new JSONObject();
        if (jsonObject==null){
            _outJson.put("error","the data is invalid");
            return _outJson.toJSONString();
        }
        JSONObject _httpJson=new JSONObject();
        Object address = jsonObject.get("address");
        Object price = jsonObject.get("price");

        Object[] param={address,price};
        _httpJson.put("contractName",CONTRACT_NAME);
        _httpJson.put("contractAbi", JSONArray.parseArray(CONTRACT_ABI));
        _httpJson.put("contractAddress",CONTRACT_ADDRESS);
        _httpJson.put("funcName","pick");
        _httpJson.put("user",USER_ADDRESS);
        _httpJson.put("funcParam",param);
        String response = httpPost(URL, _httpJson.toJSONString());
        JSONObject object = JSON.parseObject(response);
        String info  = object.getString("message");
        if (info.equals("Success")){
            _outJson.put("info",object);
        }else {
            _outJson.put("error",object);
        }
        return _outJson.toJSONString();
    }

    @ResponseBody
    @GetMapping("/end")
    public String end(){
        JSONObject _outJson=new JSONObject();
        JSONObject _httpJson=new JSONObject();


        _httpJson.put("contractName",CONTRACT_NAME);
        _httpJson.put("contractAbi", JSONArray.parseArray(CONTRACT_ABI));
        _httpJson.put("contractAddress",CONTRACT_ADDRESS);
        _httpJson.put("funcName","end");
        _httpJson.put("user",USER_ADDRESS);
        String response = httpPost(URL, _httpJson.toJSONString());
        JSONObject object = JSON.parseObject(response);
        String info  = object.getString("message");
        if (info.equals("Success")){
            _outJson.put("info",object);
        }else {
            _outJson.put("error",object);
        }
        return _outJson.toJSONString();
    }


    @ResponseBody
    @GetMapping("/getMessage")
    public String getMessage(@RequestParam Integer data){
        JSONObject _jsonObj=new JSONObject();
        JSONObject _httpJson=new JSONObject();
        Object[] param={data};
        _httpJson.put("contractName",CONTRACT_NAME);
        _httpJson.put("contractAbi", JSONArray.parseArray(CONTRACT_ABI));
        _httpJson.put("contractAddress",CONTRACT_ADDRESS);
        _httpJson.put("funcName","getMessage");
        _httpJson.put("user",USER_ADDRESS);
        _httpJson.put("funcParam",param);
        String response = httpPost(URL, _httpJson.toJSONString());
        JSONArray objects = JSON.parseArray(response);
        _jsonObj.put("id",objects.get(0));
        _jsonObj.put("name",objects.get(1));
        _jsonObj.put("winner",objects.get(2));
        _jsonObj.put("price",objects.get(3));
        return _jsonObj.toJSONString();
    }

    /**
     * 发送 post 请求
     * @param url     请求地址
     * @param jsonStr Form表单json字符串
     * @return 请求结果
     */
    private String httpPost(String url, String jsonStr) {
        // 创建httpClient
        CloseableHttpClient httpClient=HttpClients.createDefault();
        // 创建post请求方式实例
        HttpPost httpPost=new HttpPost(url);
        // 设置请求头 发送的是json数据格式
        httpPost.setHeader("Content-type","application/json;charset=utf-8");
        // 设置参数---设置消息实体 也就是携带的数据
        StringEntity entity=new StringEntity(jsonStr,Charset.forName("UTF-8"));
        // 设置编码格式
        entity.setContentEncoding("UTF-8");
        // 发送Json格式的数据请求
        entity.setContentType("application/json");
        // 把请求消息实体塞进去
        httpPost.setEntity(entity);
        // 执行http的post请求
        String result=null;
        try {
            CloseableHttpResponse execute = httpClient.execute(httpPost);
            result=EntityUtils.toString(execute.getEntity(),"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
