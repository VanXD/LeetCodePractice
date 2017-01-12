package com.vanxd;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * RSA
 */
public class RsaEncrypt {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        RSAPrivateKey privateKey;
        RSAPublicKey publicKey;
        byte[] resultBytes;
        String text = "RSA学习";
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();

        publicKey = (RSAPublicKey)keyPair.getPublic();

        privateKey =(RSAPrivateKey) keyPair.getPrivate();

        byte[] srcBytes = text.getBytes();
        resultBytes = encrypt(publicKey, srcBytes);
        String result = new String(resultBytes);
        System.out.println("公钥加密:" + result);

        byte[] decBytes = decrypt(privateKey,resultBytes);
        String dec = new String(decBytes);
        System.out.println("私钥解密:" + dec);
    }


    protected static byte[] encrypt(RSAPublicKey publicKey, byte[] srcBytes) {
        if (publicKey != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.ENCRYPT_MODE, publicKey);
                byte[] resultBytes = cipher.doFinal(srcBytes);
                return resultBytes;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    protected static byte[] decrypt(RSAPrivateKey privateKey, byte[] encBytes) {
        if (privateKey != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.DECRYPT_MODE, privateKey);
                byte[] decBytes = cipher.doFinal(encBytes);
                return decBytes;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
