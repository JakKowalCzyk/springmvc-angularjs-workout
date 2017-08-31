package com.kowalczyk.workouter.controllers.user;

import com.kowalczyk.workouter.controllers.AbstractControllerTest;
import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.model.DTO.security.RoleDTO;
import com.kowalczyk.workouter.model.DTO.user.UserDetailsDTO;
import com.kowalczyk.workouter.model.DTO.user.impl.UserInfoDTO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by JK on 2017-08-10.
 */
public class UserDetailsControllerTest extends AbstractControllerTest {

    private static final String PATH = "/api/user/details";
    @Autowired
    private UserDetailsController userDetailsController;
    private Long roleId;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        userDetailsController.findAll().forEach(userDetailsDTO -> userDetailsController.deleteObject(userDetailsDTO.getId()));
        roleId = roleController.findAll().stream().findAny().get().getId();
    }

    @Test
    public void getObject() throws Exception {
        UserDetailsDTO userDetailsDTO1 = userDetailsController.addObject(getUserDetailsDTOTest("log1", "n1", "la1", roleId));
        UserDetailsDTO userDetailsDTO2 = userDetailsController.addObject(getUserDetailsDTOTest("log2", "n2", "la2", roleId));

        UserDetailsDTO expectedUserDetailsDTO1 = userDetailsController.getObject(userDetailsDTO1.getId());
        assertEquals(userDetailsDTO1.getFirstName(), expectedUserDetailsDTO1.getFirstName());
        assertEquals(userDetailsDTO1.getEmail(), expectedUserDetailsDTO1.getEmail());
        assertEquals(userDetailsDTO1.getLogin(), expectedUserDetailsDTO1.getLogin());

        UserDetailsDTO expectedUserDetailsDTO2 = userDetailsController.getObject(userDetailsDTO2.getId());
        assertEquals(userDetailsDTO2.getFirstName(), expectedUserDetailsDTO2.getFirstName());
        assertEquals(userDetailsDTO2.getEmail(), expectedUserDetailsDTO2.getEmail());
        assertEquals(userDetailsDTO2.getLogin(), expectedUserDetailsDTO2.getLogin());

        Long userInfoId = userInfoController.getByUserId(userDetailsDTO1.getId()).getId();
        userInfoController.deleteObject(userInfoId);
        userDetailsController.deleteObject(userDetailsDTO1.getId());
        assertFalse(userDetailsController.isExist(userDetailsDTO1.getId()));
        assertFalse(userInfoController.isExist(userInfoId));
        deleteUserDetails(userDetailsDTO2);
        assertTrue(userDetailsController.findAll().isEmpty());
    }

    private void deleteUserDetails(UserDetailsDTO userDetailsDTO1) {
        Long userInfoId = userInfoController.getByUserId(userDetailsDTO1.getId()).getId();
        userDetailsController.deleteObject(userDetailsDTO1.getId());
        assertFalse(userDetailsController.isExist(userDetailsDTO1.getId()));
        assertFalse(userInfoController.isExist(userInfoId));
    }

    @Test
    public void updateObject() throws Exception {
        UserDetailsDTO userDetailsDTO1 = userDetailsController.addObject(getUserDetailsDTOTest("log1", "n1", "la1", roleId));
        UserDetailsDTO userDetailsDTO2 = userDetailsController.addObject(getUserDetailsDTOTest("log2", "n2", "la2", roleId));

        userDetailsDTO1.setFirstName("new1");
        userDetailsDTO1.setLastName("new1");
        userDetailsDTO1.setEmail("new1");
        UserDetailsDTO updatedUserDetailsDTO1 = userDetailsController.updateObject(userDetailsDTO1);
        assertEquals(userDetailsDTO1.getId(), updatedUserDetailsDTO1.getId());
        assertEquals(userDetailsDTO1.getFirstName(), updatedUserDetailsDTO1.getFirstName());
        assertEquals(userDetailsDTO1.getLastName(), updatedUserDetailsDTO1.getLastName());
        assertEquals(userDetailsDTO1.getEmail(), updatedUserDetailsDTO1.getEmail());

        userDetailsDTO2.setLogin("login");
        UserDetailsDTO updatedUserDetailsDTO2 = userDetailsController.updateObject(userDetailsDTO2);
        assertEquals(userDetailsDTO2.getId(), updatedUserDetailsDTO2.getId());
        assertEquals(userDetailsDTO2.getLogin(), updatedUserDetailsDTO2.getLogin());


        RoleDTO roleDTO1 = roleController.addObject(buildRoleDTOTest(RoleType.ADMIN));
        RoleDTO roleDTO2 = roleController.addObject(buildRoleDTOTest(RoleType.TRAINER));
        userDetailsDTO1.getRoles().add(roleDTO1.getId());
        updatedUserDetailsDTO1 = userDetailsController.updateObject(userDetailsDTO1);
        assertTrue(updatedUserDetailsDTO1.getRoles().size() == 2);
        userDetailsDTO1.getRoles().add(roleDTO2.getId());
        updatedUserDetailsDTO1 = userDetailsController.updateObject(userDetailsDTO1);
        assertTrue(updatedUserDetailsDTO1.getRoles().size() == 3);
        userDetailsDTO1.getRoles().remove(roleDTO1.getId());
        userDetailsDTO1.getRoles().remove(roleDTO2.getId());
        updatedUserDetailsDTO1 = userDetailsController.updateObject(userDetailsDTO1);
        assertTrue(updatedUserDetailsDTO1.getRoles().size() == 1);
        userDetailsDTO1.getRoles().clear();
        updatedUserDetailsDTO1 = userDetailsController.updateObject(userDetailsDTO1);
        assertTrue(updatedUserDetailsDTO1.getRoles().isEmpty());

        userDetailsDTO2.getRoles().addAll(Arrays.asList(roleDTO1.getId(), roleDTO2.getId()));
        updatedUserDetailsDTO2 = userDetailsController.updateObject(userDetailsDTO2);
        assertTrue(updatedUserDetailsDTO2.getRoles().size() == 3);
        userDetailsDTO2.getRoles().clear();
        updatedUserDetailsDTO2 = userDetailsController.updateObject(userDetailsDTO2);
        assertTrue(updatedUserDetailsDTO2.getRoles().isEmpty());

        deleteUserDetails(userDetailsDTO1);
        deleteUserDetails(userDetailsDTO2);
    }

    @Test
    public void addObject() throws Exception {
        UserDetailsDTO userDetailsDTO1 = userDetailsController.addObject(getUserDetailsDTOTest("log1", "n1", "la1", roleId));
        UserDetailsDTO userDetailsDTO2 = userDetailsController.addObject(getUserDetailsDTOTest("log2", "n2", "la2", roleId));

        assertEquals(userDetailsDTO1.getId(), userInfoController.getByUserId(userDetailsDTO1.getId()).getUserId());
        assertEquals(userDetailsDTO2.getId(), userInfoController.getByUserId(userDetailsDTO2.getId()).getUserId());

        deleteUserDetails(userDetailsDTO1);
        deleteUserDetails(userDetailsDTO2);

        UserDetailsDTO userDetailsDTO3 = (getUserDetailsDTOTest("log3", "n1", "la1", roleId));
        userDetailsDTO3.setEmail("notValid");
        userDetailsDTO3.setBirthDay(null);

        String message = mvc.perform(post(PATH)
                .contentType(MediaType.APPLICATION_JSON).content(getContentJson(userDetailsDTO3)))
                .andExpect(status().isUnprocessableEntity()).andReturn().getResponse().getContentAsString();

        userDetailsDTO3.setEmail("email@email.com");
        mvc.perform(post(PATH)
                .contentType(MediaType.APPLICATION_JSON).content(getContentJson(userDetailsDTO3)))
                .andExpect(status().isOk());
    }

    @Test
    public void findAll() throws Exception {
        List<UserDetailsDTO> userDetailsDTOList = userDetailsController.findAll();
        assertTrue(userDetailsDTOList.isEmpty());

        UserDetailsDTO userDetailsDTO1 = userDetailsController.addObject(getUserDetailsDTOTest("log1", "n1", "la1", roleId));

        userDetailsDTOList = userDetailsController.findAll();
        assertEquals(1, userDetailsDTOList.size());
        List<UserInfoDTO> userInfoDTOList = userInfoController.findAll();
        assertEquals(1, userInfoDTOList.size());

        UserDetailsDTO userDetailsDTO2 = userDetailsController.addObject(getUserDetailsDTOTest("log2", "n2", "la2", roleId));
        UserDetailsDTO userDetailsDTO3 = userDetailsController.addObject(getUserDetailsDTOTest("log3", "n3", "la3", roleId));
        userDetailsDTOList = userDetailsController.findAll();
        assertEquals(3, userDetailsDTOList.size());

        deleteUserDetails(userDetailsDTO3);
        userDetailsDTOList = userDetailsController.findAll();
        assertEquals(2, userDetailsDTOList.size());
        userInfoDTOList = userInfoController.findAll();
        assertEquals(2, userInfoDTOList.size());

        deleteUserDetails(userDetailsDTO1);
        deleteUserDetails(userDetailsDTO2);
        userDetailsDTOList = userDetailsController.findAll();
        userInfoDTOList = userInfoController.findAll();
        assertTrue(userDetailsDTOList.isEmpty());
        assertTrue(userInfoDTOList.isEmpty());
    }

    @Test
    public void getPrincipal() throws Exception {
        //TODO
    }

    @Test
    public void getByLogin() throws Exception {
        UserDetailsDTO userDetailsDTO1 = userDetailsController.addObject(getUserDetailsDTOTest("log1", "n1", "la1", roleId));
        UserDetailsDTO userDetailsDTO2 = userDetailsController.addObject(getUserDetailsDTOTest("log2", "n2", "la2", roleId));
        UserDetailsDTO userDetailsDTO3 = userDetailsController.addObject(getUserDetailsDTOTest("log3", "n3", "la3", roleId));

        UserDetailsDTO expectedUserDetailsDTO1 = userDetailsController.getByLogin(userDetailsDTO1.getLogin());
        assertEquals(userDetailsDTO1.getId(), expectedUserDetailsDTO1.getId());
        assertEquals(userDetailsDTO1.getLogin(), expectedUserDetailsDTO1.getLogin());

        UserDetailsDTO expectedUserDetailsDTO2 = userDetailsController.getByLogin(userDetailsDTO2.getLogin());
        assertEquals(userDetailsDTO2.getId(), expectedUserDetailsDTO2.getId());
        assertEquals(userDetailsDTO2.getLogin(), expectedUserDetailsDTO2.getLogin());

        deleteUserDetails(userDetailsDTO1);
        deleteUserDetails(userDetailsDTO2);
        deleteUserDetails(userDetailsDTO3);
    }

}