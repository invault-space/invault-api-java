package encry.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import encry.entity.RPCResult;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.TreeMap;

/**
 * @Classname SignUtils
 * @Date 2021/8/24 18:20
 * @Created by chenrujia
 * @Description
 */
public class SignUtils {

    //Encryption Algorithm
    private static final String SHA256WithRSA = "SHA256WithRSA";

    private static final String RSA = "RSA";

    /**
     * SHA256 encryption
     * @param str
     * @return
     */
    public static String SHA256Str(String str){
        MessageDigest messageDigest;
        String encdeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
            encdeStr = Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encdeStr.toUpperCase();
    }

    /**
     * Get the current timestamp, in milliseconds
     * @return
     */
    public static long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * Use the private key to sign the incoming parameters
     * @param privateKey Private key
     * @param param      Signed data
     * @return
     * Return the input parameter signature hexadecimal string
     * */
    public static String sign(String privateKey, String param) {
        try {
            //Get privatekey
            byte[] privateKeyByte = new org.apache.commons.codec.binary.Base64().decode(privateKey);
            KeyFactory keyfactory = KeyFactory.getInstance(RSA);
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKeyByte);
            PrivateKey key = keyfactory.generatePrivate(pkcs8EncodedKeySpec);

            //Sign in with the private key
            Signature sign = Signature.getInstance(SHA256WithRSA);
            sign.initSign(key);
            sign.update(param.getBytes());

            byte[] signature = sign.sign();
            //Convert signed input parameters into hexadecimal string
            return bytesToHexStr(signature);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Verify signature with public key
     * @param param       Participate
     * @param signature   Input parameter string signed with private key
     * @param publicKey   Public key
     * @return             Return verification result
     * */

    public static boolean verifySign(String param,String signature,String publicKey){
        try {
            //Get public key
            KeyFactory keyFactory = KeyFactory.getInstance(RSA);
            byte[] publicKeyByte = new Base64().decode(publicKey);
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKeyByte);
            PublicKey key= keyFactory.generatePublic(x509EncodedKeySpec);

            //Use the obtained public key to verify the unsigned parameter param in the input parameter and the signed parameter signature in the input parameter
            Signature sign=Signature.getInstance(SHA256WithRSA);
            sign.initVerify(key);
            sign.update(param.getBytes());

            //Convert hexadecimal code to character array
            byte[] hexByte = hexStrToBytes(signature);
            //Verify signature
            return sign.verify(hexByte);

        }  catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Convert byte array to hexadecimal string
     * @param bytes byte array
     * @return
     * Returns a hexadecimal string
     */
    private static String bytesToHexStr(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < bytes.length; ++i) {
            stringBuffer.append(Integer.toHexString(0x0100 + (bytes[i] & 0x00FF)).substring(1).toUpperCase());
        }
        return stringBuffer.toString();
    }

    /**
     *
     * Convert hexadecimal string to byte array
     * @param hexStr   Hexadecimal string
     * @return          Return byte array
     * */
    private static byte[] hexStrToBytes(String hexStr) {
        byte[] bytes = new byte[hexStr.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hexStr.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }

    /**
     * sort
     * @param rpcResult
     * @return
     */
    public static String jsonSort(RPCResult rpcResult) {
        TreeMap<String, Object> objectMap = JSON.parseObject(JSONObject.toJSONString(rpcResult), new TypeReference<TreeMap<String, Object>>() {});
        return JSONObject.toJSONString(objectMap);
    }
}
