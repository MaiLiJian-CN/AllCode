pragma solidity ^0.4.22;

//供应链金融智能合约
contract SupplyChain2 {

    uint private receiptId;
    uint private receiptHistoryId;

    //公司信息结构体
    struct Company {
        string companyName; //公司名称
        address companyAddress; //公司地址
        uint creditAsset; //余额
        uint8 companyType; //0=公司，1=银行
    }

    //数字凭证交易历史信息
    struct ReceiptHistory {
        uint rhId; //凭证历史id
        uint rId;  //凭证id
        address senderAddress; //发送地址
        address receiverAddress; //接收地址
        uint amount; //金额
        uint createTime; //创建时间
    }

    //数字凭证信息
    struct Receipt {
        uint rId; //凭证id
        address makerAddress; //创建者地址
    }

    //公司的Map，用于快速搜索，公司地址=>公司
    mapping(address => Company) private companyMap;

    //公司地址的数组
    address[] private companies;

    //凭证Map,凭证id=>凭证
    mapping(uint=>Receipt) private receiptMap;
    //所有凭证数组
    uint[] private receipts;

    //交易历史Map,凭证历史id=>凭证历史
    mapping(uint=>ReceiptHistory) private transHistoryMap;
    //所有交易历史数组
    uint[] private transHistories;


    //构造函数
    constructor() public {
        receiptId = 1;
        receiptHistoryId = 1;
    }

    //生成凭证唯一Id
    function getReceiptId() private returns (uint) {
        return receiptId++;
    }

    //生成凭证交易历史唯一Id
    function getReceiptHistoryId() private returns (uint) {
        return receiptHistoryId++;
    }

    
    //company functions
    /**
     * description: 注册新公司
     * param {string} name
     * param {address} companyAddress
     * param {uint8} companyType
     * param {uint} credit
     * return {*}
     */    
    function addCompany(string name, address companyAddress,uint8 companyType,uint credit) public returns(uint) {
        /* 【1】请在此注释后作答，勿删除此注释
        * 使用require判断验证新公司名称是否为空，否则返回500002
        */
        require(keccak256(companyMap[companyAddress].companyName) == keccak256(""), "500002");
        // require([[1-1]] == keccak256(""), "500002");
        Company memory newCompany = Company(name, companyAddress, credit, companyType);
        // Company memory newCompany = [[1-2]];
        companies.push(companyAddress);
        companyMap[companyAddress] = newCompany;

        return 200;
    }
    
    /**
     * description: 通过地址获取公司信息
     * param {address} companyAddress
     * return {*}
     */    
    function getCompany(address companyAddress) public view returns(string, address, uint, uint8) {
        Company memory company = companyMap[companyAddress];
        return (company.companyName, company.companyAddress, company.creditAsset, company.companyType);
    }
    
    /**
     * description: 获取所有公司
     * param {public view} returns
     * return {*}
     */    
    function getAllCompanyAddress() public view returns(address[]) {
        return companies;
    }

    //Receipt functions

    /**
     * description: 生成新的凭证
     * param {address} 创建人地址
     * return {*}
     */    
    function createReceipt(address makerAddress) public returns(uint) {
       /*【2】请在此注释后作答，勿删除此注释
        * 返回Receipt id便于调用
        */
        uint rid = getReceiptId();
        Receipt memory newReceipt = Receipt(rid,makerAddress);
        // Receipt memory newReceipt = Receipt([[2-1]]);
        receiptMap[rid] = newReceipt;
        receipts.push(rid);
        return rid;
    }
    
    /**
     * description: 获取所有凭证信息
     * param {public view} returns
     * return {*}
     */    
    function getAllReceipt() public view returns(uint[]) {
        return receipts;
    }

    /**
     * description: 根据地址获取凭证信息
     * param {address} 凭证所属人地址
     * return {*}
     */    
    function getAllReceiptIds(address _makerAddress) public view returns(uint[] memory) {
       /*【3】请在此注释后作答，勿删除此注释
        * 返回凭证id数组
        */
       uint[] memory receiptIds = new uint[] (getReceiptSize(_makerAddress));
  
       uint number = 8;
       for(uint p = 0; p<receipts.length;p++) {
	        Receipt memory rc = receiptMap[receipts[p]];
       	    address a = rc.makerAddress;
	        uint _rid = rc.rId;
	        if (a == _makerAddress){
		            receiptIds[number] = _rid;
		            number++;
	            }
        }	
       return receiptIds;
    }

    /**
     * description: 获取凭证数组大小
     * param {address} 凭证所属人地址
     * return {*}
     */
    function getReceiptSize(address _makerAddress) private view returns(uint) {
       /*【4】请在此注释后作答，勿删除此注释
        * 返回凭证数组大小
        */
        uint size = 0;
        for(uint p=0;p<receipts.length;p++){
        	Receipt memory rc = receiptMap[receipts[p]];
        	address a = rc.makerAddress;
	        if (a == _makerAddress){
		        size++;
	            }
        }


        return size;
    }

    /**
     * description: 根据凭证id获取凭证信息
     * param {uint} rid
     * return {*}
     */
    function getReceiptDetail(uint rid) public view returns(uint,address) {
        Receipt memory receipt = receiptMap[rid];
        return (receipt.rId,receipt.makerAddress);
    }

    /**
     * description: 获取所有凭证交易历史
     * param {public view} returns
     * return {*}
     */
    function getAllReceiptHistory() public view returns(uint[]) {
        return transHistories;
    }
    

    /**
     * description: 获取所有凭证交易历史
     * param {uint} rid，凭证id
     * return {*}
     */
    function getAllReceiptHistoryIds(uint rid) public view returns(uint[] memory) {
       /*【5】请在此注释后作答，勿删除此注释
        */
        uint[] memory transHistoryIds = new uint[](getReceiptHistorySize(rid));
        // uint[] memory transHistoryIds = new [[5-1]];

        uint number = 0;
        for(uint i = 0; i < transHistories.length; i++) {
            if (transHistoryMap[transHistories[i]].rId == rid){
            // if ([[5-2]]){
                transHistoryIds[number] = transHistoryMap[transHistories[i]].rhId;
                number ++;
            }
        }
        return transHistoryIds;
    }

    /**
     * description: 获取凭证历史数组大小
     * param {uint} rid，凭证id
     * return {*}
     */    
    function getReceiptHistorySize(uint rid) private view returns(uint) {
       /*【6】请在此注释后作答，勿删除此注释
        * 返回凭证历史数组大小
        */
        uint size = 0;
        for(uint i = 0; i < transHistories.length; i++) {
            if (transHistoryMap[transHistories[i]].rId == rid){
            // if ([[6-1]]){
                size ++;
            }
        }
        return size;
    }

    /**
     * description: 根据凭证历史id获取信息
     * param {uint} rhid，凭证历史id
     * return {*}
     */
    function getReceiptHistoryDetail(uint rhid) public view returns(uint,uint,address,address,uint,uint) {
        ReceiptHistory memory receiptHistory = transHistoryMap[rhid];
        return (receiptHistory.rhId,receiptHistory.rId,receiptHistory.senderAddress,receiptHistory.receiverAddress,receiptHistory.amount,receiptHistory.createTime);
    }
    

    /**
     * description: 凭证交易方法
     * param {uint} rid，凭证id
     * param {address} senderAddress，发送人
     * param {address} receiverAddress，接收人
     * param {uint} amount，数量
     * return {*}
     */    
    function transReceipt(uint rid,address senderAddress, address receiverAddress, uint amount) public returns(uint) {
       /*【7】请在此注释后作答，勿删除此注释
        * 1、使用require判断只有接收人才能发起交易，否则返回500002
        * 2、使用require判断发送公司是否为空，否则返回404001
        * 3、使用require判断接收公司是否为空，否则返回404002
        * 4、使用require判断是否有足够的余额，否则返回500001
        */
	require(msg.sender == receiverAddress, "500002");

	Company memory senderCompany = companyMap[senderAddress];
	Company memory receiverCompany = companyMap[receiverAddress];

	uint rhid = getReceiptHistoryId();
	ReceiptHistory memory newReceiptHistory = ReceiptHistory(rhid,rid,senderAddress,receiverAddress,amount,now);
	transHistoryMap[rhid] = newReceiptHistory;
	transHistories.push(rhid);
	companyMap[senderAddress].creditAsset += amount;
	companyMap[receiverAddress].creditAsset -= amount;
        return 200;
    }
    

}