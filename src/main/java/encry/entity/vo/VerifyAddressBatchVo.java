package encry.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class VerifyAddressBatchVo {

    private String coinCode;
    private List<Address> addressList;

}


