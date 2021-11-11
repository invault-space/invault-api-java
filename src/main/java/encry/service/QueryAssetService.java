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
     * 查询钱包下指定资产详情
     * @param openEntity
     * @param assetCodeVo
     * @return
     */
    OpenResult queryAssetByCode(OpenEntity openEntity , AssetCodeVo assetCodeVo);

    /**
     * 查询钱包下币种
     * @param openEntity
     * @return
     */
    OpenResult queryCoins(OpenEntity openEntity );


    /**
     * 查询钱包下指定币种详情
     * @param openEntity
     * @param coinCodeVo
     * @return
     */
    OpenResult queryCoinByCode(OpenEntity openEntity, CoinCodeVo coinCodeVo );



}
