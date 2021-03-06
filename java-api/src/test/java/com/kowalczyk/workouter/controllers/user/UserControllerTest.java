package com.kowalczyk.workouter.controllers.user;

import com.kowalczyk.workouter.controllers.AbstractControllerTest;
import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.model.BO.security.token.ResetPasswordToken;
import com.kowalczyk.workouter.model.BO.security.token.UserConfirmationToken;
import com.kowalczyk.workouter.model.DTO.security.ResetPasswordObject;
import com.kowalczyk.workouter.model.DTO.security.RoleDTO;
import com.kowalczyk.workouter.model.DTO.user.UserDTO;
import com.kowalczyk.workouter.model.DTO.user.impl.UserInfoDTO;
import com.kowalczyk.workouter.services.notification.email.account.AccountConfirmationEmailService;
import com.kowalczyk.workouter.services.notification.email.password.ResetPasswordEmailService;
import com.kowalczyk.workouter.services.security.token.ResetPasswordService;
import com.kowalczyk.workouter.services.security.token.UserConfirmationService;
import com.kowalczyk.workouter.services.user.UserService;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by JK on 2017-08-10.
 */
public class UserControllerTest extends AbstractControllerTest {

    private static final String PATH = "/api/user";

    @Autowired
    private UserController userController;
    @Autowired
    private UserConfirmationService userConfirmationService;
    @Autowired
    private UserService userService;
    @Autowired
    private ResetPasswordService resetPasswordService;
    @MockBean
    private AccountConfirmationEmailService accountConfirmationEmailService;
    @MockBean
    private ResetPasswordEmailService resetPasswordEmailService;

    private Long roleId;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        userController.findAll().forEach(userDetailsDTO -> userController.deleteObject(userDetailsDTO.getId()));
        roleId = roleController.findAll().stream().findAny().get().getId();
        Mockito.doNothing().when(accountConfirmationEmailService).sendEmailToUserWithConfirmationLink(Mockito.any(), Mockito.anyString());
    }

    @Test
    public void getObject() throws Exception {
        UserDTO userDTO1 = userController.addObject(getUserDetailsDTOTest("log1", "n1", "la1", roleId));
        UserDTO userDTO2 = userController.addObject(getUserDetailsDTOTest("log2", "n2", "la2", roleId));

        UserDTO expectedUserDTO1 = userController.getObject(userDTO1.getId());
        assertEquals(userDTO1.getFirstName(), expectedUserDTO1.getFirstName());
        assertEquals(userDTO1.getEmail(), expectedUserDTO1.getEmail());
        assertEquals(userDTO1.getLogin(), expectedUserDTO1.getLogin());

        UserDTO expectedUserDTO2 = userController.getObject(userDTO2.getId());
        assertEquals(userDTO2.getFirstName(), expectedUserDTO2.getFirstName());
        assertEquals(userDTO2.getEmail(), expectedUserDTO2.getEmail());
        assertEquals(userDTO2.getLogin(), expectedUserDTO2.getLogin());

        Long userInfoId = userInfoController.getByUserId(userDTO1.getId()).getId();
        userInfoController.deleteObject(userInfoId);
        userController.deleteObject(userDTO1.getId());
        assertFalse(userController.isExist(userDTO1.getId()));
        assertFalse(userInfoController.isExist(userInfoId));
        deleteUserDetails(userDTO2);
        assertTrue(userController.findAll().isEmpty());
    }

    private void deleteUserDetails(UserDTO userDTO1) {
        Long userInfoId = userInfoController.getByUserId(userDTO1.getId()).getId();
        userController.deleteObject(userDTO1.getId());
        assertFalse(userController.isExist(userDTO1.getId()));
        assertFalse(userInfoController.isExist(userInfoId));
    }

    @Test
    public void updateObject() throws Exception {
        UserDTO userDTO1 = userController.addObject(getUserDetailsDTOTest("log1", "n1", "la1", roleId));
        UserDTO userDTO2 = userController.addObject(getUserDetailsDTOTest("log2", "n2", "la2", roleId));

        userDTO1.setFirstName("new1");
        userDTO1.setLastName("new1");
        userDTO1.setEmail("new1");
        UserDTO updatedUserDTO1 = userController.updateObject(userDTO1);
        assertEquals(userDTO1.getId(), updatedUserDTO1.getId());
        assertEquals(userDTO1.getFirstName(), updatedUserDTO1.getFirstName());
        assertEquals(userDTO1.getLastName(), updatedUserDTO1.getLastName());
        assertEquals(userDTO1.getEmail(), updatedUserDTO1.getEmail());

        userDTO2.setLogin("login");
        UserDTO updatedUserDTO2 = userController.updateObject(userDTO2);
        assertEquals(userDTO2.getId(), updatedUserDTO2.getId());
        assertEquals(userDTO2.getLogin(), updatedUserDTO2.getLogin());


        RoleDTO roleDTO1 = roleController.addObject(buildRoleDTOTest(RoleType.ADMIN));
        RoleDTO roleDTO2 = roleController.addObject(buildRoleDTOTest(RoleType.TRAINER));
        userDTO1.getRoles().add(roleDTO1.getId());
        updatedUserDTO1 = userController.updateObject(userDTO1);
        assertTrue(updatedUserDTO1.getRoles().size() == 2);
        userDTO1.getRoles().add(roleDTO2.getId());
        updatedUserDTO1 = userController.updateObject(userDTO1);
        assertTrue(updatedUserDTO1.getRoles().size() == 3);
        userDTO1.getRoles().remove(roleDTO1.getId());
        userDTO1.getRoles().remove(roleDTO2.getId());
        updatedUserDTO1 = userController.updateObject(userDTO1);
        assertTrue(updatedUserDTO1.getRoles().size() == 1);
        userDTO1.getRoles().clear();
        updatedUserDTO1 = userController.updateObject(userDTO1);
        assertTrue(updatedUserDTO1.getRoles().isEmpty());

        userDTO2.getRoles().addAll(Arrays.asList(roleDTO1.getId(), roleDTO2.getId()));
        updatedUserDTO2 = userController.updateObject(userDTO2);
        assertTrue(updatedUserDTO2.getRoles().size() == 3);
        userDTO2.getRoles().clear();
        updatedUserDTO2 = userController.updateObject(userDTO2);
        assertTrue(updatedUserDTO2.getRoles().isEmpty());

        deleteUserDetails(userDTO1);
        deleteUserDetails(userDTO2);
    }

    @Test
    public void addObject() throws Exception {
        UserDTO userDTO1 = userController.addObject(getUserDetailsDTOTest("log1", "n1", "la1", roleId));
        UserDTO userDTO2 = userController.addObject(getUserDetailsDTOTest("log2", "n2", "la2", roleId));

        assertEquals(userDTO1.getId(), userInfoController.getByUserId(userDTO1.getId()).getUserId());
        assertEquals(userDTO2.getId(), userInfoController.getByUserId(userDTO2.getId()).getUserId());

        deleteUserDetails(userDTO1);
        deleteUserDetails(userDTO2);

        UserDTO userDTO3 = (getUserDetailsDTOTest("log3", "n1", "la1", roleId));
        userDTO3.setEmail("notValid");
        userDTO3.setBirthDay(null);

        String message = mvc.perform(post(PATH)
                .contentType(MediaType.APPLICATION_JSON).content(getContentJson(userDTO3)))
                .andExpect(status().isUnprocessableEntity()).andReturn().getResponse().getContentAsString();

        userDTO3.setEmail("email@email.com");
        mvc.perform(post(PATH)
                .contentType(MediaType.APPLICATION_JSON).content(getContentJson(userDTO3)))
                .andExpect(status().isOk());
    }

    @Test
    public void findAll() throws Exception {
        List<UserDTO> userDTOList = userController.findAll();
        assertTrue(userDTOList.isEmpty());

        UserDTO userDTO1 = userController.addObject(getUserDetailsDTOTest("log1", "n1", "la1", roleId));

        userDTOList = userController.findAll();
        assertEquals(1, userDTOList.size());
        List<UserInfoDTO> userInfoDTOList = userInfoController.findAll();
        assertEquals(1, userInfoDTOList.size());

        UserDTO userDTO2 = userController.addObject(getUserDetailsDTOTest("log2", "n2", "la2", roleId));
        UserDTO userDTO3 = userController.addObject(getUserDetailsDTOTest("log3", "n3", "la3", roleId));
        userDTOList = userController.findAll();
        assertEquals(3, userDTOList.size());

        deleteUserDetails(userDTO3);
        userDTOList = userController.findAll();
        assertEquals(2, userDTOList.size());
        userInfoDTOList = userInfoController.findAll();
        assertEquals(2, userInfoDTOList.size());

        deleteUserDetails(userDTO1);
        deleteUserDetails(userDTO2);
        userDTOList = userController.findAll();
        userInfoDTOList = userInfoController.findAll();
        assertTrue(userDTOList.isEmpty());
        assertTrue(userInfoDTOList.isEmpty());
    }

    @Test
    public void getPrincipal() throws Exception {
        //TODO
    }

    @Test
    public void getByLogin() throws Exception {
        UserDTO userDTO1 = userController.addObject(getUserDetailsDTOTest("log1", "n1", "la1", roleId));
        UserDTO userDTO2 = userController.addObject(getUserDetailsDTOTest("log2", "n2", "la2", roleId));
        UserDTO userDTO3 = userController.addObject(getUserDetailsDTOTest("log3", "n3", "la3", roleId));

        UserDTO expectedUserDTO1 = userController.getByLogin(userDTO1.getLogin());
        assertEquals(userDTO1.getId(), expectedUserDTO1.getId());
        assertEquals(userDTO1.getLogin(), expectedUserDTO1.getLogin());

        UserDTO expectedUserDTO2 = userController.getByLogin(userDTO2.getLogin());
        assertEquals(userDTO2.getId(), expectedUserDTO2.getId());
        assertEquals(userDTO2.getLogin(), expectedUserDTO2.getLogin());

        deleteUserDetails(userDTO1);
        deleteUserDetails(userDTO2);
        deleteUserDetails(userDTO3);
    }

    @Test
    public void testDelete() throws Exception {
        UserDTO userDTO1 = userController.addObject(getUserDetailsDTOTest("log1", "n1", "la1", roleId));
        userController.startConfirmationProcedure("new", userDTO1.getId());
        UserConfirmationToken userConfirmationToken = userConfirmationService.findByUser(userService.getObject(userDTO1.getId()));
        assertTrue(userConfirmationService.isExist(userConfirmationToken.getId()));
        deleteUserDetails(userDTO1);
        assertFalse(userConfirmationService.isExist(userConfirmationToken.getId()));
    }

    @Test
    public void testConfirmAccount() throws Exception {
        UserDTO userDTO1 = userController.addObject(getUserDetailsDTOTest("log1", "n1", "la1", roleId));
        userController.startConfirmationProcedure("new", userDTO1.getId());
        UserConfirmationToken userConfirmationToken = userConfirmationService.findByUser(userService.getObject(userDTO1.getId()));

        assertTrue(userController.confirmAccount(userConfirmationToken.getToken()).getBody());
        assertTrue(userController.getObject(userDTO1.getId()).isAccountNonExpired());
        assertTrue(userController.getObject(userDTO1.getId()).isAccountNonLocked());
        assertTrue(userController.getObject(userDTO1.getId()).isCredentialsNonExpired());
        assertTrue(userController.getObject(userDTO1.getId()).isEnabled());
        assertFalse(userConfirmationService.isExist(userConfirmationToken.getId()));

        UserDTO userDTO2 = userController.addObject(getUserDetailsDTOTest("log2", "n1", "la1", roleId));
        userController.startConfirmationProcedure("new2", userDTO2.getId());
        UserConfirmationToken userConfirmationToken2 = userConfirmationService.findByUser(userService.getObject(userDTO2.getId()));

        assertTrue(userController.confirmAccount(userConfirmationToken2.getToken()).getBody());
        assertTrue(userController.isExist(userDTO2.getId()));
        assertFalse(userConfirmationService.isExist(userConfirmationToken2.getId()));

        deleteUserDetails(userDTO1);
    }

    @Test
    public void testConfirmAccount2() throws Exception {
        UserDTO userDTO1 = userController.addObject(getUserDetailsDTOTest("log2", "n1", "la1", roleId));
        userController.startConfirmationProcedure("new1", userDTO1.getId());
        UserConfirmationToken userConfirmationToken = userConfirmationService.findByUser(userService.getObject(userDTO1.getId()));

        assertFalse(userController.confirmAccount("randomToken").getBody());
        assertTrue(userController.isExist(userDTO1.getId()));
        assertTrue(userConfirmationService.isExist(userConfirmationToken.getId()));
        assertFalse(userController.getObject(userDTO1.getId()).isAccountNonExpired());
        assertFalse(userController.getObject(userDTO1.getId()).isAccountNonLocked());
        assertFalse(userController.getObject(userDTO1.getId()).isCredentialsNonExpired());
        assertFalse(userController.getObject(userDTO1.getId()).isEnabled());

        deleteUserDetails(userDTO1);
    }

    @Test
    public void testResetPassword() throws Exception {
        UserDTO userDTO1 = userController.addObject(getUserDetailsDTOTest("log1", "n1", "la1", roleId));
        userController.startResetPasswordProcedure("new", userDTO1.getId());

        ResetPasswordToken resetPasswordToken = resetPasswordService.findByUser(userService.getObject(userDTO1.getId()));

        ResetPasswordObject resetPasswordObject = new ResetPasswordObject();
        resetPasswordObject.setNewPassword("newPass");
        resetPasswordObject.setToken(resetPasswordToken.getToken());

        assertTrue(userController.resetPassword(resetPasswordObject).getBody());
        assertNotEquals(userDTO1.getHashedPassword(), userController.getObject(userDTO1.getId()).getHashedPassword());
        assertFalse(resetPasswordService.isExist(resetPasswordToken.getId()));

        UserDTO userDTO2 = userController.addObject(getUserDetailsDTOTest("log2", "n1", "la1", roleId));
        userController.startResetPasswordProcedure("new2", userDTO2.getId());
        ResetPasswordToken resetPasswordToken2 = resetPasswordService.findByUser(userService.getObject(userDTO2.getId()));
        ResetPasswordObject resetPasswordObject2 = new ResetPasswordObject();
        resetPasswordObject2.setNewPassword("newPass");
        resetPasswordObject2.setToken(resetPasswordToken2.getToken());

        assertTrue(userController.resetPassword(resetPasswordObject2).getBody());
        assertNotEquals(userDTO2.getHashedPassword(), userController.getObject(userDTO2.getId()).getHashedPassword());
        assertFalse(resetPasswordService.isExist(resetPasswordToken2.getId()));
        deleteUserDetails(userDTO2);

        ResetPasswordObject noTokenObject = new ResetPasswordObject();
        resetPasswordObject.setToken("asdasd");
        resetPasswordObject.setNewPassword("123");
        assertFalse(userController.resetPassword(noTokenObject).getBody());

        userController.startResetPasswordProcedure("new3", userDTO1.getId());
        ResetPasswordToken resetPasswordToken3 = resetPasswordService.findByUser(userService.getObject(userDTO1.getId()));

        ResetPasswordObject wrongToken = new ResetPasswordObject();
        wrongToken.setToken("wrong");
        wrongToken.setNewPassword("123");
        assertFalse(userController.resetPassword(noTokenObject).getBody());
        assertTrue(resetPasswordService.isExist(resetPasswordToken3.getId()));

        resetPasswordToken3.setExpiryDate(DateUtils.addHours(new GregorianCalendar().getTime(), -1));
        resetPasswordService.updateObject(resetPasswordToken3);

        ResetPasswordObject expiredToken = new ResetPasswordObject();
        expiredToken.setToken(resetPasswordToken3.getToken());
        expiredToken.setNewPassword("123");
        assertFalse(userController.resetPassword(expiredToken).getBody());
        assertFalse(resetPasswordService.isExist(resetPasswordToken3.getId()));
    }


}