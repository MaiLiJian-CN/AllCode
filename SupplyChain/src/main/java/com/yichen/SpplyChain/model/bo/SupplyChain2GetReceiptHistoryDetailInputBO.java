package com.yichen.SpplyChain.model.bo;

import java.lang.Object;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplyChain2GetReceiptHistoryDetailInputBO {
  private BigInteger rhid;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(rhid);
    return args;
  }
}
