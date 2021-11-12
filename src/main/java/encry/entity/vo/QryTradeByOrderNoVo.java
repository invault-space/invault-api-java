package encry.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZC
 * @Title:
 * @Description:
 * @date 2021/9/410:27 上午
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QryTradeByOrderNoVo {
    private  String custodyOrderId;
    private String orderType;

}
