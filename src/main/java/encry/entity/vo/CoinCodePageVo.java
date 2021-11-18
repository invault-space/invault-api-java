package encry.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zc
 * @Classname AssetCodeVo
 * @Date 2021/11/6 11:26
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinCodePageVo {

    /**
     * coin code
     */
    private String coinCode;
    /**
     * page num
     */
    private Integer pageNum;
    /**
     * page size
     */
    private Integer pageSize;
}
