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
public class TradeByTxHashVo {
    /**
     * coin code
     */
    private String coinCode;
    /**
     * transaction hash
     */
    private String txHash;

}

