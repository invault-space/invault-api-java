package encry.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZC
 * @Title:
 * @Description:
 * @date 2021/11/411:58 上午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QryByReqOrderIdVo {
    /**
     * request order number
     */
    private String reqOrderId;
}
