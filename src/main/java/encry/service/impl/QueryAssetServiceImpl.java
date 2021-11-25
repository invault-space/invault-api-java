package encry.service.impl;

import com.alibaba.fastjson.JSON;
import encry.entity.OpenEntity;
import encry.entity.OpenResult;
import encry.entity.OpenResultError;
import encry.entity.RPCResult;
import encry.entity.enums.ResultCode;
import encry.entity.vo.AssetCodeVo;
import encry.entity.vo.CoinCodePageVo;
import encry.entity.vo.CoinCodeVo;
import encry.service.QueryAssetService;
import encry.utils.HttpClientUtil;
import encry.utils.SignUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author zc
 * @Classname queryAssetServiceImpl
 * @Date 2021/11/8 15:04
 * @Description
 */
public class QueryAssetServiceImpl implements QueryAssetService {

    @Override
    public OpenResult queryAssets(OpenEntity entity) {
        RPCResult rpcResult = RPCResult.placeDate("queryAssets",null);
        String data = SignUtils.JsonSort(rpcResult);
        String sign = SignUtils.sign(entity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(entity.getKeyStr(),sign,entity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);
    }

    /**
     * Query the details of the specified assets under the wallet
     *
     * @param openEntity
     * @param assetCodeVo
     * @return
     */
    @Override
    public OpenResult queryAssetByCode(OpenEntity openEntity, AssetCodeVo assetCodeVo) {
        if(Objects.isNull(assetCodeVo) || StringUtils.isBlank(assetCodeVo.getAssetCode())){
            return OpenResult.newError(new OpenResultError(ResultCode.OPEN_PARAM_IS_NULL));
        }

        RPCResult rpcResult = RPCResult.placeDate("queryAssetByCode",assetCodeVo);
        String data = SignUtils.JsonSort(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);

    }

    /**
     *
     * Check the currency of the wallet
     *
     * @param openEntity
     * @return
     */
    @Override
    public OpenResult queryCoins(OpenEntity openEntity) {
        RPCResult rpcResult = RPCResult.placeDate("queryCoins",null);
        String data = SignUtils.JsonSort(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);

    }

    /**
     * Query the details of the specified currency under the wallet
     *
     * @param openEntity
     * @param coinCodeVo
     * @return
     */
    @Override
    public OpenResult queryCoinByCode(OpenEntity openEntity, CoinCodeVo coinCodeVo) {
        if(Objects.isNull(coinCodeVo) || StringUtils.isBlank(coinCodeVo.getCoinCode())){
            return OpenResult.newError(new OpenResultError(ResultCode.OPEN_PARAM_IS_NULL));
        }
        RPCResult rpcResult = RPCResult.placeDate("queryCoinByCode",coinCodeVo);
        String data = SignUtils.JsonSort(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);

    }

}
