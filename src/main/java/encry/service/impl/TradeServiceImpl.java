package encry.service.impl;

import com.alibaba.fastjson.JSON;
import encry.entity.OpenEntity;
import encry.entity.OpenResult;
import encry.entity.RPCResult;
import encry.entity.vo.*;
import encry.service.AddressService;
import encry.service.TradeService;
import encry.utils.HttpClientUtil;
import encry.utils.SignUtils;

/**
 * @author zc
 * @Classname queryAssetServiceImpl
 * @Date 2021/11/8 15:04
 * @Description
 */
public class TradeServiceImpl implements TradeService {


    /**
     * 发起提币申请
     * @param openEntity
     * @param withdrawApplyVo
     * @return
     */
    @Override
    public OpenResult withdrawApply(OpenEntity openEntity, WithdrawApplyVo withdrawApplyVo) {
        RPCResult rpcResult = RPCResult.placeDate("withdrawApply",withdrawApplyVo);
        String data = JSON.toJSONString(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);

    }
}
