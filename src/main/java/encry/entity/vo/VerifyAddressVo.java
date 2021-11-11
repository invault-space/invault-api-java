package encry.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerifyAddressVo {

    private String coinCode;    //	币种简称
    private String address;     //	地址
    private String memo;        //	memo

}
