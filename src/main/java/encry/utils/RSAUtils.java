package encry.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname RSAUtils
 * @Date 2021/8/24 15:01
 * @Created by chenrujia
 * @Description
 */
public class RSAUtils {
   // Password length
   private static final int RSA_KEY_SIZE = 2048;
   // Algorithm name
   private static final String KEY_ALGORITHM = "RSA";
   // Encoding format
   private static final String CODE_UTF8 = "UTF-8";
   // Maximum encryption character length
   private static final Integer MAX_ENCRYPT_BLOCK = 245;
   // Maximum decrypted character length
   private static final Integer MAX_DECRYPT_BLOCK = 256;

   /**
    *
    * Randomly generate a key pair
    *
    * @throws NoSuchAlgorithmException
    */
   public static Map<String, String> genKeyPair(){
      // The KeyPairGenerator class is used to generate public and private key pairs, and objects are generated based on the RSA algorithm
      KeyPairGenerator keyPairGen = null;
      try {
         keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
      } catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
      }
      //
      // Initialize the key pair generator
      keyPairGen.initialize(RSA_KEY_SIZE, new SecureRandom());
      // Generate a key pair and save it in keyPair
      KeyPair keyPair = keyPairGen.generateKeyPair();
      // Get public and private keys
      RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
      RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
      // Get the public key
      String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
      // Get the private key string
      String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
      Map<String,String> keyMap = new HashMap<>();
      keyMap.put("publicKey",publicKeyString);
      keyMap.put("privateKey",privateKeyString);
      return keyMap;
   }

   /**
    * RSA public key encryption
    *
    * @param str
    * Encrypted string
    * @param publicKey
    * Public key
    * @return Ciphertext
    * @throws Exception Abnormal information during encryption
    */
   public static String encrypt(String str, String publicKey){
      try {
         // base64 encoded public key
         byte[] decoded = Base64.decodeBase64(publicKey);
         RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance(KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(decoded));
         // RSA encryption
         Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
         cipher.init(Cipher.ENCRYPT_MODE, pubKey);
         String outStr = Base64.encodeBase64String(doCrypt(str.getBytes(CODE_UTF8),cipher,MAX_ENCRYPT_BLOCK));
         return outStr;
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }

   /**
    * RSA private key decryption
    *
    * @param str        Encrypted string
    * @param privateKey
    * Private key
    * @return Inscription
    * @throws
    */
   public static String decrypt(String str, String privateKey){
      try {
         // 64-bit decoded encrypted string
         byte[] inputByte = Base64.decodeBase64(str.getBytes(CODE_UTF8));
         // base64 encoded private key
         byte[] decoded = Base64.decodeBase64(privateKey);
         RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(decoded));
         //RSA decryption
         Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
         cipher.init(Cipher.DECRYPT_MODE, priKey);
         String outStr = new String(doCrypt(inputByte,cipher,MAX_DECRYPT_BLOCK));
         return outStr;
      } catch (Exception e) {
         throw new RuntimeException();
      }
   }

   /**
    * Private key encryption
    *
    * @param data
    * Encrypted data
    * @param privateKey
    * Private key
    * @return
    */
   public static String encryptByPrivateKey(String data, String privateKey) {
      try {
         byte[] kb = Base64.decodeBase64(privateKey.getBytes(CODE_UTF8));
         PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(kb);
         KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
         PrivateKey key = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
         Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
         cipher.init(Cipher.ENCRYPT_MODE, key);
         byte[] b = data.getBytes(CODE_UTF8);
         byte[] encrypt = doCrypt(b,cipher,MAX_ENCRYPT_BLOCK);
         return Base64.encodeBase64String(encrypt);
      } catch (Exception e) {
         throw new RuntimeException();
      }
   }

   /**
    * Public key decryption
    *
    * @param data      Decrypt data
    * @param publicKey Public key
    * @return
    */
   public static String decryptByPublicKey(String data, String publicKey) {
      try {
         byte[] kb = Base64.decodeBase64(publicKey.getBytes(CODE_UTF8));
         X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(kb);
         KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
         PublicKey key = keyFactory.generatePublic(x509EncodedKeySpec);
         Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
         cipher.init(Cipher.DECRYPT_MODE, key);
         byte[] b = data.getBytes(CODE_UTF8);
         byte[] decrypt = doCrypt(Base64.decodeBase64(b),cipher,MAX_DECRYPT_BLOCK);
         return new String(decrypt, CODE_UTF8);
      } catch (Exception e) {
         throw new RuntimeException();
      }
   }

   /**
    * 分段加解密
    *
    * @param data     Segment encryption and decryption
    * @param cipher   Encryption and decryption objects
    * @param maxBlock Segment size
    * @return result
    */
   private static byte[] doCrypt(byte[] data, Cipher cipher, Integer maxBlock) {
      try {
         int inputLength = data.length;
         // Logo
         int offSet = 0;
         byte[] resultBytes = {};
         byte[] cache;
         while (inputLength - offSet > 0) {
            if (inputLength - offSet > maxBlock) {
               cache = cipher.doFinal(data, offSet, maxBlock);
               offSet += maxBlock;
            } else {
               cache = cipher.doFinal(data, offSet, inputLength - offSet);
               offSet = inputLength;
            }
            resultBytes = Arrays.copyOf(resultBytes, resultBytes.length + cache.length);
            System.arraycopy(cache, 0, resultBytes, resultBytes.length - cache.length, cache.length);
         }
         return resultBytes;
      } catch (Exception e) {
         throw new RuntimeException();
      }
   }
}
