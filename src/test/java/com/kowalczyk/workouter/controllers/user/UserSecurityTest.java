package com.kowalczyk.workouter.controllers.user;

import com.kowalczyk.workouter.controllers.AbstractControllerTest;
import com.kowalczyk.workouter.model.DTO.user.UserDTO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by JKowalczyk on 2017-09-01.
 */
public class UserSecurityTest extends AbstractControllerTest {

    private static final String USER_PATH = "/api/user";
    private static final String LOGOUT_PATH = "/api/user/logout";

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testLogoutUser() throws Exception {
        String password = "newPassword1";
        Long roleId = roleController.findAll().stream().findAny().get().getId();
        UserDTO userDTO1 = (getUserDetailsDTOTest("log1", "n1", "la1", roleId));
        userDTO1.setHashedPassword(password);
        userDTO1 = userController.addObject(userDTO1);

        String token = getAccessToken(userDTO1.getLogin(), password);

        mockMvcSecured.perform(put(USER_PATH)
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getContentJson(userDTO1))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvcSecured.perform(put(LOGOUT_PATH)
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getContentJson(userDTO1))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvcSecured.perform(put(USER_PATH)
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getContentJson(userDTO1))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());

        mockMvcSecured.perform(put(USER_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getContentJson(userDTO1))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }
}
