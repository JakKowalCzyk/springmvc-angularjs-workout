package com.kowalczyk.workouter.controllers.user;

import com.kowalczyk.workouter.controllers.AbstractControllerTest;
import com.kowalczyk.workouter.dao.security.token.UserConfirmationTokenDAO;
import com.kowalczyk.workouter.model.BO.security.token.UserConfirmationToken;
import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.model.DTO.security.RoleDTO;
import com.kowalczyk.workouter.model.DTO.user.UserDTO;
import com.kowalczyk.workouter.services.notification.email.account.AccountConfirmationEmailService;
import com.kowalczyk.workouter.services.security.token.UserConfirmationService;
import com.kowalczyk.workouter.services.security.token.impl.UserConfirmationServiceImpl;
import com.kowalczyk.workouter.services.user.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

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
        new UserConfirmationServiceImpl(userConfirmationTokenDAO, accountConfirmationEmailService).startTokenProcedure(user, "localhost");
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
                new UserConfirmationServiceImpl(userConfirmationTokenDAO, accountConfirmationEmailService).getNewToken(user);
        assertEquals(user, userConfirmationToken.getUser());
        assertNotNull(userConfirmationToken.getToken());
        assertNotNull(userConfirmationToken.getId());
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
        UserConfirmationServiceImpl userConfirmationServiceImpl = new UserConfirmationServiceImpl(userConfirmationTokenDAO, accountConfirmationEmailService);
        UserConfirmationToken userConfirmationToken = userConfirmationServiceImpl.getNewToken(user);
        String urlToPrepare = "http://localhost&token=";
        String uri = userConfirmationServiceImpl.prepareUri(userConfirmationToken, urlToPrepare);
        assertTrue(uri.contains(urlToPrepare));
        assertTrue(uri.contains(String.format("token=%s", userConfirmationToken.getToken())));
        userController.deleteObject(user.getId());
        assertFalse(userConfirmationService.isExist(userConfirmationToken.getId()));
    }


}