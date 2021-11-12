package encry.service.impl;

import com.alibaba.fastjson.JSON;
import encry.entity.OpenEntity;
import encry.entity.OpenResult;
import encry.entity.OpenResultError;
import encry.entity.RPCResult;
import encry.entity.enums.ResultCode;
import encry.entity.vo.*;
import encry.service.TradeService;
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
public class TradeServiceImpl implements TradeService {


    /**
     * 发起提币申请
     * @param openEntity
     * @param withdrawApplyVo
     * @return
     */
    @Override
    public OpenResult withdrawApply(OpenEntity openEntity, WithdrawApplyVo withdrawApplyVo) {
        if(Objects.isNull(withdrawApplyVo) || StringUtils.isAnyBlank(withdrawApplyVo.getCoinCode(),withdrawApplyVo.getRequestOrderId(),
                withdrawApplyVo.getAddress() ,withdrawApplyVo.getAmount()) || Objects.isNull(withdrawApplyVo.getTimestamp()) ){
            return OpenResult.newError(new OpenResultError(ResultCode.PARAMTER_ERROR));
        }
        RPCResult rpcResult = RPCResult.placeDate("withdrawApply",withdrawApplyVo);
        String data = JSON.toJSONString(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);

    }

    /**
     * 根据请求订单号获取提币交易详情(queryByReqOrderId)
     *
     * @param openEntity
     * @param qryByReqOrderIdVo
     * @return
     */
    @Override
    public OpenResult queryByReqOrderId(OpenEntity openEntity, QryByReqOrderIdVo qryByReqOrderIdVo) {
        if(Objects.isNull(qryByReqOrderIdVo) || StringUtils.isAnyBlank(qryByReqOrderIdVo.getReqOrderId()) ){
            return OpenResult.newError(new OpenResultError(ResultCode.PARAMTER_ERROR));
        }
        RPCResult rpcResult = RPCResult.placeDate("queryByReqOrderId",qryByReqOrderIdVo);
        String data = JSON.toJSONString(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);
    }

    /**
     * 通过时间查询获取已确认交易记录列表
     *
     * @param openEntity
     * @param qryTradeListByDateVo
     * @return
     */
    @Override
    public OpenResult transactions(OpenEntity openEntity, QryTradeListByDateVo qryTradeListByDateVo) {
        if(Objects.isNull(qryTradeListByDateVo) || StringUtils.isAnyBlank(qryTradeListByDateVo.getOrderType()) ){
            return OpenResult.newError(new OpenResultError(ResultCode.PARAMTER_ERROR));
        }
        RPCResult rpcResult = RPCResult.placeDate("transactions",qryTradeListByDateVo);
        String data = JSON.toJSONString(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);
    }

    /**
     * 根据订单号获取已确认交易详情
     *
     * @param openEntity
     * @param qryTradeByOrderNoVo
     * @return
     */
    @Override
    public OpenResult transactionById(OpenEntity openEntity, QryTradeByOrderNoVo qryTradeByOrderNoVo) {
        if(Objects.isNull(qryTradeByOrderNoVo) || StringUtils.isAnyBlank(qryTradeByOrderNoVo.getOrderType(),qryTradeByOrderNoVo.getCustodyOrderId() ) ){
            return OpenResult.newError(new OpenResultError(ResultCode.PARAMTER_ERROR));
        }
        RPCResult rpcResult = RPCResult.placeDate("transactionById",qryTradeByOrderNoVo);
        String data = JSON.toJSONString(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);
    }

    /**
     * 通过时间查询获取确认中交易记录
     *
     * @param openEntity
     * @param qryTradeListByDateVo
     * @return
     */
    @Override
    public OpenResult pendingTransactions(OpenEntity openEntity, QryTradeListByDateVo qryTradeListByDateVo) {
        if(Objects.isNull(qryTradeListByDateVo) || StringUtils.isAnyBlank(qryTradeListByDateVo.getOrderType())){
            return OpenResult.newError(new OpenResultError(ResultCode.PARAMTER_ERROR));
        }
        RPCResult rpcResult = RPCResult.placeDate("pendingTransactions",qryTradeListByDateVo);
        String data = JSON.toJSONString(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);
    }

    /**
     * 根据id获取确认中的交易详情(pendingTransactionById)
     *
     * @param openEntity
     * @param qryTradeById
     * @return
     */
    @Override
    public OpenResult pendingTransactionById(OpenEntity openEntity, QryTradeByOrderNoVo qryTradeById) {
        if(Objects.isNull(qryTradeById) || StringUtils.isAnyBlank(qryTradeById.getOrderType(),qryTradeById.getCustodyOrderId())){
            return OpenResult.newError(new OpenResultError(ResultCode.PARAMTER_ERROR));
        }
        RPCResult rpcResult = RPCResult.placeDate("pendingTransactionById",qryTradeById);
        String data = JSON.toJSONString(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);
    }

    /**
     * 获取交易区块高度(blockHeight)
     *
     * @param openEntity
     * @param blockHeightVo
     * @return
     */
    @Override
    public OpenResult blockHeight(OpenEntity openEntity, BlockHeightVo blockHeightVo) {
        RPCResult rpcResult = RPCResult.placeDate("blockHeight",blockHeightVo);
        String data = JSON.toJSONString(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);
    }

    /**
     * 通过txHash 查询交易(transactionByTxHash)
     *
     * @param openEntity
     * @param Qvo
     * @return
     */
    @Override
    public OpenResult transactionByTxHash(OpenEntity openEntity, TradeByTxHashVo Qvo) {
        if(Objects.isNull(Qvo) || StringUtils.isAnyBlank(Qvo.getTxHash(),Qvo.getCoinCode())){
            return OpenResult.newError(new OpenResultError(ResultCode.PARAMTER_ERROR));
        }
        RPCResult rpcResult = RPCResult.placeDate("transactionByTxHash",Qvo);
        String data = JSON.toJSONString(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);
    }

    /**
     * 通过BlockHeight查询交易(transactionByBlockHeight)
     *
     * @param openEntity
     * @param Qvo
     * @return
     */
    @Override
    public OpenResult transactionByBlockHeight(OpenEntity openEntity, TradeByBlockHeightVo Qvo) {
        if(Objects.isNull(Qvo) || StringUtils.isAnyBlank(Qvo.getBlockHeight(),Qvo.getCoinCode())){
            return OpenResult.newError(new OpenResultError(ResultCode.PARAMTER_ERROR));
        }
        RPCResult rpcResult = RPCResult.placeDate("transactionByBlockHeight",Qvo);
        String data = JSON.toJSONString(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);
    }


    //todo param valid
}
