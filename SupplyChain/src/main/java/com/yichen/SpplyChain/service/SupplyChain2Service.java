package com.yichen.SpplyChain.service;

import com.yichen.SpplyChain.model.bo.SupplyChain2AddCompanyInputBO;
import com.yichen.SpplyChain.model.bo.SupplyChain2CreateReceiptInputBO;
import com.yichen.SpplyChain.model.bo.SupplyChain2GetAllReceiptHistoryIdsInputBO;
import com.yichen.SpplyChain.model.bo.SupplyChain2GetAllReceiptIdsInputBO;
import com.yichen.SpplyChain.model.bo.SupplyChain2GetCompanyInputBO;
import com.yichen.SpplyChain.model.bo.SupplyChain2GetReceiptDetailInputBO;
import com.yichen.SpplyChain.model.bo.SupplyChain2GetReceiptHistoryDetailInputBO;
import com.yichen.SpplyChain.model.bo.SupplyChain2TransReceiptInputBO;
import java.lang.Exception;
import java.lang.String;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.transaction.manager.AssembleTransactionProcessor;
import org.fisco.bcos.sdk.transaction.manager.TransactionProcessorFactory;
import org.fisco.bcos.sdk.transaction.model.dto.CallResponse;
import org.fisco.bcos.sdk.transaction.model.dto.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Data
public class SupplyChain2Service {
  public static final String ABI = com.yichen.SpplyChain.utils.IOUtil.readResourceAsString("abi/SupplyChain2.abi");

  public static final String BINARY = com.yichen.SpplyChain.utils.IOUtil.readResourceAsString("bin/ecc/SupplyChain2.bin");

  public static final String SM_BINARY = com.yichen.SpplyChain.utils.IOUtil.readResourceAsString("bin/sm/SupplyChain2.bin");

  @Value("${system.contract.supplyChain2Address}")
  private String address;

  @Autowired
  private Client client;

  AssembleTransactionProcessor txProcessor;

  @PostConstruct
  public void init() throws Exception {
    this.txProcessor = TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, this.client.getCryptoSuite().getCryptoKeyPair());
  }

  public TransactionResponse createReceipt(SupplyChain2CreateReceiptInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "createReceipt", input.toArgs());
  }

  public TransactionResponse addCompany(SupplyChain2AddCompanyInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "addCompany", input.toArgs());
  }

  public CallResponse getAllReceiptHistoryIds(SupplyChain2GetAllReceiptHistoryIdsInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getAllReceiptHistoryIds", input.toArgs());
  }

  public CallResponse getAllReceiptIds(SupplyChain2GetAllReceiptIdsInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getAllReceiptIds", input.toArgs());
  }

  public CallResponse getAllCompanyAddress() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getAllCompanyAddress", Arrays.asList());
  }

  public CallResponse getCompany(SupplyChain2GetCompanyInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getCompany", input.toArgs());
  }

  public TransactionResponse transReceipt(SupplyChain2TransReceiptInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "transReceipt", input.toArgs());
  }

  public CallResponse getReceiptHistoryDetail(SupplyChain2GetReceiptHistoryDetailInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getReceiptHistoryDetail", input.toArgs());
  }

  public CallResponse getAllReceipt() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getAllReceipt", Arrays.asList());
  }

  public CallResponse getAllReceiptHistory() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getAllReceiptHistory", Arrays.asList());
  }

  public CallResponse getReceiptDetail(SupplyChain2GetReceiptDetailInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getReceiptDetail", input.toArgs());
  }
}
