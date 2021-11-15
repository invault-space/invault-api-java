package encry.example;

import com.alibaba.fastjson.JSON;
import encry.entity.OpenEntity;
import encry.entity.OpenResult;
import encry.entity.vo.QryByReqOrderIdVo;
import encry.entity.vo.WithdrawApplyVo;
import encry.service.TradeService;
import encry.service.impl.TradeServiceImpl;

/**
 * @Classname WithdrawApply
 * @Date 2021/11/15 14:12
 * @Created by chenrujia
 * @Description
 */
public class WithdrawApply {
   public static void main(String[] args) {
      TradeService tradeService = new TradeServiceImpl();
      OpenResult result = new OpenResult();
      WithdrawApplyVo withdrawApplyVo = new WithdrawApplyVo();
      withdrawApplyVo.setRequestOrderId("Order-XX932435");
      withdrawApplyVo.setCoinCode("ETH");
      withdrawApplyVo.setAddress("0x8994190AD3CCf2A32b2ba05afA68670061BE5845");
      withdrawApplyVo.setMemo("");
      withdrawApplyVo.setAmount("0.1");
      withdrawApplyVo.setTimestamp(System.currentTimeMillis());
      result = tradeService.withdrawApply(new OpenEntity(),withdrawApplyVo);
      System.out.println("======withdrawApply======================================");
      System.out.println(JSON.toJSONString(result) + "\n\n");


      result = tradeService.queryByReqOrderId(new OpenEntity(), new QryByReqOrderIdVo("Order-XX896786"));
      System.out.println("======queryByReqOrderId======================================");
      System.out.println(JSON.toJSONString(result) + "\n\n");
   }
}
