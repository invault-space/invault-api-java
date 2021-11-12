package encry.service;

import encry.entity.OpenEntity;
import encry.entity.OpenResult;
import encry.entity.vo.*;

/**
 * @Classname queryAssetService
 * @Date 2021/11/8 15:01
 * @Created by zc
 * @Description
 */
public interface TradeService {
    /**
     * 发起提币申请
     * @param openEntity
     * @param withdrawApplyVo
     * @return
     */
    OpenResult withdrawApply(OpenEntity openEntity, WithdrawApplyVo withdrawApplyVo );

    /**
     * 根据请求订单号获取提币交易详情(queryByReqOrderId)
     * @param openEntity
     * @param qryByReqOrderIdVo
     * @return
     */
    OpenResult queryByReqOrderId(OpenEntity openEntity, QryByReqOrderIdVo qryByReqOrderIdVo );


    /**
     * 通过时间查询获取已确认交易记录列表
     * @param openEntity
     * @param qryTradeListByDateVo
     * @return
     */
    OpenResult transactions(OpenEntity openEntity, QryTradeListByDateVo qryTradeListByDateVo );

    /**
     * 根据订单号获取已确认交易详情
     * @param openEntity
     * @param qryTradeByOrderNoVo
     * @return
     */
    OpenResult transactionById(OpenEntity openEntity, QryTradeByOrderNoVo qryTradeByOrderNoVo );


    /**
     * 通过时间查询获取确认中交易记录
     * @param openEntity
     * @param qryTradeListByDateVo
     * @return
     */
    OpenResult pendingTransactions(OpenEntity openEntity, QryTradeListByDateVo qryTradeListByDateVo );


    /**
     * 根据id获取确认中的交易详情(pendingTransactionById)
     * @param openEntity
     * @param qryTradeById
     * @return
     */
    OpenResult pendingTransactionById(OpenEntity openEntity, QryTradeByOrderNoVo qryTradeById );



    /**
     * 获取交易区块高度(blockHeight)
     * @param openEntity
     * @param blockHeightVo
     * @return
     */
    OpenResult blockHeight(OpenEntity openEntity,  BlockHeightVo blockHeightVo);

    /**
     * 通过txHash 查询交易(transactionByTxHash)
     * @param openEntity
     * @param Qvo
     * @return
     */
    OpenResult transactionByTxHash(OpenEntity openEntity, TradeByTxHashVo Qvo);

    /**
     * 通过BlockHeight查询交易(transactionByBlockHeight)
     * @param openEntity
     * @param Qvo
     * @return
     */
    OpenResult transactionByBlockHeight(OpenEntity openEntity, TradeByBlockHeightVo Qvo);


}
