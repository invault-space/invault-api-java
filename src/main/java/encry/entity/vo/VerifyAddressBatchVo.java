package encry.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class VerifyAddressBatchVo {

    /**
     * coin code
     */
    private String coinCode;
    /**
     * address list
     */
    private List<Address> addressList;

}


