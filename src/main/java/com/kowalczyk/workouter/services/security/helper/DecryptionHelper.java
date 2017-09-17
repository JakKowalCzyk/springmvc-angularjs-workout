package com.kowalczyk.workouter.services.security.helper;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.Certificate;

/**
 * Created by JK on 2017-09-17.
 */
public class DecryptionHelper {
    private static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";

    public String encryptWithPublicKey(String inputString, String publicKeystoreFilePath, String publicKeystorePassword,
                                       String alias) throws GeneralSecurityException, IOException {
        FileInputStream publicKeyFile = new FileInputStream(publicKeystoreFilePath);
        KeyStore publicKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        publicKeyStore.load(publicKeyFile, publicKeystorePassword.toCharArray());

        Certificate publicCertificate = publicKeyStore.getCertificate(alias);
        PublicKey publicKey = publicCertificate.getPublicKey();

        Cipher enrcyptCipher = Cipher.getInstance(CIPHER_ALGORITHM);
        enrcyptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        publicKeyFile.close();

        return new String(enrcyptCipher.doFinal(Base64.encodeBase64(inputString.getBytes())));
    }

    public String decryptWithPrivateKey(String inputString, String privateKeystoreFilePath, String privateKeystorePassword,
                                        String alias) throws GeneralSecurityException, IOException {
        FileInputStream privateKeyFile = new FileInputStream(privateKeystoreFilePath);
        KeyStore privateKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        privateKeyStore.load(privateKeyFile, privateKeystorePassword.toCharArray());

        Cipher decryptCipher = Cipher.getInstance(CIPHER_ALGORITHM);
        decryptCipher.init(Cipher.ENCRYPT_MODE, privateKeyStore.getKey(alias, privateKeystorePassword.toCharArray()));
        privateKeyFile.close();

        return new String(decryptCipher.doFinal(Base64.decodeBase64(inputString.getBytes())));
    }
}
