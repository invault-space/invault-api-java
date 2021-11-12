package encry.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZC
 * @Title:
 * @Description:
 * @date 2021/9/42:18 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QryTradeListByDateVo {
    private String coinCode;
    private String orderType;
    private String address;
    private Long beginTime;
    private Long endTime;
}
