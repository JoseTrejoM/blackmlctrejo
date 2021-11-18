package com.yega.mlc.common;

import com.yega.mlc.constants.SecurityConstants;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class Encrypt {

    private static final String SECRET_KEY = SecurityConstants.SECRET_KEY;


    public static String encrypt(String data) throws Exception {

        String encodedBase64Key = encodeKey(SECRET_KEY);

        Key key = generateKey(encodedBase64Key);
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());
        String encryptedValue = Base64.getEncoder().encodeToString(encVal);
        return encryptedValue;
    }

    private static Key generateKey(String secret) throws Exception {
        byte[] decoded = Base64.getDecoder().decode(secret.getBytes());
        Key key = new SecretKeySpec(decoded, "AES");
        return key;
    }

    public static String encodeKey(String str) {
        byte[] encoded = Base64.getEncoder().encode(str.getBytes());
        return new String(encoded);
    }


}
