package encry;

import com.alibaba.fastjson.JSON;
import encry.entity.OpenEntity;
import encry.entity.OpenResult;
import encry.entity.vo.*;
import encry.service.AddressService;
import encry.service.QueryAssetService;
import encry.service.TradeService;
import encry.service.impl.AddressServiceImpl;
import encry.service.impl.QueryAssetServiceImpl;
import encry.service.impl.TradeServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Classname RequestDemo
 * @Date 2021/11/9 10:49
 * @Created by zc
 * @Description
 */
public class RequestDemo {

    public static void main(String[] args) {
        // Request queryAssets
        QueryAssetService queryAssetService = new QueryAssetServiceImpl();
        AddressService addressService = new AddressServiceImpl();
        TradeService tradeService = new TradeServiceImpl();
        OpenResult result = new OpenResult();

//        queryAssetService.queryAssets(new OpenEntity());
//        System.out.println("'111======queryAssets===================================");
//        System.out.println(JSON.toJSONString(result) + "\n\n");
//
//
//        result = queryAssetService.queryAssetByCode(new OpenEntity(), new AssetCodeVo("BNB"));
//        System.out.println("222======queryAssetByCode=================================");
//        System.out.println(JSON.toJSONString(result) + "\n\n");
//
//
//        result = queryAssetService.queryCoins(new OpenEntity());
//        System.out.println("3333======queryCoins======================================");
//        System.out.println(JSON.toJSONString(result) + "\n\n");
//
//
//        result = queryAssetService.queryCoinByCode(new OpenEntity(), new CoinCodeVo("ETH"));
//        System.out.println("4444======queryCoinByCode======================================");
//        System.out.println(JSON.toJSONString(result) + "\n\n");
//
//
//        result = addressService.queryAddressesByCoinCode(new OpenEntity(), new CoinCodePageVo("CLV", 1, 5));
//        System.out.println("5555======queryCoinByCode======================================");
//        System.out.println(JSON.toJSONString(result) + "\n\n");


//        VerifyAddressBatchVo vo = new VerifyAddressBatchVo();
//            vo.setCoinCode("DOGE");
//        List list = new ArrayList();
//        list.add(new Address("DL5Var6gmHqniNtGcsGrLbZXfQvNz3nxrk", "1023809976"));
//        list.add(new Address("5F4tvhVffTEZLpVg8Xy39EX3seVk7cKXLJ1rff8mnH7E4eNo", null));
//        list.add(new Address("DRQtiyCpM1cqaFHe7eG9FZVia6ZVoY4RA9", null));
//        vo.setAddressList(list);
//        result = addressService.queryAddressesInfo(new OpenEntity(),vo);
//        System.out.println("6666======queryAddressesInfo======================================");
//        System.out.println(JSON.toJSONString(result) + "\n\n");
//
//
//
//        VerifyAddressVo verifyAddressVov = new VerifyAddressVo();
//        verifyAddressVov.setCoinCode("DOGE");
//        verifyAddressVov.setAddress("DFZZkycAygmoFei1yR46fiGrtwrwUNBJMz");
//        verifyAddressVov.setMemo("1023809976");
//        result = addressService.checkAddress(new OpenEntity(),verifyAddressVov);
//        System.out.println("6666======checkAddress======================================");
//        System.out.println(JSON.toJSONString(result) + "\n\n");
//
//
//
//        DepositAddressVo depositAddressVo = new DepositAddressVo();
//        depositAddressVo.setCoinCode("DOGE");
//        depositAddressVo.setLimit(5);
//        result = addressService.getDepositAddress(new OpenEntity(),depositAddressVo);
//        System.out.println("6666======checkAddress======================================");
//        System.out.println(JSON.toJSONString(result) + "\n\n");
//


        WithdrawApplyVo withdrawApplyVo = new WithdrawApplyVo();
        withdrawApplyVo.setRequestOrderId("Order-XX896786");
        withdrawApplyVo.setCoinCode("ETH");
        withdrawApplyVo.setAddress("0x8994190AD3CCf2A32b2ba05afA68670061BE5845");
        withdrawApplyVo.setMemo("");
        withdrawApplyVo.setAmount("0.1");
        withdrawApplyVo.setTimestamp(System.currentTimeMillis());
        result = tradeService.withdrawApply(new OpenEntity(),withdrawApplyVo);
        System.out.println("6666======checkAddress======================================");
        System.out.println(JSON.toJSONString(result) + "\n\n");

    }

}
