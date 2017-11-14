package com.invoke.util;

import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import org.apache.commons.codec.binary.Base64;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author summer
 */
public class SignUtil {
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";
    public static final String CHARSET = "utf-8";
    private static final transient TLogger dbLogger = LoggerUtils.getLogger(SignUtil.class);

    private static boolean checkRsaSign(String content, String sign, String pubKey, String encoding) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.decodeBase64(pubKey);
            PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);
            signature.initVerify(publicKey);
            signature.update(content.getBytes(encoding));
            return signature.verify(Base64.decodeBase64(sign));
        } catch (Exception e) {
            dbLogger.warn("校验签名出错", e);
        }
        return false;
    }


    private static String rsaSign(String content, String privateKey, String encoding) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = privateKey.getBytes(encoding);
            encodedKey = Base64.decodeBase64(encodedKey);
            PrivateKey priKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
            signature.initSign(priKey);
            signature.update(content.getBytes(encoding));
            byte[] signed = signature.sign();
            return new String(Base64.encodeBase64(signed));
        } catch (Exception e) {
            dbLogger.error("", e);
            return "";
        }
    }
}
