package encry.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hy-210531
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawApplyVo {
    /**
     * request Order Id
     */
    private String requestOrderId;

    /**
     * coin code
     */
    private String coinCode;
    /**
     * address
     */
    private String address;
    /**
     * memo
     */
    private String memo;
    /**
     * amount
     */
    private String amount;
    /**
     * timestamp
     */
    private Long timestamp;

}
