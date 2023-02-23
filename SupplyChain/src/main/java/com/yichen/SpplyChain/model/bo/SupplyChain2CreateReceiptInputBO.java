package com.yichen.SpplyChain.model.bo;

import java.lang.Object;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplyChain2CreateReceiptInputBO {
  private String makerAddress;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(makerAddress);
    return args;
  }
}
