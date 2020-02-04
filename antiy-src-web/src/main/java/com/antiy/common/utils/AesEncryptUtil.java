package com.antiy.common.utils;

import com.antiy.exception.BusinessException;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/**
 * @program gitlab
 * @description AES加解密
 * @author wangqian created on 2019-03-12
 * @version 1.0.0
 */
public class AesEncryptUtil {

  private static final Logger logger =LoggerFactory.getLogger(AesEncryptUtil.class);

  private static final String KEY = "abcdefgabcdefg12";

  private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";

  /**
   * aes解密
   *
   * @param ciphertext 密文
   * @return java.lang.String
   * @author wangqian
   * @date 2019/3/12
   */
  public static String aesDecrypt(String ciphertext) throws Exception {
    try {
      String decrypt = aesDecrypt(ciphertext, KEY);
      return decrypt;
    } catch (Exception e) {
      logger.info("用户登录密码解密失败={}", ciphertext);
      throw new BusinessException("用户密码解密失败");
    }
  }

  public static String base64Encode(byte[] bytes) {
    return Base64.encodeBase64String(bytes);
  }

  public static byte[] base64Decode(String base64Code) throws Exception {
    return new BASE64Decoder().decodeBuffer(base64Code);
  }

  public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
    KeyGenerator kgen = KeyGenerator.getInstance("AES");
    kgen.init(128);
    Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
    cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));
    return cipher.doFinal(content.getBytes("utf-8"));
  }

  public static String aesEncrypt(String content, String encryptKey) throws Exception {
    return base64Encode(aesEncryptToBytes(content, encryptKey));
  }

  public static String aesEncrypt(String content) throws Exception {
     return base64Encode(aesEncryptToBytes(content, KEY));
  }

  public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
    KeyGenerator kgen = KeyGenerator.getInstance("AES");
    kgen.init(128);
    Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
    cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
    byte[] decryptBytes = cipher.doFinal(encryptBytes);
    return new String(decryptBytes);
  }

  public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
    return aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
  }
}
