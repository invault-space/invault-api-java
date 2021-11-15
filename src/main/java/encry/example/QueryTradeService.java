package encry.example;

import com.alibaba.fastjson.JSON;
import encry.entity.OpenEntity;
import encry.entity.OpenResult;
import encry.entity.vo.*;
import encry.service.TradeService;
import encry.service.impl.TradeServiceImpl;

/**
 * @Classname QueryTradeService
 * @Date 2021/11/15 15:20
 * @Created by chenrujia
 * @Description
 */
public class QueryTradeService {
   public static void main(String[] args) {
    TradeService tradeService = new TradeServiceImpl();
    OpenResult result = new OpenResult();
    QryTradeListByDateVo qryTradeListByDateVo1 = QryTradeListByDateVo.builder()
            .orderType("deposit")
            .coinCode("ETH")
            .build();
    result = tradeService.transactions(new OpenEntity(), qryTradeListByDateVo1);
    System.out.println("======transactions======================================");
    System.out.println(JSON.toJSONString(result) + "\n\n");



    result = tradeService.transactionById(new OpenEntity(), new QryTradeByOrderNoVo("O1451079599671738368","deposit"));
    System.out.println("======transactionById======================================");
    System.out.println(JSON.toJSONString(result) + "\n\n");


    QryTradeListByDateVo qryTradeListByDateVo = QryTradeListByDateVo.builder()
            .orderType("deposit")
            .coinCode("ETH")
            .build();
    result = tradeService.pendingTransactions(new OpenEntity(),qryTradeListByDateVo);
    System.out.println("13  ======pendingTransactions======================================");
    System.out.println(JSON.toJSONString(result) + "\n\n");


    result = tradeService.pendingTransactionById(new OpenEntity(), new QryTradeByOrderNoVo("O1425046202105200640","deposit"));
    System.out.println("======pendingTransactionById======================================");
    System.out.println(JSON.toJSONString(result) + "\n\n");


    result = tradeService.transactionByTxHash(new OpenEntity(), new TradeByTxHashVo("ETH","0x72d68d09a4804d88f683cfaff4fa8095433875793d5b80cef0da869ab886aeae"));
    System.out.println("======transactionByTxHash======================================");
    System.out.println(JSON.toJSONString(result) + "\n\n");


    result = tradeService.blockHeight(new OpenEntity(), new BlockHeightVo());
    System.out.println("======blockHeight======================================");
    System.out.println(JSON.toJSONString(result) + "\n\n");


    result = tradeService.transactionByBlockHeight(new OpenEntity(), new TradeByBlockHeightVo("ETH","11116151"));
    System.out.println("======transactionByBlockHeight======================================");
    System.out.println(JSON.toJSONString(result) + "\n\n");
   }
}
