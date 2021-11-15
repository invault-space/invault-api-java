package encry.example;

import com.alibaba.fastjson.JSON;
import encry.entity.OpenEntity;
import encry.entity.OpenResult;
import encry.entity.vo.AssetCodeVo;
import encry.entity.vo.CoinCodePageVo;
import encry.entity.vo.CoinCodeVo;
import encry.service.AddressService;
import encry.service.QueryAssetService;
import encry.service.impl.AddressServiceImpl;
import encry.service.impl.QueryAssetServiceImpl;

/**
 * @Classname QueryAssetsAndCoin
 * @Date 2021/11/15 10:47
 * @Created by chenrujia
 * @Description
 */
public class QueryAssetsAndCoin {
    public static void main(String[] args) {
        QueryAssetService queryAssetService = new QueryAssetServiceImpl();
        AddressService addressService = new AddressServiceImpl();
        OpenResult result = new OpenResult();

        result = queryAssetService.queryAssets(new OpenEntity());
        System.out.println("======queryAssets===================================");
        System.out.println(JSON.toJSONString(result) + "\n\n");


        result = queryAssetService.queryAssetByCode(new OpenEntity(), new AssetCodeVo("BNB"));
        System.out.println("======queryAssetByCode=================================");
        System.out.println(JSON.toJSONString(result) + "\n\n");


        result = queryAssetService.queryCoins(new OpenEntity());
        System.out.println("======queryCoins======================================");
        System.out.println(JSON.toJSONString(result) + "\n\n");


        result = queryAssetService.queryCoinByCode(new OpenEntity(), new CoinCodeVo("ETH"));
        System.out.println("======queryCoinByCode======================================");
        System.out.println(JSON.toJSONString(result) + "\n\n");
    }
}
