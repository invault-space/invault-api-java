package encry.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZC
 * @Title:
 * @Description:
 * @date 2021/11/42:18 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QryTradeListByDateVo {
    /**
     * coin code
     */
    private String coinCode;
    /**
     * order type
     */
    private String orderType;
    /**
     * address
     */
    private String address;
    /**
     * order begin Time
     */
    private Long beginTime;
    /**
     * order end Time
     */
    private Long endTime;
}
