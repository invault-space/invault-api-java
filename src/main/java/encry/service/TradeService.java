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


}
