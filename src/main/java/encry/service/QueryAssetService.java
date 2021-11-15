package encry.service;

import encry.entity.OpenEntity;
import encry.entity.OpenResult;
import encry.entity.vo.AssetCodeVo;
import encry.entity.vo.CoinCodePageVo;
import encry.entity.vo.CoinCodeVo;

/**
 * @Classname queryAssetService
 * @Date 2021/11/8 15:01
 * @Created by chenrujia
 * @Description
 */
public interface QueryAssetService {
    OpenResult queryAssets(OpenEntity openEntity);


    /**
     * Query the details of the specified assets under the wallet
     * @param openEntity
     * @param assetCodeVo
     * @return
     */
    OpenResult queryAssetByCode(OpenEntity openEntity , AssetCodeVo assetCodeVo);

    /**
     * Check the currency of the wallet
     * @param openEntity
     * @return
     */
    OpenResult queryCoins(OpenEntity openEntity );


    /**
     *
     * Query the details of the specified currency under the wallet
     * @param openEntity
     * @param coinCodeVo
     * @return
     */
    OpenResult queryCoinByCode(OpenEntity openEntity, CoinCodeVo coinCodeVo );

}
