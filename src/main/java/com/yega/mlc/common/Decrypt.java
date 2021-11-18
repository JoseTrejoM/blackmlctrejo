package com.yega.mlc.common;

import com.yega.mlc.constants.SecurityConstants;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;


public class Decrypt {

    private static final String SECRET_KEY = SecurityConstants.SECRET_KEY;

    public static String decrypt(String strToDecrypt) {
        try {

            String encodedBase64Key = encodeKey(SECRET_KEY);
            Key key = generateKey(encodedBase64Key);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
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
