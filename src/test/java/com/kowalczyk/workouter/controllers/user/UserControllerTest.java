package com.kowalczyk.workouter.controllers.user;

import com.kowalczyk.workouter.controllers.AbstractControllerTest;
import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.model.DTO.security.RoleDTO;
import com.kowalczyk.workouter.model.DTO.user.UserDTO;
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
public class UserControllerTest extends AbstractControllerTest {

    private static final String PATH = "/api/user";
    @Autowired
    private UserController userController;
    private Long roleId;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        userController.findAll().forEach(userDetailsDTO -> userController.deleteObject(userDetailsDTO.getId()));
        roleId = roleController.findAll().stream().findAny().get().getId();
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

        String message = mockMvc.perform(post(PATH)
                .contentType(MediaType.APPLICATION_JSON).content(getContentJson(userDTO3)))
                .andExpect(status().isUnprocessableEntity()).andReturn().getResponse().getContentAsString();

        userDTO3.setEmail("email@email.com");
        mockMvc.perform(post(PATH)
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

}