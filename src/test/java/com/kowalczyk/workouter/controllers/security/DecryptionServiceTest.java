package com.kowalczyk.workouter.controllers.security;

import com.kowalczyk.workouter.controllers.AbstractControllerTest;
import com.kowalczyk.workouter.services.security.DecryptionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Created by JK on 2017-09-19.
 */
public class DecryptionServiceTest extends AbstractControllerTest {

    @Autowired
    private DecryptionService decryptionService;

    @Test
    public void testEncryption() throws Exception {
        String test = "test";
        String encrypted = new String(decryptionService.encrypt(decryptionService.getPublicKey(), test.getBytes()));
        String decrypted = decryptionService.decrypt(decryptionService.getPrivateKey(), encrypted.getBytes());
        assertEquals(test, decrypted);
    }

}