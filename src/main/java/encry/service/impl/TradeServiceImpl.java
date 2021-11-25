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
     * Initiate a withdrawal application
     * @param openEntity
     * @param withdrawApplyVo
     * @return
     */
    @Override
    public OpenResult withdrawApply(OpenEntity openEntity, WithdrawApplyVo withdrawApplyVo) {
        if(Objects.isNull(withdrawApplyVo) || StringUtils.isAnyBlank(withdrawApplyVo.getCoinCode(),withdrawApplyVo.getRequestOrderId(),
                withdrawApplyVo.getAddress() ,withdrawApplyVo.getAmount()) || Objects.isNull(withdrawApplyVo.getTimestamp()) ){
            return OpenResult.newError(new OpenResultError(ResultCode.OPEN_PARAM_IS_NULL));
        }
        RPCResult rpcResult = RPCResult.placeDate("withdrawApply",withdrawApplyVo);
        String data = SignUtils.JsonSort(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);

    }

    /**
     * Get the details of the withdrawal transaction according to the requested order number(queryByReqOrderId)
     *
     * @param openEntity
     * @param qryByReqOrderIdVo
     * @return
     */
    @Override
    public OpenResult queryByReqOrderId(OpenEntity openEntity, QryByReqOrderIdVo qryByReqOrderIdVo) {
        if(Objects.isNull(qryByReqOrderIdVo) || StringUtils.isAnyBlank(qryByReqOrderIdVo.getReqOrderId()) ){
            return OpenResult.newError(new OpenResultError(ResultCode.OPEN_PARAM_IS_NULL));
        }
        RPCResult rpcResult = RPCResult.placeDate("queryByReqOrderId",qryByReqOrderIdVo);
        String data = SignUtils.JsonSort(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);
    }

    /**
     *
     * Get a list of confirmed transaction records through time query
     *
     * @param openEntity
     * @param qryTradeListByDateVo
     * @return
     */
    @Override
    public OpenResult transactions(OpenEntity openEntity, QryTradeListByDateVo qryTradeListByDateVo) {
        if(Objects.isNull(qryTradeListByDateVo) || StringUtils.isAnyBlank(qryTradeListByDateVo.getOrderType()) ){
            return OpenResult.newError(new OpenResultError(ResultCode.OPEN_PARAM_IS_NULL));
        }
        RPCResult rpcResult = RPCResult.placeDate("transactions",qryTradeListByDateVo);
        String data = SignUtils.JsonSort(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);
    }

    /**
     * Get confirmed transaction details based on the order number
     *
     * @param openEntity
     * @param qryTradeByOrderNoVo
     * @return
     */
    @Override
    public OpenResult transactionById(OpenEntity openEntity, QryTradeByOrderNoVo qryTradeByOrderNoVo) {
        if(Objects.isNull(qryTradeByOrderNoVo) || StringUtils.isAnyBlank(qryTradeByOrderNoVo.getOrderType(),qryTradeByOrderNoVo.getCustodyOrderId() ) ){
            return OpenResult.newError(new OpenResultError(ResultCode.OPEN_PARAM_IS_NULL));
        }
        RPCResult rpcResult = RPCResult.placeDate("transactionById",qryTradeByOrderNoVo);
        String data = SignUtils.JsonSort(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);
    }

    /**
     * Obtain confirmation transaction records through time query
     *
     * @param openEntity
     * @param qryTradeListByDateVo
     * @return
     */
    @Override
    public OpenResult pendingTransactions(OpenEntity openEntity, QryTradeListByDateVo qryTradeListByDateVo) {
        if(Objects.isNull(qryTradeListByDateVo) || StringUtils.isAnyBlank(qryTradeListByDateVo.getOrderType())){
            return OpenResult.newError(new OpenResultError(ResultCode.OPEN_PARAM_IS_NULL));
        }
        RPCResult rpcResult = RPCResult.placeDate("pendingTransactions",qryTradeListByDateVo);
        String data = SignUtils.JsonSort(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);
    }

    /**
     * Get the transaction details in confirmation according to id(pendingTransactionById)
     *
     * @param openEntity
     * @param qryTradeById
     * @return
     */
    @Override
    public OpenResult pendingTransactionById(OpenEntity openEntity, QryTradeByOrderNoVo qryTradeById) {
        if(Objects.isNull(qryTradeById) || StringUtils.isAnyBlank(qryTradeById.getOrderType(),qryTradeById.getCustodyOrderId())){
            return OpenResult.newError(new OpenResultError(ResultCode.OPEN_PARAM_IS_NULL));
        }
        RPCResult rpcResult = RPCResult.placeDate("pendingTransactionById",qryTradeById);
        String data = SignUtils.JsonSort(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);
    }

    /**
     * Get the height of the transaction block(blockHeight)
     *
     * @param openEntity
     * @param blockHeightVo
     * @return
     */
    @Override
    public OpenResult blockHeight(OpenEntity openEntity, BlockHeightVo blockHeightVo) {
        RPCResult rpcResult = RPCResult.placeDate("blockHeight",blockHeightVo);
        String data = SignUtils.JsonSort(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);
    }

    /**
     * Query transactions through txHash(transactionByTxHash)
     *
     * @param openEntity
     * @param Qvo
     * @return
     */
    @Override
    public OpenResult transactionByTxHash(OpenEntity openEntity, TradeByTxHashVo Qvo) {
        if(Objects.isNull(Qvo) || StringUtils.isAnyBlank(Qvo.getTxHash(),Qvo.getCoinCode())){
            return OpenResult.newError(new OpenResultError(ResultCode.OPEN_PARAM_IS_NULL));
        }
        RPCResult rpcResult = RPCResult.placeDate("transactionByTxHash",Qvo);
        String data = SignUtils.JsonSort(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);
    }

    /**
     * Query transactions through BlockHeight(transactionByBlockHeight)
     *
     * @param openEntity
     * @param Qvo
     * @return
     */
    @Override
    public OpenResult transactionByBlockHeight(OpenEntity openEntity, TradeByBlockHeightVo Qvo) {
        if(Objects.isNull(Qvo) || StringUtils.isAnyBlank(Qvo.getBlockHeight(),Qvo.getCoinCode())){
            return OpenResult.newError(new OpenResultError(ResultCode.OPEN_PARAM_IS_NULL));
        }
        RPCResult rpcResult = RPCResult.placeDate("transactionByBlockHeight",Qvo);
        String data = SignUtils.JsonSort(rpcResult);
        String sign = SignUtils.sign(openEntity.getPrivateKey(),data);
        String context = HttpClientUtil.doPostJson(openEntity.getKeyStr(),sign,openEntity.getURL(),data);
        return JSON.parseObject(context,OpenResult.class);
    }


}
