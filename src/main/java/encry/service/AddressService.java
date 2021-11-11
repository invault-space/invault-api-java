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
public interface AddressService {
    /**
     * 查询币种地址总表
     * @param openEntity
     * @param coinCodePageVo
     * @return
     */
    OpenResult queryAddressesByCoinCode(OpenEntity openEntity, CoinCodePageVo coinCodePageVo );

    /**
     * 批量校验地址信息
     * @param openEntity
     * @param verifyAddressBatchVo
     * @return
     */
    OpenResult queryAddressesInfo(OpenEntity openEntity,  VerifyAddressBatchVo verifyAddressBatchVo);


    /**
     * 验证地址合法性
     * @param openEntity
     * @param verifyAddressVo
     * @return
     */
    OpenResult checkAddress(OpenEntity openEntity,  VerifyAddressVo verifyAddressVo);


    /**
     * 获取充值地址
     * @param openEntity
     * @param depositAddressVo
     * @return
     */
    OpenResult getDepositAddress(OpenEntity openEntity,  DepositAddressVo depositAddressVo);




}
