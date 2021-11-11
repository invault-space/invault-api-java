package encry.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawApplyVo {
    private String requestOrderId;

    private String coinCode;

    private String address;

    private String memo;

    private String amount;

    private Long timestamp;

}
