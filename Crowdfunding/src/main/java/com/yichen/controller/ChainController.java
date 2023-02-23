package com.yichen.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@RestController

@Slf4j
public class ChainController {
    private static final String URL = "http://192.168.22.131:5002/WeBASE-Front/trans/handle";
    private static final String CONTRACT_ADDRESS="0x6ca83a5e6e2fc804eac93969151c928c611209b2";
    private static final String CONTRACT_ABI="[{\"constant\":false,\"inputs\":[{\"name\":\"_doneeID\",\"type\":\"uint256\"},{\"name\":\"_amount\",\"type\":\"uint256\"}],\"name\":\"donate\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"doneeID\",\"type\":\"uint256\"}],\"name\":\"getStatus\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_doneeID\",\"type\":\"uint256\"}],\"name\":\"getDonee\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"destory\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_addr\",\"type\":\"address\"},{\"name\":\"_gold\",\"type\":\"uint256\"},{\"name\":\"_projectName\",\"type\":\"string\"}],\"name\":\"setDonee\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"doneeID\",\"type\":\"uint256\"},{\"name\":\"status\",\"type\":\"bool\"}],\"name\":\"setStatus\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getDoneeCount\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";
    private static final String CONTRACT_NAME="Crowdfunding";
    private static final String D_OR="0xf8db15d8f9e9b85e2198ea8f2442ddc55a7823c7";
    private static final String D_EE="0x6845fdc00e8017c6af99ac198a4bf141364b0ca5";
    private static final String CONTRACT_USER="0xa55b95b2a57d55d739bed383730172cee1dccf77";

    @ResponseBody
    @PostMapping("/destroy")
    public String destroy(){
        JSONObject _outJson=new JSONObject();
        JSONObject _jsonObj=new JSONObject();
        _jsonObj.put("contractName",CONTRACT_NAME);
        _jsonObj.put("contractAddress",CONTRACT_ADDRESS);
        _jsonObj.put("contractAbi",JSONArray.parseArray(CONTRACT_ABI));
        _jsonObj.put("funcName","destory");
        _jsonObj.put("user",CONTRACT_USER);
        String response  = httpPost(URL, _jsonObj.toJSONString());
        JSONObject object = JSON.parseObject(response);
        String message = object.getString("message");
        _outJson.put("msg",message);
        return _outJson.toJSONString();
    }

    /**
     * // 设置募资人和募资金额
     * @param data 项目
     * @return 消息
     */
    @ResponseBody
    @PostMapping("addDone")
    public String setD_ee(@RequestBody JSONObject data){
        JSONObject _outJson=new JSONObject();
        if (data==null){
            _outJson.put("msg","The data is invalid");
            return _outJson.toJSONString();
        }
        Object _addr = data.get("addr");
        Object _gold = data.get("gold");
        Object _projectName = data.get("name");
        Object[] param={_addr,_gold,_projectName};
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("contractName",CONTRACT_NAME);
        jsonObject.put("contractAddress",CONTRACT_ADDRESS);
        jsonObject.put("contractAbi", JSONArray.parseArray(CONTRACT_ABI));
        jsonObject.put("funcName","setDonee");
        jsonObject.put("funcParam",param);
        jsonObject.put("user",CONTRACT_USER);
        String response = httpPost(URL, jsonObject.toJSONString());
        JSONObject result = JSON.parseObject(response);
        String message = result.getString("message");
        log.info(message);
        _outJson.put("msg",message);
        return _outJson.toJSONString();
    }

    /**
     * 出资人捐赠
     * @param data
     * @return
     */
    @ResponseBody
    @PostMapping("/donate")
    public String donate(@RequestBody JSONObject data) {
        JSONObject _outJson = new JSONObject();
        if (data == null) {
            _outJson.put("msg", "the day is invalid");
            return _outJson.toJSONString();
        }
        //发送数据的准备
        JSONObject _jsonObj = new JSONObject();
        Object doneID = data.get("doneID");
        Object amount = data.get("amount");
        Object[] param = {doneID, amount};

        _jsonObj.put("contractName", CONTRACT_NAME);
        _jsonObj.put("contractAddress", CONTRACT_ADDRESS);
        _jsonObj.put("contractAbi", JSONArray.parseArray(CONTRACT_ABI));
        _jsonObj.put("funcName", "donate");
        _jsonObj.put("funcParam", param);
        _jsonObj.put("user", D_OR);
        String response = httpPost(URL, _jsonObj.toJSONString());
        JSONObject jsonObject = JSON.parseObject(response);
        String message = jsonObject.getString("message");
        if ("Success".equals(message)) {
            _outJson.put("msg", jsonObject.toJSONString());
        } else {
            _outJson.put("msg", message);
        }
        return _outJson.toJSONString();
    }

    /**
     * 获取募资数量
     * @return 数量
     */
    @GetMapping("/getDoneeCount")
    @ResponseBody
    public String getDoneeCount(){
        JSONObject jsonObject=new JSONObject();

        jsonObject.put("contractName",CONTRACT_NAME);
        jsonObject.put("contractAddress",CONTRACT_ADDRESS);
        jsonObject.put("contractAbi",JSONArray.parseArray(CONTRACT_ABI));
        jsonObject.put("funcName","getDoneeCount");
        jsonObject.put("user",CONTRACT_USER);
        String response = httpPost(URL, jsonObject.toJSONString());
        JSONArray _outJson = JSON.parseArray(response);
        Object o = _outJson.get(0);
        return o.toString();
    }

    /**
     * 获取募资项目信息
     * @param dId 项目编号
     * @return 信息
     */
    @ResponseBody
    @GetMapping("/getDonee")
    public String getDonee(@RequestParam Integer dId){
        JSONObject _outJson=new JSONObject();
        if (dId==null){
            _outJson.put("msg","The dId is invalid");
            return _outJson.toJSONString();
        }

        JSONObject _jsonObj=new JSONObject();
        Object[] param={dId};
        _jsonObj.put("contractName",CONTRACT_NAME);
        _jsonObj.put("contractAddress",CONTRACT_ADDRESS);
        _jsonObj.put("contractAbi",JSONArray.parseArray(CONTRACT_ABI));
        _jsonObj.put("funcName","getDonee");
        _jsonObj.put("user",CONTRACT_USER);
        _jsonObj.put("funcParam",param);
        String response = httpPost(URL, _jsonObj.toJSONString());
        JSONArray jsonObject = JSON.parseArray(response);
        _outJson.put("募资人地址",jsonObject.get(0));
        _outJson.put("募资预定资金",jsonObject.get(1));
        _outJson.put("募资项目名称",jsonObject.get(2));
        _outJson.put("已筹募资金",jsonObject.get(3));
        return _outJson.toJSONString();
    }

    /**
     * 修改状态
     * @param data id和状态
     * @return msg
     */
    @ResponseBody
    @PostMapping("/setStatus")
    public String setStatus(@RequestBody JSONObject data){
        JSONObject _outJson=new JSONObject();
        if (data==null){
            _outJson.put("msg","The data is invalid");
            return _outJson.toJSONString();
        }
        JSONObject _jsonObj=new JSONObject();
        Object dId = data.get("dId");
        Object status = data.get("status");
        Object[] param={dId,status};
        _jsonObj.put("contractName",CONTRACT_NAME);
        _jsonObj.put("contractAddress",CONTRACT_ADDRESS);
        _jsonObj.put("contractAbi",JSONArray.parseArray(CONTRACT_ABI));
        _jsonObj.put("funcName","setStatus");
        _jsonObj.put("user",CONTRACT_USER);
        _jsonObj.put("funcParam",param);
        String response = httpPost(URL, _jsonObj.toJSONString());
        JSONObject jsonObject = JSON.parseObject(response);
        _outJson.put("msg",jsonObject);
        return _outJson.toJSONString();
    }

    /**
     * 获取项目状态
     * @param dId id
     * @return msg
     */
    @ResponseBody
    @GetMapping("/getStatus")
    public String getStatus(@RequestParam Integer dId){
        JSONObject _outJson=new JSONObject();
        if (dId==null){
            _outJson.put("msg","the dId is invalid");
            return _outJson.toJSONString();
        }

        JSONObject _jsonObj=new JSONObject();
        Object[] param={dId};
        _jsonObj.put("contractName",CONTRACT_NAME);
        _jsonObj.put("contractAddress",CONTRACT_ADDRESS);
        _jsonObj.put("contractAbi",JSONArray.parseArray(CONTRACT_ABI));
        _jsonObj.put("funcName","getStatus");
        _jsonObj.put("user",D_EE);
        _jsonObj.put("funcParam",param);
        String response = httpPost(URL, _jsonObj.toJSONString());
        log.info(response);
        JSONArray objects = JSON.parseArray(response);
        Object result = objects.get(0);
        _outJson.put("msg",result);
        log.info(_outJson.toJSONString());
        return _outJson.toJSONString();
    }

    private String httpPost(String url, String jsonStr) {
        // 创建httpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建post请求方式实例
        HttpPost httpPost = new HttpPost(url);
        // 设置请求头 发送的是json数据格式
        httpPost.setHeader("Content-type", "application/json;charset=utf-8");
        // 设置参数---设置消息实体 也就是携带的数据
        StringEntity entity = new StringEntity(jsonStr, StandardCharsets.UTF_8);
        // 设置编码格式
        entity.setContentEncoding("UTF-8");
        // 发送Json格式的数据请求
        entity.setContentType("application/json");
        // 把请求消息实体塞进去
        httpPost.setEntity(entity);
        // 执行http的post请求
        CloseableHttpResponse httpResponse;
        String result = null;
        try {
            httpResponse = httpClient.execute(httpPost);
            result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
