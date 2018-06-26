package com.github.maciejkrolpl.encrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncryptDecrypt {

    private static byte[] key = "4da5ea60fd8f7ee69f60fc30504064e0".getBytes();

    public static byte[] encrypt(String text) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        byte[] dataToSend = text.getBytes();


        Cipher c = Cipher.getInstance("AES");
        SecretKeySpec k =
                new SecretKeySpec(key, "AES");
        c.init(Cipher.ENCRYPT_MODE, k);
        byte[] encryptedData = c.doFinal(dataToSend);

        return encryptedData;

    }

    public static String decrypt(byte[] encryptedData) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {


                Cipher c = Cipher.getInstance("AES");
        SecretKeySpec k =
                new SecretKeySpec(key, "AES");
        c.init(Cipher.DECRYPT_MODE, k);
        byte[] data = c.doFinal(encryptedData);

        return new String(data);
    }

}
