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
     * Query the currency address summary table
     * @param openEntity
     * @param coinCodePageVo
     * @return
     */
    OpenResult queryAddressesByCoinCode(OpenEntity openEntity, CoinCodePageVo coinCodePageVo );

    /**
     *
     * Batch verification of address information
     * @param openEntity
     * @param verifyAddressBatchVo
     * @return
     */
    OpenResult queryAddressesInfo(OpenEntity openEntity,  VerifyAddressBatchVo verifyAddressBatchVo);


    /**
     * Verify address legitimacy
     * @param openEntity
     * @param verifyAddressVo
     * @return
     */
    OpenResult checkAddress(OpenEntity openEntity,  VerifyAddressVo verifyAddressVo);


    /**
     *
     * Get the top-up address
     * @param openEntity
     * @param depositAddressVo
     * @return
     */
    OpenResult getDepositAddress(OpenEntity openEntity,  DepositAddressVo depositAddressVo);

}
