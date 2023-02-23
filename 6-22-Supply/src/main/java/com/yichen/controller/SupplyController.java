package com.yichen.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.*;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/supply")
public class SupplyController {
    private static final String ContractAddress="0x6f000a0b024ecf15db8e5c492b7e2f8e8ff33007";
    private static final String ContractName="SupplyChain2";
    private static final String ContractABI="[{\"constant\":false,\"inputs\":[{\"name\":\"rid\",\"type\":\"uint256\"},{\"name\":\"senderAddress\",\"type\":\"address\"},{\"name\":\"receiverAddress\",\"type\":\"address\"},{\"name\":\"amount\",\"type\":\"uint256\"}],\"name\":\"transReceipt\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"makerAddress\",\"type\":\"address\"}],\"name\":\"createReceipt\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"rhid\",\"type\":\"uint256\"}],\"name\":\"getReceiptHistoryDetail\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getAllReceipt\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"rid\",\"type\":\"uint256\"}],\"name\":\"getReceiptDetail\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"companyAddress\",\"type\":\"address\"}],\"name\":\"getCompany\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"rid\",\"type\":\"uint256\"}],\"name\":\"getAllReceiptHistoryIds\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_makerAddress\",\"type\":\"address\"}],\"name\":\"getAllReceiptIds\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"companyAddress\",\"type\":\"address\"},{\"name\":\"companyType\",\"type\":\"uint8\"},{\"name\":\"credit\",\"type\":\"uint256\"}],\"name\":\"addCompany\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getAllReceiptHistory\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getAllCompanyAddress\",\"outputs\":[{\"name\":\"\",\"type\":\"address[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";
    private static final String ContractUser="0xdcb033cb598212179a3ddc4ac7181fb01095a8b5";
    private static final String URL="http://192.168.22.131:5002/WeBASE-Front/trans/handle";

    /**
     * 注册新公司
     */
    @ResponseBody
    @PostMapping("/addCompany")
    public String addCompany(@RequestBody JSONObject requestData){
        JSONObject _jsonObj=new JSONObject();
        if (requestData==null){
            _jsonObj.put("msg","The data is invalid");
            return _jsonObj.toJSONString();
        }
        Object name = requestData.get("name");
        Object companyAddress = requestData.get("companyAddress");
        Object companyType = requestData.get("companyType");
        Object credit = requestData.get("credit");
        Object[] param={name,companyAddress,companyType,credit};
        JSONObject objJSon=new JSONObject();
        objJSon.put("contractName",ContractName);
        objJSon.put("contractAddress",ContractAddress);
        objJSon.put("contractAbi", JSONArray.parseArray(ContractABI));
        objJSon.put("user",companyAddress);
        objJSon.put("funcName","addCompany");
        objJSon.put("funcParam",param);
        String response = getHttpRequest(objJSon.toJSONString());
        JSONObject jsonObject = JSON.parseObject(response);
        String message = jsonObject.getString("message");
        if ("Success".equals(message)){
            _jsonObj.put("msg",jsonObject.toJSONString());
            _jsonObj.put("status",1);
        }else {
            _jsonObj.put("msg",message);
            _jsonObj.put("status",0);
        }
        return _jsonObj.toJSONString();

    }

    @ResponseBody
    @GetMapping("/getCompany")
        public String getCompany(@RequestParam String companyAddress){
        JSONObject _outJson=new JSONObject();
        if (companyAddress==null){
            _outJson.put("msg","the address is invalid");
            return _outJson.toJSONString();
        }
        Object[] param={companyAddress};
        JSONObject _jsonObj=new JSONObject();
        _jsonObj.put("contractName",ContractName);
        _jsonObj.put("contractAddress",ContractAddress);
        _jsonObj.put("contractAbi",JSONArray.parseArray(ContractABI));
        _jsonObj.put("funcParam",param);
        _jsonObj.put("funcName","getCompany");
        _jsonObj.put("user",companyAddress);
        String response = getHttpRequest(_jsonObj.toJSONString());
        System.out.println(response);
        JSONArray data = JSON.parseArray(response);
//        System.out.println(data);
        _outJson.put("companyName",data.get(0));
        _outJson.put("companyAddress",data.get(1));
        _outJson.put("creditAsset",data.get(2));
        _outJson.put("companyType",data.get(3));
        return _outJson.toJSONString();
    }

    @ResponseBody
    @GetMapping("/getAllConpanyAddr")
    public String getAllCompanyAddress(){
        JSONObject _outJson=new JSONObject();
        Object[] param={};
        JSONObject _jsonObj=new JSONObject();
        _jsonObj.put("contractName",ContractName);
        _jsonObj.put("contractAddress",ContractAddress);
        _jsonObj.put("contractAbi",JSONArray.parseArray(ContractABI));
        _jsonObj.put("funcParam",param);
        _jsonObj.put("funcName","getAllCompanyAddress");
        _jsonObj.put("user",ContractUser);
        String response = getHttpRequest(_jsonObj.toJSONString());
        JSONArray objects = JSONArray.parseArray(response);
        _outJson.put("msg",objects.get(0));
        return _outJson.toJSONString();
    }

    @PostMapping("/createReceipt")
    public String createReceipt(@RequestParam String makeAddress){
        JSONObject _outJson=new JSONObject();
        if (makeAddress==null){
            _outJson.put("msg","the address is invalid");
            return _outJson.toJSONString();
        }
        Object[] param={makeAddress};
        JSONObject _jsonObj=new JSONObject();
        _jsonObj.put("contractName",ContractName);
        _jsonObj.put("contractAddress",ContractAddress);
        _jsonObj.put("contractAbi",JSONArray.parseArray(ContractABI));
        _jsonObj.put("funcParam",param);
        _jsonObj.put("funcName","createReceipt");
        _jsonObj.put("user",makeAddress);
        String response = getHttpRequest(_jsonObj.toJSONString());
        JSONObject jsonObject = JSON.parseObject(response);
        System.out.println(jsonObject);
        String message = jsonObject.getString("message");
        if ("Success".equals(message)){
            _outJson.put("msg",message);
            _outJson.put("status",1);
        }{
            _outJson.put("msg",message);
            _outJson.put("status",0);
        }
        return _outJson.toJSONString();
    }

    @ResponseBody
    @GetMapping("/getAllReceipt")
    public String getAllReceipt(){
        JSONObject _outJson=new JSONObject();
        Object[] param={};
        JSONObject _jsonObj=new JSONObject();
        _jsonObj.put("contractName",ContractName);
        _jsonObj.put("contractAddress",ContractAddress);
        _jsonObj.put("contractAbi",JSONArray.parseArray(ContractABI));
        _jsonObj.put("funcParam",param);
        _jsonObj.put("funcName","getAllReceipt");
        _jsonObj.put("user",ContractUser);
        String response = getHttpRequest(_jsonObj.toJSONString());
        JSONArray objects = JSONArray.parseArray(response);
        _outJson.put("msg",objects.get(0));
        return _outJson.toJSONString();
    }

    @GetMapping("/getAllReceiptIds")
    public String getAllReceiptIds(@RequestParam String makeAddress){
        JSONObject _outJson=new JSONObject();
        if (makeAddress==null){
            _outJson.put("msg","the address is invalid");
            return _outJson.toJSONString();
        }
        Object[] param={makeAddress};
        JSONObject _jsonObj=new JSONObject();
        _jsonObj.put("contractName",ContractName);
        _jsonObj.put("contractAddress",ContractAddress);
        _jsonObj.put("contractAbi",JSONArray.parseArray(ContractABI));
        _jsonObj.put("funcParam",param);
        _jsonObj.put("funcName","createReceipt");
        _jsonObj.put("user",makeAddress);
        String response = getHttpRequest(_jsonObj.toJSONString());
        JSONObject jsonObject = JSON.parseObject(response);
        System.out.println(jsonObject);
        String message = jsonObject.getString("message");
        if ("Success".equals(message)){
            _outJson.put("msg",message);
            _outJson.put("status",1);
        }{
            _outJson.put("msg",message);
            _outJson.put("status",0);
        }
        return _outJson.toJSONString();
    }

    @PostMapping("/trans")
    public String transReceipt(@RequestBody JSONObject jsonObject){
        JSONObject _outJson=new JSONObject();
        if (jsonObject==null){
            _outJson.put("msg","null");
            return _outJson.toJSONString();
        }
        Object rid = jsonObject.get("rid");
        Object senderAddress = jsonObject.get("senderAddress");
        Object receiverAddress = jsonObject.get("receiverAddress");
        Object amount = jsonObject.get("amount");
        Object[] param={rid,senderAddress,receiverAddress,amount};
        JSONObject _jsonObj=new JSONObject();
        _jsonObj.put("contractName",ContractName);
        _jsonObj.put("contractAddress",ContractAddress);
        _jsonObj.put("contractAbi",JSONArray.parseArray(ContractABI));
        _jsonObj.put("funcParam",param);
        _jsonObj.put("funcName","transReceipt");
        _jsonObj.put("user",receiverAddress);
        String response = getHttpRequest(_jsonObj.toJSONString());
        JSONObject responseData = JSON.parseObject(response);
        String message = responseData.getString("message");
        if (message.equals("Success")){
            _outJson.put("msg",message);
            _outJson.put("status",1);
        }else {
            _outJson.put("msg",message);
            _outJson.put("status",0);
        }
        return _outJson.toJSONString();
    }

    private static String getHttpRequest(String data){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(URL);
        httpPost.setHeader("Content-type","application/json;charset=UTF-8");
        StringEntity entity=new StringEntity(data, StandardCharsets.UTF_8);
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        CloseableHttpResponse response;
        String result=null;
        try{
            response = httpClient.execute(httpPost);
            result = EntityUtils.toString(response.getEntity(),"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
