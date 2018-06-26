package com.github.maciejkrolpl.encrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncryptDecrypt {

    public String encrypt(String text) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        byte[] key = "qwertyuiop".getBytes();
        byte[] dataToSend = text.getBytes();


        Cipher c = Cipher.getInstance("AES");
        SecretKeySpec k =
                new SecretKeySpec(key, "AES");
        c.init(Cipher.ENCRYPT_MODE, k);
        byte[] encryptedData = c.doFinal(dataToSend);

        return new String(dataToSend);

    }

    public String decrypt(String text) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        byte[] key = "qwertyuiop".getBytes();
        byte[] encryptedData = text.getBytes();

                Cipher c = Cipher.getInstance("AES");
        SecretKeySpec k =
                new SecretKeySpec(key, "AES");
        c.init(Cipher.DECRYPT_MODE, k);
        byte[] data = c.doFinal(encryptedData);

        return new String(data);
    }

}
