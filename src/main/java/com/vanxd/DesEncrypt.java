package com.vanxd;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * DES
 */
public class DesEncrypt {

    public static void main(String[] args) throws Exception {
        byte[] encrypt = encrypt("DES加密学习".getBytes(), "DES加密学习DES加密学习DES加密学习DES加密学习DES加密学习DES加密学习DES加密学习DES加密学习");
        System.out.println(Arrays.toString(encrypt));
        System.out.println(new String((decrypt(encrypt, "DES加密学习DES加密学习DES加密学习DES加密学习DES加密学习DES加密学习DES加密学习DES加密学习")),
                "utf-8"));
    }


    public static byte[] encrypt(byte[] datasource, String salt) {
        try {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(salt.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            return cipher.doFinal(datasource);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] decrypt(byte[] src, String password) throws Exception {
        SecureRandom random = new SecureRandom();
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(desKey);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        return cipher.doFinal(src);
    }
}
