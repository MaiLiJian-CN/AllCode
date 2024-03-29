import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.fisco.bcos.sdk.abi.FunctionReturnDecoder;
import org.fisco.bcos.sdk.abi.TypeReference;
import org.fisco.bcos.sdk.abi.datatypes.Address;
import org.fisco.bcos.sdk.abi.datatypes.DynamicArray;
import org.fisco.bcos.sdk.abi.datatypes.Function;
import org.fisco.bcos.sdk.abi.datatypes.Type;
import org.fisco.bcos.sdk.abi.datatypes.Utf8String;
import org.fisco.bcos.sdk.abi.datatypes.generated.Uint256;
import org.fisco.bcos.sdk.abi.datatypes.generated.Uint8;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple1;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple2;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple4;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple6;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.contract.Contract;
import org.fisco.bcos.sdk.crypto.CryptoSuite;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.model.CryptoType;
import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.fisco.bcos.sdk.model.callback.TransactionCallback;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;

@SuppressWarnings("unchecked")
public class SupplyChain2 extends Contract {
    public static final String[] BINARY_ARRAY = {"608060405234801561001057600080fd5b50600160008190555060018081905550611ab58061002f6000396000f3006080604052600436106100af576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680632572e1ec146100b4578063324daa1a1461013f57806339e0e466146101965780633dcd351f1461025257806354128fa1146102be57806362bc56e6146103325780637ef3411f146104355780638a3d1a90146104b75780638f1118f91461054f578063982a9a5014610603578063ed4faf861461066f575b600080fd5b3480156100c057600080fd5b5061012960048036038101908080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506106db565b6040518082815260200191505060405180910390f35b34801561014b57600080fd5b50610180600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610c81565b6040518082815260200191505060405180910390f35b3480156101a257600080fd5b506101c160048036038101908080359060200190929190505050610d61565b604051808781526020018681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838152602001828152602001965050505050505060405180910390f35b34801561025e57600080fd5b50610267610e9b565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156102aa57808201518184015260208101905061028f565b505050509050019250505060405180910390f35b3480156102ca57600080fd5b506102e960048036038101908080359060200190929190505050610ef3565b604051808381526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019250505060405180910390f35b34801561033e57600080fd5b50610373600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610f92565b60405180806020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018481526020018360ff1660ff168152602001828103825286818151815260200191508051906020019080838360005b838110156103f75780820151818401526020810190506103dc565b50505050905090810190601f1680156104245780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b34801561044157600080fd5b5061046060048036038101908080359060200190929190505050611134565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156104a3578082015181840152602081019050610488565b505050509050019250505060405180910390f35b3480156104c357600080fd5b506104f8600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061122e565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561053b578082015181840152602081019050610520565b505050509050019250505060405180910390f35b34801561055b57600080fd5b506105ed600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803560ff169060200190929190803590602001909291905050506113ab565b6040518082815260200191505060405180910390f35b34801561060f57600080fd5b5061061861166f565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561065b578082015181840152602081019050610640565b505050509050019250505060405180910390f35b34801561067b57600080fd5b506106846116c7565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156106c75780820151818401526020810190506106ac565b505050509050019250505060405180910390f35b60006106e561190f565b6106ed61190f565b60006106f7611951565b8673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561079a576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260068152602001807f353030303032000000000000000000000000000000000000000000000000000081525060200191505060405180910390fd5b600260008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060806040519081016040529081600082018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561087e5780601f106108535761010080835404028352916020019161087e565b820191906000526020600020905b81548152906001019060200180831161086157829003601f168201915b505050505081526020016001820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001600282015481526020016003820160009054906101000a900460ff1660ff1660ff16815250509350600260008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060806040519081016040529081600082018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156109ea5780601f106109bf576101008083540402835291602001916109ea565b820191906000526020600020905b8154815290600101906020018083116109cd57829003601f168201915b505050505081526020016001820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001600282015481526020016003820160009054906101000a900460ff1660ff1660ff16815250509250610a7a611755565b915060c0604051908101604052808381526020018a81526020018973ffffffffffffffffffffffffffffffffffffffff1681526020018873ffffffffffffffffffffffffffffffffffffffff1681526020018781526020014281525090508060066000848152602001908152602001600020600082015181600001556020820151816001015560408201518160020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060608201518160030160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506080820151816004015560a08201518160050155905050600782908060018154018082558091505090600182039060005260206000200160009091929091909150555085600260008a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206002016000828254019250508190555085600260008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206002016000828254039250508190555060c8945050505050949350505050565b600080610c8c6119b4565b610c9461176d565b915060408051908101604052808381526020018573ffffffffffffffffffffffffffffffffffffffff16815250905080600460008481526020019081526020016000206000820151816000015560208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555090505060058290806001815401808255809150509060018203906000526020600020016000909192909190915055508192505050919050565b600080600080600080610d72611951565b6006600089815260200190815260200160002060c0604051908101604052908160008201548152602001600182015481526020016002820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020016003820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001600482015481526020016005820154815250509050806000015181602001518260400151836060015184608001518560a001519650965096509650965096505091939550919395565b60606005805480602002602001604051908101604052809291908181526020018280548015610ee957602002820191906000526020600020905b815481526020019060010190808311610ed5575b5050505050905090565b600080610efe6119b4565b60046000858152602001908152602001600020604080519081016040529081600082015481526020016001820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815250509050806000015181602001519250925050915091565b60606000806000610fa161190f565b600260008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffff","ff16815260200190815260200160002060806040519081016040529081600082018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156110855780601f1061105a57610100808354040283529160200191611085565b820191906000526020600020905b81548152906001019060200180831161106857829003601f168201915b505050505081526020016001820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001600282015481526020016003820160009054906101000a900460ff1660ff1660ff1681525050905080600001518160200151826040015183606001518393509450945094509450509193509193565b60608060008061114385611784565b6040519080825280602002602001820160405280156111715781602001602082028038833980820191505090505b50925060009150600090505b60078054905081101561122357846006600060078481548110151561119e57fe5b9060005260206000200154815260200190815260200160002060010154141561121657600660006007838154811015156111d457fe5b906000526020600020015481526020019081526020016000206000015483838151811015156111ff57fe5b906020019060200201818152505081806001019250505b808060010191505061117d565b829350505050919050565b60608060008061123c6119b4565b600080611248886117f5565b6040519080825280602002602001820160405280156112765781602001602082028038833980820191505090505b50955060089450600093505b60058054905084101561139d57600460006005868154811015156112a257fe5b90600052602060002001548152602001908152602001600020604080519081016040529081600082015481526020016001820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681525050925082602001519150826000015190508773ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff1614156113905780868681518110151561137957fe5b906020019060200201818152505084806001019550505b8380600101945050611282565b859650505050505050919050565b60006113b561190f565b604051806000019050604051809103902060001916600260008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160405180828054600181600116156101000203166002900480156114675780601f10611445576101008083540402835291820191611467565b820191906000526020600020905b815481529060010190602001808311611453575b50509150506040518091039020600019161415156114ed576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260068152602001807f353030303032000000000000000000000000000000000000000000000000000081525060200191505060405180910390fd5b6080604051908101604052808781526020018673ffffffffffffffffffffffffffffffffffffffff1681526020018481526020018560ff16815250905060038590806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505080600260008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008201518160000190805190602001906115ec9291906119e4565b5060208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506040820151816002015560608201518160030160006101000a81548160ff021916908360ff16021790555090505060c8915050949350505050565b606060078054806020026020016040519081016040528092919081815260200182805480156116bd57602002820191906000526020600020905b8154815260200190600101908083116116a9575b5050505050905090565b6060600380548060200260200160405190810160405280929190818152602001828054801561174b57602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311611701575b5050505050905090565b60006001600081548092919060010191905055905090565b600080600081548092919060010191905055905090565b6000806000809150600090505b6007805490508110156117eb5783600660006007848154811015156117b257fe5b906000526020600020015481526020019081526020016000206001015414156117de5781806001019250505b8080600101915050611791565b8192505050919050565b60008060006118026119b4565b6000809350600092505b600580549050831015611903576004600060058581548110151561182c57fe5b90600052602060002001548152602001908152602001600020604080519081016040529081600082015481526020016001820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815250509150816020015190508573ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614156118f65783806001019450505b828060010193505061180c565b83945050505050919050565b60806040519081016040528060608152602001600073ffffffffffffffffffffffffffffffffffffffff16815260200160008152602001600060ff1681525090565b60c0604051908101604052806000815260200160008152602001600073ffffffffffffffffffffffffffffffffffffffff168152602001600073ffffffffffffffffffffffffffffffffffffffff16815260200160008152602001600081525090565b604080519081016040528060008152602001600073ffffffffffffffffffffffffffffffffffffffff1681525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10611a2557805160ff1916838001178555611a53565b82800160010185558215611a53579182015b82811115611a52578251825591602001919060010190611a37565b5b509050611a609190611a64565b5090565b611a8691905b80821115611a82576000816000905550600101611a6a565b5090565b905600a165627a7a723058207c864ddded4f94f090680a7d25e187047f66b1855c4e8eca5e0cc2fc3fcc9d040029"};

    public static final String BINARY = org.fisco.bcos.sdk.utils.StringUtils.joinAll("", BINARY_ARRAY);

    public static final String[] SM_BINARY_ARRAY = {};

    public static final String SM_BINARY = org.fisco.bcos.sdk.utils.StringUtils.joinAll("", SM_BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":false,\"inputs\":[{\"name\":\"rid\",\"type\":\"uint256\"},{\"name\":\"senderAddress\",\"type\":\"address\"},{\"name\":\"receiverAddress\",\"type\":\"address\"},{\"name\":\"amount\",\"type\":\"uint256\"}],\"name\":\"transReceipt\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"makerAddress\",\"type\":\"address\"}],\"name\":\"createReceipt\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"rhid\",\"type\":\"uint256\"}],\"name\":\"getReceiptHistoryDetail\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getAllReceipt\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"rid\",\"type\":\"uint256\"}],\"name\":\"getReceiptDetail\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"companyAddress\",\"type\":\"address\"}],\"name\":\"getCompany\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"rid\",\"type\":\"uint256\"}],\"name\":\"getAllReceiptHistoryIds\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_makerAddress\",\"type\":\"address\"}],\"name\":\"getAllReceiptIds\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"companyAddress\",\"type\":\"address\"},{\"name\":\"companyType\",\"type\":\"uint8\"},{\"name\":\"credit\",\"type\":\"uint256\"}],\"name\":\"addCompany\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getAllReceiptHistory\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getAllCompanyAddress\",\"outputs\":[{\"name\":\"\",\"type\":\"address[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]"};

    public static final String ABI = org.fisco.bcos.sdk.utils.StringUtils.joinAll("", ABI_ARRAY);

    public static final String FUNC_TRANSRECEIPT = "transReceipt";

    public static final String FUNC_CREATERECEIPT = "createReceipt";

    public static final String FUNC_GETRECEIPTHISTORYDETAIL = "getReceiptHistoryDetail";

    public static final String FUNC_GETALLRECEIPT = "getAllReceipt";

    public static final String FUNC_GETRECEIPTDETAIL = "getReceiptDetail";

    public static final String FUNC_GETCOMPANY = "getCompany";

    public static final String FUNC_GETALLRECEIPTHISTORYIDS = "getAllReceiptHistoryIds";

    public static final String FUNC_GETALLRECEIPTIDS = "getAllReceiptIds";

    public static final String FUNC_ADDCOMPANY = "addCompany";

    public static final String FUNC_GETALLRECEIPTHISTORY = "getAllReceiptHistory";

    public static final String FUNC_GETALLCOMPANYADDRESS = "getAllCompanyAddress";

    protected SupplyChain2(String contractAddress, Client client, CryptoKeyPair credential) {
        super(getBinary(client.getCryptoSuite()), contractAddress, client, credential);
    }

    public static String getBinary(CryptoSuite cryptoSuite) {
        return (cryptoSuite.getCryptoTypeConfig() == CryptoType.ECDSA_TYPE ? BINARY : SM_BINARY);
    }

    public TransactionReceipt transReceipt(BigInteger rid, String senderAddress, String receiverAddress, BigInteger amount) {
        final Function function = new Function(
                FUNC_TRANSRECEIPT, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(rid), 
                new org.fisco.bcos.sdk.abi.datatypes.Address(senderAddress), 
                new org.fisco.bcos.sdk.abi.datatypes.Address(receiverAddress), 
                new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public void transReceipt(BigInteger rid, String senderAddress, String receiverAddress, BigInteger amount, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_TRANSRECEIPT, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(rid), 
                new org.fisco.bcos.sdk.abi.datatypes.Address(senderAddress), 
                new org.fisco.bcos.sdk.abi.datatypes.Address(receiverAddress), 
                new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForTransReceipt(BigInteger rid, String senderAddress, String receiverAddress, BigInteger amount) {
        final Function function = new Function(
                FUNC_TRANSRECEIPT, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(rid), 
                new org.fisco.bcos.sdk.abi.datatypes.Address(senderAddress), 
                new org.fisco.bcos.sdk.abi.datatypes.Address(receiverAddress), 
                new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple4<BigInteger, String, String, BigInteger> getTransReceiptInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_TRANSRECEIPT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple4<BigInteger, String, String, BigInteger>(

                (BigInteger) results.get(0).getValue(), 
                (String) results.get(1).getValue(), 
                (String) results.get(2).getValue(), 
                (BigInteger) results.get(3).getValue()
                );
    }

    public Tuple1<BigInteger> getTransReceiptOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_TRANSRECEIPT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public TransactionReceipt createReceipt(String makerAddress) {
        final Function function = new Function(
                FUNC_CREATERECEIPT, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Address(makerAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public void createReceipt(String makerAddress, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_CREATERECEIPT, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Address(makerAddress)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForCreateReceipt(String makerAddress) {
        final Function function = new Function(
                FUNC_CREATERECEIPT, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Address(makerAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple1<String> getCreateReceiptInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_CREATERECEIPT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public Tuple1<BigInteger> getCreateReceiptOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_CREATERECEIPT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public Tuple6<BigInteger, BigInteger, String, String, BigInteger, BigInteger> getReceiptHistoryDetail(BigInteger rhid) throws ContractException {
        final Function function = new Function(FUNC_GETRECEIPTHISTORYDETAIL, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(rhid)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = executeCallWithMultipleValueReturn(function);
        return new Tuple6<BigInteger, BigInteger, String, String, BigInteger, BigInteger>(
                (BigInteger) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue(), 
                (String) results.get(2).getValue(), 
                (String) results.get(3).getValue(), 
                (BigInteger) results.get(4).getValue(), 
                (BigInteger) results.get(5).getValue());
    }

    public List getAllReceipt() throws ContractException {
        final Function function = new Function(FUNC_GETALLRECEIPT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        List<Type> result = (List<Type>) executeCallWithSingleValueReturn(function, List.class);
        return convertToNative(result);
    }

    public Tuple2<BigInteger, String> getReceiptDetail(BigInteger rid) throws ContractException {
        final Function function = new Function(FUNC_GETRECEIPTDETAIL, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(rid)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        List<Type> results = executeCallWithMultipleValueReturn(function);
        return new Tuple2<BigInteger, String>(
                (BigInteger) results.get(0).getValue(), 
                (String) results.get(1).getValue());
    }

    public Tuple4<String, String, BigInteger, BigInteger> getCompany(String companyAddress) throws ContractException {
        final Function function = new Function(FUNC_GETCOMPANY, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Address(companyAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint8>() {}));
        List<Type> results = executeCallWithMultipleValueReturn(function);
        return new Tuple4<String, String, BigInteger, BigInteger>(
                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue(), 
                (BigInteger) results.get(2).getValue(), 
                (BigInteger) results.get(3).getValue());
    }

    public List getAllReceiptHistoryIds(BigInteger rid) throws ContractException {
        final Function function = new Function(FUNC_GETALLRECEIPTHISTORYIDS, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(rid)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        List<Type> result = (List<Type>) executeCallWithSingleValueReturn(function, List.class);
        return convertToNative(result);
    }

    public List getAllReceiptIds(String _makerAddress) throws ContractException {
        final Function function = new Function(FUNC_GETALLRECEIPTIDS, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Address(_makerAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        List<Type> result = (List<Type>) executeCallWithSingleValueReturn(function, List.class);
        return convertToNative(result);
    }

    public TransactionReceipt addCompany(String name, String companyAddress, BigInteger companyType, BigInteger credit) {
        final Function function = new Function(
                FUNC_ADDCOMPANY, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.sdk.abi.datatypes.Address(companyAddress), 
                new org.fisco.bcos.sdk.abi.datatypes.generated.Uint8(companyType), 
                new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(credit)), 
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public void addCompany(String name, String companyAddress, BigInteger companyType, BigInteger credit, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_ADDCOMPANY, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.sdk.abi.datatypes.Address(companyAddress), 
                new org.fisco.bcos.sdk.abi.datatypes.generated.Uint8(companyType), 
                new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(credit)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForAddCompany(String name, String companyAddress, BigInteger companyType, BigInteger credit) {
        final Function function = new Function(
                FUNC_ADDCOMPANY, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.sdk.abi.datatypes.Address(companyAddress), 
                new org.fisco.bcos.sdk.abi.datatypes.generated.Uint8(companyType), 
                new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(credit)), 
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple4<String, String, BigInteger, BigInteger> getAddCompanyInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_ADDCOMPANY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Uint8>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple4<String, String, BigInteger, BigInteger>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue(), 
                (BigInteger) results.get(2).getValue(), 
                (BigInteger) results.get(3).getValue()
                );
    }

    public Tuple1<BigInteger> getAddCompanyOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_ADDCOMPANY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public List getAllReceiptHistory() throws ContractException {
        final Function function = new Function(FUNC_GETALLRECEIPTHISTORY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        List<Type> result = (List<Type>) executeCallWithSingleValueReturn(function, List.class);
        return convertToNative(result);
    }

    public List getAllCompanyAddress() throws ContractException {
        final Function function = new Function(FUNC_GETALLCOMPANYADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        List<Type> result = (List<Type>) executeCallWithSingleValueReturn(function, List.class);
        return convertToNative(result);
    }

    public static SupplyChain2 load(String contractAddress, Client client, CryptoKeyPair credential) {
        return new SupplyChain2(contractAddress, client, credential);
    }

    public static SupplyChain2 deploy(Client client, CryptoKeyPair credential) throws ContractException {
        return deploy(SupplyChain2.class, client, credential, getBinary(client.getCryptoSuite()), "");
    }
}
