package encry;

import encry.utils.RSAUtils;
import java.util.Map;

/**
 * @Classname demo
 * @Date 2021/8/27 10:19
 * @Created by chenrujia
 * @Description Generate public and private key pair demo
 */
public class GenerateDemo {
    public static void main(String[] args) {
        // 1.Generate a public-private key pair, just generate it once
        Map<String,String> keyMap = RSAUtils.genKeyPair();
        // Obtain the private key, which is used to encrypt information
        String privateKey = keyMap.get("privateKey");
        System.out.println("The randomly generated private key is:" + privateKey);
        // Obtain the public key for platform binding
        String publicKey = keyMap.get("publicKey");
        System.out.println("The randomly generated public key is:" + publicKey);
    }
}
