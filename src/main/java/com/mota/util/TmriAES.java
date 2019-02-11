package com.mota.util;

import com.mota.constant.CldConstant;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class TmriAES {
    public static final String KEY_ALGORITHM = "AES";

    public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    private TmriAES() {
    }

    public static String initkey() throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        kg.init(256);
        SecretKey secretKey = kg.generateKey();
        return (new BASE64Encoder()).encodeBuffer(secretKey.getEncoded());
    }

    public static Key toKey(byte[] key) throws Exception {
        return new SecretKeySpec(key, KEY_ALGORITHM);
    }

    public static String encrypt(String data, String key) throws Exception {
        Key k = toKey(key.getBytes("GBK"));
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, k);
        return (new BASE64Encoder()).encodeBuffer(cipher.doFinal(data.getBytes("GBK"))).trim();
    }

    public static String decrypt(String data, String key) throws Exception {
        Key k = toKey(key.getBytes("GBK"));
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, k);
        return new String(cipher.doFinal((new BASE64Decoder()).decodeBuffer(data))).trim();
    }

    public static void main(String[] args) throws Exception{
//        String test = "Zzgg0S9ZR7qVfWbwu8LtcQ==";
//        System.out.println(TmriAES.decrypt(test, CldConstant.KEY));


//        System.out.println(TmriAES.encrypt("123456789",CldConstant.KEY));
        System.out.println(TmriAES.encrypt("1234567", CldConstant.KEY));
        System.out.println(TmriAES.decrypt("Pm6YQfIyGkho4APAwWpNMQ==",CldConstant.KEY));
    }

}
