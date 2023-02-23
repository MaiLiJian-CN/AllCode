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
public class SupplyChain2AddCompanyInputBO {
  private String name;

  private String companyAddress;

  private BigInteger companyType;

  private BigInteger credit;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(name);
    args.add(companyAddress);
    args.add(companyType);
    args.add(credit);
    return args;
  }
}
