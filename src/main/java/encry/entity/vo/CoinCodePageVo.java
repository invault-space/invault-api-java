package encry.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zc
 * @Classname AssetCodeVo
 * @Date 2021/9/6 11:26
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinCodePageVo {
    private String coinCode;
    private Integer pageNum;
    private Integer pageSize;
}
