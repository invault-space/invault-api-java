package encry.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositAddressVo {
    /**
     * coin code
     */
    private String coinCode;
    /**
     *limit number
     */
    private int limit;
}
