package encry.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerifyAddressVo {

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

}
