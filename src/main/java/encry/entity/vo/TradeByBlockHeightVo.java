package encry.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZC
 * @Title:
 * @Description:
 * @date 2021/11/103:57 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TradeByBlockHeightVo {
    /**
     * coin code
     */
    private String coinCode;
    /**
     * block height
     */
    private String blockHeight;

}

