package com.kowalczyk.workouter.controllers.user;

import com.kowalczyk.workouter.controllers.AbstractControllerTest;
import com.kowalczyk.workouter.dao.security.UserConfirmationTokenDAO;
import com.kowalczyk.workouter.model.BO.security.UserConfirmationToken;
import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.model.DTO.security.RoleDTO;
import com.kowalczyk.workouter.model.DTO.user.UserDTO;
import com.kowalczyk.workouter.model.exception.ConfirmationAccountException;
import com.kowalczyk.workouter.services.notification.email.account.AccountConfirmationEmailService;
import com.kowalczyk.workouter.services.security.DecryptionService;
import com.kowalczyk.workouter.services.security.UserConfirmationService;
import com.kowalczyk.workouter.services.security.impl.UserConfirmationServiceImpl;
import com.kowalczyk.workouter.services.user.UserService;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Created by JK on 2017-09-18.
 */
public class UserConfirmationServiceImplTest extends AbstractControllerTest {

    @Autowired
    private UserController userController;
    @Autowired
    private UserService userService;
    @Autowired
    private UserConfirmationService userConfirmationService;
    @MockBean
    private AccountConfirmationEmailService accountConfirmationEmailService;
    @Autowired
    private UserConfirmationTokenDAO userConfirmationTokenDAO;
    @Autowired
    private DecryptionService decryptionService;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        Mockito.doNothing().when(accountConfirmationEmailService).sendEmailToUserWithConfirmationLink(Mockito.any(), Mockito.anyString());
    }

    @Test
    public void startConfirmationProcess() throws Exception {
        RoleDTO roleDTO = roleController.findAll().stream().findFirst().get();
        UserDTO userDTO = userController.addObject(getUserDetailsDTOTest("login", "name", "last", roleDTO.getId()));
        User user = userService.getObject(userDTO.getId());
        new UserConfirmationServiceImpl(userConfirmationTokenDAO, accountConfirmationEmailService, decryptionService).startConfirmationProcess(user, "localhost");
        assertNotNull(userConfirmationService.findByUser(user));
        assertTrue(userConfirmationService.getAll().size() == 1);
        userController.deleteObject(user.getId());
        assertNull(userConfirmationService.findByUser(user));
        assertTrue(userConfirmationService.getAll().isEmpty());
    }

    @Test
    public void getUserConfirmationToken() throws Exception {
        RoleDTO roleDTO = roleController.findAll().stream().findFirst().get();
        UserDTO userDTO = userController.addObject(getUserDetailsDTOTest("login", "name", "last", roleDTO.getId()));
        User user = userService.getObject(userDTO.getId());
        UserConfirmationToken userConfirmationToken =
                new UserConfirmationServiceImpl(userConfirmationTokenDAO, accountConfirmationEmailService, decryptionService).getUserConfirmationToken(user);
        assertEquals(user, userConfirmationToken.getUser());
        assertNotNull(userConfirmationToken.getToken());
        assertNotNull(userConfirmationToken.getId());
        assertTrue(userConfirmationToken.getExpiryDate().before(DateUtils.addDays(new GregorianCalendar().getTime(), 2)));
        assertTrue(userConfirmationToken.getExpiryDate().after(new GregorianCalendar().getTime()));
        assertTrue(userConfirmationService.isExist(userConfirmationToken.getId()));
        deleteToken(userConfirmationToken);
        userController.deleteObject(userDTO.getId());
    }

    private void deleteToken(UserConfirmationToken userConfirmationToken) {
        userConfirmationService.deleteObject(userConfirmationToken);
        assertFalse(userConfirmationService.isExist(userConfirmationToken.getId()));
    }


    @Test
    public void prepareUri() throws Exception {
        RoleDTO roleDTO = roleController.findAll().stream().findFirst().get();
        UserDTO userDTO = userController.addObject(getUserDetailsDTOTest("login", "name", "last", roleDTO.getId()));
        User user = userService.getObject(userDTO.getId());
        UserConfirmationServiceImpl userConfirmationServiceImpl = new UserConfirmationServiceImpl(userConfirmationTokenDAO, accountConfirmationEmailService, decryptionService);
        UserConfirmationToken userConfirmationToken = userConfirmationServiceImpl.getUserConfirmationToken(user);
        String urlToPrepare = "http://localhost";
        String uri = userConfirmationServiceImpl.prepareUri(userConfirmationToken, urlToPrepare);
        assertTrue(uri.contains(urlToPrepare));
        assertTrue(uri.contains(userConfirmationToken.getUser().getId().toString()));
        assertFalse(uri.contains(userConfirmationToken.getToken()));
        userController.deleteObject(user.getId());
        assertFalse(userConfirmationService.isExist(userConfirmationToken.getId()));
    }

    @Test
    public void encryptToken() throws Exception {
        RoleDTO roleDTO = roleController.findAll().stream().findFirst().get();
        UserDTO userDTO = userController.addObject(getUserDetailsDTOTest("login", "name", "last", roleDTO.getId()));
        User user = userService.getObject(userDTO.getId());
        UserConfirmationServiceImpl userConfirmationServiceImpl = new UserConfirmationServiceImpl(userConfirmationTokenDAO, accountConfirmationEmailService, decryptionService);
        UserConfirmationToken userConfirmationToken = userConfirmationServiceImpl.getUserConfirmationToken(user);
        String encryptedToken = userConfirmationServiceImpl.encryptToken(userConfirmationToken);
        assertNotEquals(userConfirmationToken.getToken(), encryptedToken);
        assertEquals(userConfirmationToken.getToken(), String.valueOf(decryptionService.decrypt(decryptionService.getPrivateKey(), encryptedToken.getBytes())));
        userController.deleteObject(user.getId());
        assertFalse(userConfirmationService.isExist(userConfirmationToken.getId()));
    }

    @Test
    public void isConfirmationAllowed() throws Exception {
        RoleDTO roleDTO = roleController.findAll().stream().findFirst().get();
        UserDTO userDTO = userController.addObject(getUserDetailsDTOTest("login", "name", "last", roleDTO.getId()));
        User user = userService.getObject(userDTO.getId());
        UserConfirmationServiceImpl userConfirmationServiceImpl = new UserConfirmationServiceImpl(userConfirmationTokenDAO, accountConfirmationEmailService, decryptionService);
        UserConfirmationToken userConfirmationToken = userConfirmationServiceImpl.getUserConfirmationToken(user);

        assertTrue(userConfirmationService.isConfirmationAllowed(user, userConfirmationToken.getToken()));
        assertFalse(userConfirmationService.isExist(userConfirmationToken.getId()));

        UserConfirmationToken userConfirmationToken2 = userConfirmationServiceImpl.getUserConfirmationToken(user);
        userConfirmationToken2.setExpiryDate(new GregorianCalendar(1900, 2, 1).getTime());
        userConfirmationToken2 = userConfirmationService.updateObject(userConfirmationToken2);

        assertFalse(userConfirmationService.isConfirmationAllowed(user, userConfirmationToken2.getToken()));
        assertFalse(userConfirmationService.isExist(userConfirmationToken2.getId()));

        userController.deleteObject(user.getId());
    }

    @Test(expected = ConfirmationAccountException.class)
    public void isConfirmationAllowed2() throws Exception {
        RoleDTO roleDTO = roleController.findAll().stream().findFirst().get();
        UserDTO userDTO = userController.addObject(getUserDetailsDTOTest("login", "name", "last", roleDTO.getId()));
        User user = userService.getObject(userDTO.getId());
        UserConfirmationServiceImpl userConfirmationServiceImpl = new UserConfirmationServiceImpl(userConfirmationTokenDAO, accountConfirmationEmailService, decryptionService);
        UserConfirmationToken userConfirmationToken = userConfirmationServiceImpl.getUserConfirmationToken(user);

        assertFalse(userConfirmationService.isConfirmationAllowed(user, "randomToken"));

        userController.deleteObject(user.getId());
    }

    @Test(expected = ConfirmationAccountException.class)
    public void isConfirmationAllowed3() throws Exception {
        RoleDTO roleDTO = roleController.findAll().stream().findFirst().get();
        UserDTO userDTO = userController.addObject(getUserDetailsDTOTest("login", "name", "last", roleDTO.getId()));
        UserDTO userDTO2 = userController.addObject(getUserDetailsDTOTest("login2", "name", "last", roleDTO.getId()));
        User user = userService.getObject(userDTO.getId());
        User user2 = userService.getObject(userDTO2.getId());
        UserConfirmationServiceImpl userConfirmationServiceImpl = new UserConfirmationServiceImpl(userConfirmationTokenDAO, accountConfirmationEmailService, decryptionService);
        UserConfirmationToken userConfirmationToken = userConfirmationServiceImpl.getUserConfirmationToken(user);

        assertFalse(userConfirmationService.isConfirmationAllowed(user2, "randomToken"));

        userController.deleteObject(user.getId());
        userController.deleteObject(user2.getId());
    }

}