package encry.service.impl;

import com.alibaba.fastjson.JSON;
import encry.entity.OpenEntity;
import encry.entity.OpenResult;
import encry.entity.OpenResultError;
import encry.entity.RPCResult;
import encry.entity.enums.ResultCode;
import encry.entity.vo.*;
import encry.service.AddressService;
import encry.service.QueryAssetService;
import encry.utils.HttpClientUtil;
import encry.utils.SignUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author zc
 * @Classname queryAssetServiceImpl
 * @Date 2021/11/8 15:04
 * @Description
 */
public class AddressServiceImpl implements AddressService {
    /**
     * 查询币种地址总表
     * @param openEntity
     * @param coinCodePageVo
     * @return
     */
    @Override
    public OpenResult queryAddressesByCoinCode(OpenEntity openEntity, CoinCodePageVo coinCodePageVo) {
        if(Objects.isNull(coinCodePageVo) || StringUtils.isBlank(coinCodePageVo.getCoinCode())){
            return OpenResult.newError(new OpenResultError(ResultCode.PARAMTER_ERROR));
        }
        RPCResult rpcResult = RPCResult.placeDate("queryAddressesByCoinCode",coinCodePageVo);
        String data = JSON.toJSONString(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);

    }

    /**
     * 批量校验地址信息
     *
     * @param openEntity
     * @param verifyAddressBatchVo
     * @return
     */
    @Override
    public OpenResult queryAddressesInfo(OpenEntity openEntity, VerifyAddressBatchVo verifyAddressBatchVo) {
        if(Objects.isNull(verifyAddressBatchVo) || Objects.isNull(verifyAddressBatchVo.getAddressList())|| StringUtils.isBlank(verifyAddressBatchVo.getCoinCode()) ){
            return OpenResult.newError(new OpenResultError(ResultCode.PARAMTER_ERROR));
        }
        RPCResult rpcResult = RPCResult.placeDate("queryAddressesInfo",verifyAddressBatchVo);
        String data = JSON.toJSONString(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);
    }

    /**
     * 验证地址合法性
     *
     * @param openEntity
     * @param verifyAddressVo
     * @return
     */
    @Override
    public OpenResult checkAddress(OpenEntity openEntity, VerifyAddressVo verifyAddressVo) {
        if(Objects.isNull(verifyAddressVo) || StringUtils.isAnyBlank(verifyAddressVo.getCoinCode(),verifyAddressVo.getAddress()) ){
            return OpenResult.newError(new OpenResultError(ResultCode.PARAMTER_ERROR));
        }
        RPCResult rpcResult = RPCResult.placeDate("checkAddress",verifyAddressVo);
        String data = JSON.toJSONString(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);
    }

    /**
     * 获取充值地址
     *
     * @param openEntity
     * @param depositAddressVo
     * @return
     */
    @Override
    public OpenResult getDepositAddress(OpenEntity openEntity, DepositAddressVo depositAddressVo ) {
        if(Objects.isNull(depositAddressVo) || StringUtils.isAnyBlank(depositAddressVo.getCoinCode())  ){
            return OpenResult.newError(new OpenResultError(ResultCode.PARAMTER_ERROR));
        }
        RPCResult rpcResult = RPCResult.placeDate("getDepositAddress",depositAddressVo);
        String data = JSON.toJSONString(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);
    }
}
