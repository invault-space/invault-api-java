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
     * Initiate a withdrawal application
     * @param openEntity
     * @param withdrawApplyVo
     * @return
     */
    OpenResult withdrawApply(OpenEntity openEntity, WithdrawApplyVo withdrawApplyVo );

    /**
     *
     * Get the details of the withdrawal transaction according to the requested order number(queryByReqOrderId)
     * @param openEntity
     * @param qryByReqOrderIdVo
     * @return
     */
    OpenResult queryByReqOrderId(OpenEntity openEntity, QryByReqOrderIdVo qryByReqOrderIdVo );


    /**
     * Get a list of confirmed transaction records through time query
     * @param openEntity
     * @param qryTradeListByDateVo
     * @return
     */
    OpenResult transactions(OpenEntity openEntity, QryTradeListByDateVo qryTradeListByDateVo );

    /**
     * Get confirmed transaction details based on the order number
     * @param openEntity
     * @param qryTradeByOrderNoVo
     * @return
     */
    OpenResult transactionById(OpenEntity openEntity, QryTradeByOrderNoVo qryTradeByOrderNoVo );


    /**
     * Obtain confirmation transaction records through time query
     * @param openEntity
     * @param qryTradeListByDateVo
     * @return
     */
    OpenResult pendingTransactions(OpenEntity openEntity, QryTradeListByDateVo qryTradeListByDateVo );


    /**
     * Get the transaction details in confirmation according to id(pendingTransactionById)
     * @param openEntity
     * @param qryTradeById
     * @return
     */
    OpenResult pendingTransactionById(OpenEntity openEntity, QryTradeByOrderNoVo qryTradeById );



    /**
     * Get the height of the transaction block(blockHeight)
     * @param openEntity
     * @param blockHeightVo
     * @return
     */
    OpenResult blockHeight(OpenEntity openEntity,  BlockHeightVo blockHeightVo);

    /**
     * Query transactions through txHash(transactionByTxHash)
     * @param openEntity
     * @param Qvo
     * @return
     */
    OpenResult transactionByTxHash(OpenEntity openEntity, TradeByTxHashVo Qvo);

    /**
     *
     * Query transactions through BlockHeight(transactionByBlockHeight)
     * @param openEntity
     * @param Qvo
     * @return
     */
    OpenResult transactionByBlockHeight(OpenEntity openEntity, TradeByBlockHeightVo Qvo);


}
