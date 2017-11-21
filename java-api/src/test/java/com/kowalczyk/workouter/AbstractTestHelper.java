package com.kowalczyk.workouter;

import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.model.DTO.security.RoleDTO;
import com.kowalczyk.workouter.model.DTO.user.UserDTO;

import java.util.GregorianCalendar;

/**
 * Created by JK on 2017-04-08.
 */
public abstract class AbstractTestHelper {

    protected UserDTO getUserDetailsDTOTest(String login, String name, String lastName) {
        UserDTO userDTO = buildUserDetailsDTOTest();
        userDTO.setLogin(login);
        userDTO.setEmail(login);
        userDTO.setFirstName(name);
        userDTO.setLogin(lastName);
        return userDTO;
    }

    protected UserDTO getUserDetailsDTOTest(String login, String name, String lastName, Long roleId) {
        UserDTO userDTO = getUserDetailsDTOTest(login, name, lastName);
        userDTO.getRoles().add(roleId);
        return userDTO;
    }

    protected UserDTO getUserDetailsDTOTest(String login, String name, String lastName, Long roleId, Long userId) {
        UserDTO userDTO = getUserDetailsDTOTest(login, name, lastName);
        userDTO.setId(userId);
        userDTO.getRoles().add(roleId);
        return userDTO;
    }


    protected UserDTO buildUserDetailsDTOTest() {
        UserDTO userDTO = new UserDTO();
        userDTO.setBirthDay(new GregorianCalendar(2012, 3, 12).getTime());
        userDTO.setHashedPassword("pass");
        userDTO.setEnabled(true);
        userDTO.setAccountNonLocked(true);
        userDTO.setAccountNonExpired(true);
        userDTO.setCredentialsNonExpired(true);
        return userDTO;
    }

    protected RoleDTO getRoleDTOTest(RoleType roleType) {
        RoleDTO roleDTO = buildRoleDTOTest(roleType);
        roleDTO.setId(1L);
        return roleDTO;
    }

    protected RoleDTO buildRoleDTOTest(RoleType roleType) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleType(roleType);
        return roleDTO;
    }
}
