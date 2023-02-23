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
public class SupplyChain2GetCompanyInputBO {
  private String companyAddress;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(companyAddress);
    return args;
  }
}
