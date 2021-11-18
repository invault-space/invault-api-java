package encry.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZC
 * @Title:
 * @Description:
 * @date 2021/11/410:27 上午
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QryTradeByOrderNoVo {
    /**
     * custody order id
     */
    private  String custodyOrderId;
    /**
     * order type
     */
    private String orderType;

}
