package encry.example;

import com.alibaba.fastjson.JSON;
import encry.entity.OpenEntity;
import encry.entity.OpenResult;
import encry.entity.vo.*;
import encry.service.AddressService;
import encry.service.TradeService;
import encry.service.impl.AddressServiceImpl;
import encry.service.impl.TradeServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname QueryAndCheckAddress
 * @Date 2021/11/15 14:06
 * @Created by chenrujia
 * @Description
 */
public class QueryAndCheckAddress {
   public static void main(String[] args) {
      AddressService addressService = new AddressServiceImpl();
      OpenResult result = new OpenResult();
      result = addressService.queryAddressesByCoinCode(new OpenEntity(), new CoinCodePageVo("CLV", 1, 5));
      System.out.println("======queryAddressesByCoinCode======================================");
      System.out.println(JSON.toJSONString(result) + "\n\n");


      VerifyAddressBatchVo vo = new VerifyAddressBatchVo();
      vo.setCoinCode("DOGE");
      List list = new ArrayList();
      list.add(new Address("DL5Var6gmHqniNtGcsGrLbZXfQvNz3nxrk", "1023809976"));
      list.add(new Address("5F4tvhVffTEZLpVg8Xy39EX3seVk7cKXLJ1rff8mnH7E4eNo", null));
      list.add(new Address("DRQtiyCpM1cqaFHe7eG9FZVia6ZVoY4RA9", null));
      vo.setAddressList(list);
      result = addressService.queryAddressesInfo(new OpenEntity(),vo);
      System.out.println("======queryAddressesInfo======================================");
      System.out.println(JSON.toJSONString(result) + "\n\n");


      VerifyAddressVo verifyAddressVov = new VerifyAddressVo();
      verifyAddressVov.setCoinCode("DOGE");
      verifyAddressVov.setAddress("DFZZkycAygmoFei1yR46fiGrtwrwUNBJMz");
      verifyAddressVov.setMemo("1023809976");
      result = addressService.checkAddress(new OpenEntity(),verifyAddressVov);
      System.out.println("======checkAddress======================================");
      System.out.println(JSON.toJSONString(result) + "\n\n");


      DepositAddressVo depositAddressVo = new DepositAddressVo();
      depositAddressVo.setCoinCode("DOGE");
      depositAddressVo.setLimit(5);
      result = addressService.getDepositAddress(new OpenEntity(),depositAddressVo);
      System.out.println("======getDepositAddress======================================");
      System.out.println(JSON.toJSONString(result) + "\n\n");
   }
}
