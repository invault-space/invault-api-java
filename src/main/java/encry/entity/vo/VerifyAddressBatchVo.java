package encry.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class VerifyAddressBatchVo {

    private String coinCode;    //	币种简称
    private List<Address> addressList;

}


