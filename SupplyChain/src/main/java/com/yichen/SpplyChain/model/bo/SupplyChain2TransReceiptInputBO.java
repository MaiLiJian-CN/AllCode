package com.yichen.SpplyChain.model.bo;

import java.lang.Object;
import java.lang.String;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplyChain2TransReceiptInputBO {
  private BigInteger rid;

  private String senderAddress;

  private String receiverAddress;

  private BigInteger amount;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(rid);
    args.add(senderAddress);
    args.add(receiverAddress);
    args.add(amount);
    return args;
  }
}
