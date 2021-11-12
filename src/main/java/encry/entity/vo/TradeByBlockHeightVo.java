package encry.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZC
 * @Title:
 * @Description:
 * @date 2021/9/103:57 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TradeByBlockHeightVo {
    private String coinCode;
    private String blockHeight;

}

