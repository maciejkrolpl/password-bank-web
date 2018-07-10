package com.github.maciejkrolpl.encrypt;

import org.jasypt.util.text.BasicTextEncryptor;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncryptDecrypt {



    public static String encrypt(String plainText, String key) {
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPasswordCharArray(key.toCharArray());
        return encryptor.encrypt(plainText);
    }

    public static String decrypt(String plainText, String key) {
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPasswordCharArray(key.toCharArray());
        return encryptor.decrypt(plainText);
    }

}
