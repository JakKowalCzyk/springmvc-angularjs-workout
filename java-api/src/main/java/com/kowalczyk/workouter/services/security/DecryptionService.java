package com.kowalczyk.workouter.services.security;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by JK on 2017-09-18.
 */
@Service
public class DecryptionService {

    private static final String ALGORITHM = "RSA";
    private PublicKey publicKey;
    private PrivateKey privateKey;

    @PostConstruct
    public void initKeys() throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeySpecException {
        KeyPair generateKeyPair = generateKeyPair();
        publicKey = KeyFactory.getInstance(ALGORITHM).generatePublic(new X509EncodedKeySpec(generateKeyPair.getPublic().getEncoded()));
        privateKey = KeyFactory.getInstance(ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(generateKeyPair.getPrivate().getEncoded()));
    }

    public byte[] encrypt(PublicKey publicKey, byte[] inputData) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.PUBLIC_KEY, publicKey);
        return Base64.encodeBase64(cipher.doFinal(inputData));
    }

    public String decrypt(PrivateKey privateKey, byte[] inputData) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.PRIVATE_KEY, privateKey);
        return new String(cipher.doFinal(Base64.decodeBase64(inputData)));
    }

    public KeyPair generateKeyPair() throws NoSuchAlgorithmException, NoSuchProviderException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
        // 512 is keysize
        keyGen.initialize(512, random);
        return keyGen.generateKeyPair();
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

}
