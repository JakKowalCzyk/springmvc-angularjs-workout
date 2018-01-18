package com.kowalczyk.workouter.controllers.user;

import com.kowalczyk.workouter.controllers.AbstractControllerTest;
import com.kowalczyk.workouter.dao.security.token.ResetPasswordTokenDAO;
import com.kowalczyk.workouter.model.BO.security.token.ResetPasswordToken;
import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.model.DTO.security.RoleDTO;
import com.kowalczyk.workouter.model.DTO.user.UserDTO;
import com.kowalczyk.workouter.services.notification.email.password.ResetPasswordEmailService;
import com.kowalczyk.workouter.services.security.token.ResetPasswordService;
import com.kowalczyk.workouter.services.security.token.impl.ResetPasswordServiceImpl;
import com.kowalczyk.workouter.services.user.UserService;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Created by JK on 2018-01-18.
 */
public class ResetPasswordServiceTest extends AbstractControllerTest {

    @MockBean
    private ResetPasswordEmailService resetPasswordEmailService;
    @Autowired
    private UserController userController;
    @Autowired
    private UserService userService;
    @Autowired
    private ResetPasswordService resetPasswordService;
    @Autowired
    private ResetPasswordTokenDAO resetPasswordTokenDAO;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Mockito.doNothing().when(resetPasswordEmailService).sendResetPasswordEmail(Mockito.any(), Mockito.anyString());
    }


    @Test
    public void startResetPasswordProcess() throws Exception {
        RoleDTO roleDTO = roleController.findAll().stream().findFirst().get();
        UserDTO userDTO = userController.addObject(getUserDetailsDTOTest("login", "name", "last", roleDTO.getId()));
        User user = userService.getObject(userDTO.getId());
        new ResetPasswordServiceImpl(resetPasswordTokenDAO, resetPasswordEmailService).startTokenProcedure(user, "localhost");
        assertNotNull(resetPasswordService.findByUser(user));
        assertTrue(resetPasswordService.getAll().size() == 1);
        userController.deleteObject(user.getId());
        assertNull(resetPasswordService.findByUser(user));
        assertTrue(resetPasswordService.getAll().isEmpty());
    }

    @Test
    public void getNewToken() throws Exception {
        RoleDTO roleDTO = roleController.findAll().stream().findFirst().get();
        UserDTO userDTO = userController.addObject(getUserDetailsDTOTest("login", "name", "last", roleDTO.getId()));
        User user = userService.getObject(userDTO.getId());

        ResetPasswordToken resetPasswordToken = new ResetPasswordServiceImpl(resetPasswordTokenDAO, resetPasswordEmailService).getNewToken(user);

        assertEquals(user, resetPasswordToken.getUser());
        assertNotNull(resetPasswordToken.getToken());
        assertNotNull(resetPasswordToken.getId());
        assertTrue(resetPasswordService.isExist(resetPasswordToken.getId()));
        assertNotNull(resetPasswordToken.getExpiryDate());
        assertTrue(new GregorianCalendar().getTime().before(resetPasswordToken.getExpiryDate()));
        assertTrue(DateUtils.addHours(new GregorianCalendar().getTime(), 2).after(resetPasswordToken.getExpiryDate()));

        deleteToken(resetPasswordToken);
        userController.deleteObject(userDTO.getId());
    }

    private void deleteToken(ResetPasswordToken resetPasswordToken) {
        resetPasswordService.deleteObject(resetPasswordToken);
        assertFalse(resetPasswordService.isExist(resetPasswordToken.getId()));
    }


}



