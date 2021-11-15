package encry.entity;

import lombok.Data;

/**
 * @Classname OpenEntity
 * @Date 2021/11/9 14:21
 * @Created by chenrujia
 * @Description
 */
@Data
public class OpenEntity {
   /**
    * Suppose the private key is generated as follows
    */
   private String privateKey = "";
   /**
    * After completing the api settings and saving the public key, the platform returns the key as follows
    */
   private String keyStr = "";
   /**
    * Operating environment domain name
    */
   private String URL = "";
}
