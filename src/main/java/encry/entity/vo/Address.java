package encry.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZC
 * @Title:
 * @Description:
 * @date 2021/11/14 2:53 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    /**
     * address
     */
    private String address;
    /**
     * memo
     */
    private String memo;
}
