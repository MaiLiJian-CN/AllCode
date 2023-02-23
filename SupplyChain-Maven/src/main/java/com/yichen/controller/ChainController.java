package com.yichen.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;


@Slf4j
@Controller
@RequestMapping("/index")
public class ChainController {
    private static final String URL = "http://192.168.1.9:5002/WeBASE-Front/trans/handle";
//    private static final String URL = "http://192.168.22.131:5002/WeBASE-Front/trans/handle";
    private static final String CONTRACT_NAME = "SupplyChain2";
    private static final String CONTRACT_ADDRESS = "0x317474fb27a8d15988d929de5ffc7fb21b25c6e5";
    private static final String CONTRACT_ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"rid\",\"type\":\"uint256\"},{\"name\":\"senderAddress\",\"type\":\"address\"},{\"name\":\"receiverAddress\",\"type\":\"address\"},{\"name\":\"amount\",\"type\":\"uint256\"}],\"name\":\"transReceipt\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"makerAddress\",\"type\":\"address\"}],\"name\":\"createReceipt\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"rhid\",\"type\":\"uint256\"}],\"name\":\"getReceiptHistoryDetail\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getAllReceipt\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"rid\",\"type\":\"uint256\"}],\"name\":\"getReceiptDetail\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"companyAddress\",\"type\":\"address\"}],\"name\":\"getCompany\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"rid\",\"type\":\"uint256\"}],\"name\":\"getAllReceiptHistoryIds\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_makerAddress\",\"type\":\"address\"}],\"name\":\"getAllReceiptIds\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"companyAddress\",\"type\":\"address\"},{\"name\":\"companyType\",\"type\":\"uint8\"},{\"name\":\"credit\",\"type\":\"uint256\"}],\"name\":\"addCompany\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getAllReceiptHistory\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getAllCompanyAddress\",\"outputs\":[{\"name\":\"\",\"type\":\"address[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";
    private static final String Bank_ADDRESS = "0xbc5ea0b727aaa88538b32b645cbca0b9a4d0bef1";



    /**
     * 根据凭证历史id获取信息
     * @param rhId=历史凭证
     * @return 交易信息
     */
    @ResponseBody
    @GetMapping("/getReceiptHistoryDetail")
    public String getReceiptHistoryDetail(@RequestParam String rhId){
        JSONObject _jsonObj=new JSONObject();
        JSONArray history = getAllReceiptHistory();
        if (!history.get(0).toString().contains(rhId)){
            _jsonObj.put("message","the rhId is invalid");
            return _jsonObj.toJSONString();
        }
        Object[] param={rhId};
        _jsonObj.put("contractName",CONTRACT_NAME);
        _jsonObj.put("contractAddress",CONTRACT_ADDRESS);
        _jsonObj.put("contractAbi",JSONArray.parseArray(CONTRACT_ABI));
        _jsonObj.put("funcName","getReceiptHistoryDetail");
        _jsonObj.put("user",Bank_ADDRESS);
        _jsonObj.put("funcParam", param);
        String response = httpPost(URL, _jsonObj.toJSONString());
        JSONArray objects = JSON.parseArray(response);
        log.info(objects.toJSONString());
        JSONObject _outJson=new JSONObject();

        _outJson.put("rhId",objects.get(0));
        _outJson.put("rid",objects.get(1));
        //地址转公司
        JSONObject sendcompany = getCompany(objects.get(2).toString());
        Object sendCompanyName = sendcompany.get("companyName");
        _outJson.put("sendCompanyName",sendCompanyName);
        //地址转公司
        JSONObject receiveCompany = getCompany(objects.get(3).toString());
        Object receiveCompanyName = receiveCompany.get("companyName");
        _outJson.put("receiveCompanyName",receiveCompanyName);

        _outJson.put("Money",objects.get(4));
        //时间转换
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date.setTime(Long.parseLong(objects.get(5).toString()));
        _outJson.put("time",sdf.format(date));
        return _outJson.toJSONString();
    }

    /**
     *获取所有凭证交易历史
     * @param rid=凭证id
     * @return 凭证交易历史
     */
    @ResponseBody
    @GetMapping("getAllReceiptHistoryIds")
    public String getAllReceiptHistoryIds(@RequestParam String rid){
        JSONObject _jsonObj=new JSONObject();
        JSONArray allReceipt = getAllReceipt();
        if (!allReceipt.toJSONString().contains(rid)){
            _jsonObj.put("message","the rid is invalid");
            return _jsonObj.toJSONString();
        }

        Object[] param={rid};
        _jsonObj.put("contractName",CONTRACT_NAME);
        _jsonObj.put("contractAddress",CONTRACT_ADDRESS);
        _jsonObj.put("contractAbi",JSONArray.parseArray(CONTRACT_ABI));
        _jsonObj.put("funcName","getAllReceiptHistoryIds");
        _jsonObj.put("user",Bank_ADDRESS);
        _jsonObj.put("funcParam", param);
        String response = httpPost(URL, _jsonObj.toJSONString());
        JSONArray objects = JSON.parseArray(response);

        return objects.toJSONString();
    }

    /**
     * 获取所有凭证交易历史
     * @return 返回历史
     */
    @ResponseBody
    @GetMapping("/getAllReceiptHistory")
    public String getAllReceiptHistoryList(){
        JSONArray history = getAllReceiptHistory();
        Object o = history.get(0);
        return o.toString();
    }

    /**
     * 根据凭证id获取凭证信息
     * @param rid=凭证码
     * @return 凭证码和地址
     */
    @ResponseBody
    @GetMapping("/getReceiptDetail")
    public String getReceiptDetailInfo(@RequestParam String rid){
        JSONArray jsonArray = getReceiptDetail(rid);

        return jsonArray.toJSONString();
    }


    /**
     *交易
     * @param transData=封装交易数据
     * @return 反应消息
     */
    @PostMapping("/trans")
    @ResponseBody
    public String transReceipt(@RequestBody JSONObject transData){
        JSONObject _jsonObj=new JSONObject();
        if (transData==null){
            _jsonObj.put("error","the data is invalid");
            return _jsonObj.toJSONString();
        }
        Object rid = transData.get("rid");
        Object sendCompany = transData.get("send_company");
        Object receiveCompany = transData.get("receive_company");
        Object account = transData.get("account");

        Object[] param={rid,sendCompany,receiveCompany,account};
        _jsonObj.put("contractName",CONTRACT_NAME);
        _jsonObj.put("contractAddress",CONTRACT_ADDRESS);
        _jsonObj.put("contractAbi",JSONArray.parseArray(CONTRACT_ABI));
        _jsonObj.put("funcName","transReceipt");
        _jsonObj.put("user",receiveCompany);
        _jsonObj.put("funcParam", param);

        String response = httpPost(URL, _jsonObj.toJSONString());
        JSONObject jsonObject = JSON.parseObject(response);
        String message = jsonObject.getString("message");
        JSONObject _outJson=new JSONObject();
        if (message.equals("Success")){
            _outJson.put("message",message);
        }else {
            _outJson.put("message",message);

        }

        return _outJson.toJSONString();
    }

    /**
     * 注册新公司
     * @param data=post封装的数据
     * @return
     */
    @ResponseBody
    @PostMapping("/addCompany")
    public String addCompany(@RequestBody JSONObject data){
        JSONObject _jsonObj=new JSONObject();
        if (data==null){
            _jsonObj.put("error","invalid parameter");
            return _jsonObj.toJSONString();
        }

        Object name = data.get("name");
        Object company = data.get("company");
        Object companyType = data.get("companyType");
        Object credit = data.get("credit");

        Object[] param={name,company,companyType,credit};
        _jsonObj.put("contractName",CONTRACT_NAME);
        _jsonObj.put("contractAddress",CONTRACT_ADDRESS);
        _jsonObj.put("contractAbi",JSONArray.parseArray(CONTRACT_ABI));
        _jsonObj.put("funcName","addCompany");
        _jsonObj.put("user",company);
        _jsonObj.put("funcParam", param);

        String response = httpPost(URL, _jsonObj.toJSONString());
        JSONObject jsonObject = JSON.parseObject(response);
        String message = jsonObject.getString("message");
        JSONObject _outPutObj=new JSONObject();
        if (message.equals("Success")){
            _outPutObj.put("ret",1);
            _outPutObj.put("msg",message);
        }else {
            _outPutObj.put("ret",0);
            _outPutObj.put("msg",message);
        }
        return _outPutObj.toJSONString();
    }

    /**
     *通过地址获取公司信息
     * @param address=公司地址
     * @return
     */
    @ResponseBody
    @GetMapping("/addr")
    public String getCompanyInfo(@RequestParam String address){
        JSONObject company = getCompany(address);

        return company.toJSONString();
    }

    /**
     * 根据地址获取凭证信息
     * @param address=凭证地址
     * @return 返回数据
     */
    @ResponseBody
    @GetMapping("/getAllReceiptIds")
    public String getAllReceiptIds(@RequestParam String address){
        JSONObject _jsonObj=new JSONObject();
        JSONObject company = getCompany(address);
        if (company.size()!=4){
            return company.toJSONString();
        }
        Object[] param={address};
        _jsonObj.put("contractName",CONTRACT_NAME);
        _jsonObj.put("contractAddress",CONTRACT_ADDRESS);
        _jsonObj.put("contractAbi",JSONArray.parseArray(CONTRACT_ABI));
        _jsonObj.put("funcName","getAllReceiptIds");
        _jsonObj.put("user",company.get("companyAddress"));
        _jsonObj.put("funcParam", param);
        String response = httpPost(URL, _jsonObj.toJSONString());
        JSONArray objects = JSON.parseArray(response);

        Object o = objects.get(0);
        return o.toString();
    }


    /**
     *获取所有公司
     * @return String[] 公司地址
     */
    @ResponseBody
    @GetMapping("/getAll")
    public String getAllCompanyAddressList(){
        JSONArray allCompanyAddress = getAllCompanyAddress();
        return allCompanyAddress.toJSONString();
    }

    /**
     * 生成凭证
     * @param address=公司地址
     * @return 信息
     */
    @ResponseBody
    @PostMapping("/addReceipt")
    public String createReceipt(@RequestParam String address){
        JSONObject _jsonObj=new JSONObject();
        JSONObject company = getCompany(address);
        if (company.size()!=4){
            _jsonObj.put("error","address is invalid");
            return _jsonObj.toJSONString();
        }
        Object[] param={address};
        _jsonObj.put("contractName",CONTRACT_NAME);
        _jsonObj.put("contractAddress",CONTRACT_ADDRESS);
        _jsonObj.put("contractAbi",JSONArray.parseArray(CONTRACT_ABI));
        _jsonObj.put("funcName","createReceipt");
        _jsonObj.put("user",Bank_ADDRESS);
        _jsonObj.put("funcParam",param);
        String response = httpPost(URL, _jsonObj.toJSONString());
        JSONObject jsonObject = JSON.parseObject(response);
        log.info(jsonObject.toJSONString());
        String message = jsonObject.getString("message");
        if (message.equals("Success")){
            _jsonObj.put("message",message);
        }else {
            _jsonObj.put("error",message);

        }
        return _jsonObj.toJSONString();
    }

    /**
     * 获取所有凭证
     * @return 返回凭证列表
     */
    @ResponseBody
    @GetMapping("/getReceiptList")
    public String getAllReceiptList(){
        JSONArray allReceipt = getAllReceipt();

        return allReceipt.get(0).toString();
    }

    /**
     *获取所有公司
     * @return String[] 公司地址
     */
    public JSONArray getAllCompanyAddress(){
        JSONObject _jsonObj=new JSONObject();
        _jsonObj.put("contractName",CONTRACT_NAME);
        _jsonObj.put("contractAddress",CONTRACT_ADDRESS);
        _jsonObj.put("contractAbi",JSONArray.parseArray(CONTRACT_ABI));
        _jsonObj.put("funcName","getAllCompanyAddress");
        _jsonObj.put("user",Bank_ADDRESS);
        String response = httpPost(URL, _jsonObj.toJSONString());
        log.info(response);
        JSONArray objects = JSON.parseArray(response);
        Object data = objects.get(0);
        JSONArray jsonArray = JSON.parseArray(data.toString());
        return jsonArray;
    }

    /**
     * 获取公司信息
     * @param address=查询公司的地址
     * @return 公司信息
     */
    private JSONObject getCompany(String address){
        JSONObject _JsonObj=new JSONObject();
        JSONArray companyAddressList = getAllCompanyAddress();
        if (!companyAddressList.toJSONString().contains(address)){
            _JsonObj.put("error","the address is null");
            return _JsonObj;
        }

        Object[] param={address};
        _JsonObj.put("contractName",CONTRACT_NAME);
        _JsonObj.put("contractAddress",CONTRACT_ADDRESS);
        _JsonObj.put("contractAbi",JSONArray.parseArray(CONTRACT_ABI));
        _JsonObj.put("funcName","getCompany");
        _JsonObj.put("user",Bank_ADDRESS);
        _JsonObj.put("funcParam", param);

        String response = httpPost(URL, _JsonObj.toJSONString());
        JSONArray jsonObject = JSON.parseArray(response);

        JSONObject _outJson=new JSONObject();

        if (jsonObject.size()!=4){
            _outJson.put("message",jsonObject.toJSONString());
        }else {
            _outJson.put("companyName",jsonObject.get(0).toString());
            _outJson.put("companyAddress",jsonObject.get(1).toString());
            _outJson.put("companyCredit",jsonObject.get(2).toString());
            if (jsonObject.get(3).toString().equals("0")){
                _outJson.put("companyType","公司");
            }else {
                _outJson.put("companyType","银行");
            }
        }
        return _outJson;
    }

    /**
     * 获取凭证列表
     * @return 返回凭证列表
     */
    private JSONArray getAllReceipt(){
        JSONObject _jsonObj=new JSONObject();
        _jsonObj.put("contractName",CONTRACT_NAME);
        _jsonObj.put("contractAddress",CONTRACT_ADDRESS);
        _jsonObj.put("contractAbi",JSONArray.parseArray(CONTRACT_ABI));
        _jsonObj.put("user",Bank_ADDRESS);
        _jsonObj.put("funcName","getAllReceipt");
        String response = httpPost(URL, _jsonObj.toJSONString());
        JSONArray objects = JSON.parseArray(response);
        return objects;
    }

/*
    */
/**
     * 生成凭证唯一Id
     * @return:凭证id
     *//*

    private JSONArray getReceiptId(){
        JSONObject _jsonObj = new JSONObject();
        _jsonObj.put("contractName",CONTRACT_NAME);
        _jsonObj.put("contractAddress",CONTRACT_ADDRESS);
        _jsonObj.put("contractAbi",JSONArray.parseArray(CONTRACT_ABI));
        _jsonObj.put("user","");
        _jsonObj.put("funcName","getReceiptId");

        String responseStr = httpPost(URL,_jsonObj.toJSONString());
        log.info(responseStr);

        return null;

    }
*/

    /**
     * 根据凭证id获取凭证信息
     * @param rid=凭证码
     * @return 凭证码和地址
     */
    private JSONArray getReceiptDetail(String rid){
        JSONObject _jsonObj=new JSONObject();
        Object[] param={rid};
        _jsonObj.put("contractName",CONTRACT_NAME);
        _jsonObj.put("contractAddress",CONTRACT_ADDRESS);
        _jsonObj.put("contractAbi",JSONArray.parseArray(CONTRACT_ABI));
        _jsonObj.put("user",Bank_ADDRESS);
        _jsonObj.put("funcName","getReceiptDetail");
        _jsonObj.put("funcParam",param);
        String response = httpPost(URL, _jsonObj.toJSONString());
        JSONArray jsonObject = JSON.parseArray(response);

        return jsonObject;
    }



    /**
     *生成凭证交易历史唯一Id
     * @return
     **/
    /*private JSONArray getReceiptHistoryId(){
        JSONObject _jsonObj=new JSONObject();
        _jsonObj.put("contractName",CONTRACT_NAME);
        _jsonObj.put("contractAddress",CONTRACT_ADDRESS);
        _jsonObj.put("contractAbi",JSONArray.parseArray(CONTRACT_ABI));
        _jsonObj.put("user","");
        _jsonObj.put("funcName","getReceiptHistoryId");

        String post = httpPost(URL, _jsonObj.toJSONString());
        JSONArray responese = JSON.parseArray(post);
        return responese;
    }*/

    /**
     * 获取所有凭证交易历史
     * @return 返回历史
     */
    private JSONArray getAllReceiptHistory(){
        JSONObject _jsonObj=new JSONObject();
        _jsonObj.put("contractName",CONTRACT_NAME);
        _jsonObj.put("contractAddress",CONTRACT_ADDRESS);
        _jsonObj.put("contractAbi",JSONArray.parseArray(CONTRACT_ABI));
        _jsonObj.put("funcName","getAllReceiptHistory");
        _jsonObj.put("user",Bank_ADDRESS);
        String response = httpPost(URL, _jsonObj.toJSONString());
        JSONArray objects = JSON.parseArray(response);

        return objects;
    }

    /**
     * 发送 post 请求
     * @param url     请求地址
     * @param jsonStr Form表单json字符串
     * @return 请求结果
     */
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
