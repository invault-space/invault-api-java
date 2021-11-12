package encry.entity.enums;

import java.util.Objects;

/**
 * @author luiz
 * @Title: ResultCode
 * @ProjectName iot
 * @Description
 * @date 2019-04-03 16:00
 * <p>
 * system        | 00000-09999 | system|
 * common       | 01000-01999 | system|
 * customer      | 10000-19999 | customer|
 * authority     | 10000-10999 | customer|
 * security      | 11000-11999 | customer|
 * wallet        | 20000-29999 | wallet|
 * asset_coin    | 20000-20199 | wallet|
 * trade         | 21000-21999 | wallet|
 */
public enum ResultCode {

    PARAMTER_ERROR("09501", "参数校验错误"),
    GET_CHAIN_ADDR_ERROR("09502", "从链服务获取地址失败"),
    // OpenApi code 02000-02999  - 以及open http错误代码
    OPEN_LIMIT("429", "Too Many Requests"),
    OPEN_FAIL("500", "Server Error"),
    OPEN_NOT_DATA("02001", "NO Date"),

    OPEN_SIX_NULL("02002", "number参数缺少"),
    OPEN_SIX_INT("02003", "number参数格式有误"),
    OPEN_TIME_NULL("02004", "timeStamp Parameter is missing"),
    OPEN_KEY_NULL("02005", "keyStr Parameter is missing"),
    OPEN_KEY_UUID("02006", "keyStr parameter binding key does not exist"),
    OPEN_SIGN_NULL("02007", "Signature headers miss"),
    OPEN_SIGN_CHECK("02008", "Signature verify fail"),
    OPEN_GET_IP("02009", "Unable to get the requester ip address"),
    OPEN_IP_CHECK("02010", "ip whitelist restriction"),
    OPEN_KEY_CHECK("02011", "Decryption failed"),
    OPEN_RPC_CHECK("02012", "Does not conform to the JSON-RPC parameter specification"),
    OPEN_ACCESS_CODE("02013", "The method access ID is wrong"),
    OPEN_INTERFACE_ERROR("02014", "Repeat request"),
    OPEN_KEY_STATUS("02015", "The keyStr parameter status does not support access"),
    OPEN_KEY_EXISTS("02016", "The same Api Key already exists"),

    OPEN_ASSET_CODE("02050", "The wallet bound to keyStr does not exist"),
    OPEN_ASSET_NO("02051", "Asset information does not exist"),
    OPEN_COIN_CODE("02052", "Currency information does not exist"),
    OPEN_COIN_ADDRESS("02053", "Address information does not exist"),
    OPEN_COIN_CHECK("02054", "The coinCode parameter is missing"),
    OPEN_ASSET_CHECK("02055", "The assetCode parameter is missing"),
    OPEN_TIMESTAMP_LENGTH_ERROR("02056", "Timestamp length is incorrect"),
    OPEN_PARAM_IS_NULL("02027", "Incorrect parameter format"),
    OPEN_COMMON_FAIL("02028", "The system is out of order, please contact the system administrator"),
    OPEN_WALLET_CUSTOM_EXCEPTION("02029", "User failed to bind address (redis is empty)!"),
    OPEN_WITHDRAW_FAIL("02030", "Failed to initiate a withdrawal application!"),
    OPEN_COIN_STATUS_ERROR("02031", "The current currency status is abnormal!"),
    OPEN_NO_THIS_ORDER("02032", "The order number does not exist!"),
    OPEN_ORDER_TYPE_NULL("02032", "The order number or order type cannot be empty!"),
    OPEN_ORDER_TXHSAH_NULL("02033", "The order number or transaction hash cannot be empty!"),
    OPEN_ORDER_HEIGHT_NULL("02034", "The order number or transaction block height cannot be empty!"),
    OPEN_BACK_EXISTS("02035", "The callback address already exists!"),
    OPEN_NEW_BACK_ERROR("02036", "Failed to insert callback address" ),
    OPEN_MODI_BACK_ERROR("02037", "Callback address modification failed" ),
    OPEN_ADDRESS_CHECK_ERROR("02038", "chain address verification is abnormal" ),
    OPEN_CHECK_NOCHECK_ERROR("02039", "Please verify the address first" ),
    OPEN_NO_NEED_CHECK_ERROR("02040", "It has been verified, please do not repeat the verification" ),
    OPEN_CHECK_STATUS_ERROR("02041", "Callback address status is abnormal" ),
    OPEN_NOTIFY_SERVER_ERROR("02042", "Notification service exception" ),
    OPEN_SPACE_DATA_ERROR("02043", "The wallet data is incomplete or incorrect" ),
    OPEN_IMPORT_DATA_ERROR("02044", "Import GB data error" ),


    ;

    String code;
    String message;
    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static final ResultCode matching(String code) {
        for (ResultCode resultCode : ResultCode.values()) {
            if (Objects.equals(resultCode.getCode(), code)) {
                return resultCode;
            }
        }
        return null;
    }

    public static final ResultCode matchingValidName(String resultName) {
        for (ResultCode resultCode : ResultCode.values()) {
            if (Objects.equals(resultCode.name(), resultName)) {
                return resultCode;
            }
        }
        return null;
    }
}
