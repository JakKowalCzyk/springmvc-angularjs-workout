package com.kowalczyk.workouter;

import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.model.DTO.security.RoleDTO;
import com.kowalczyk.workouter.model.DTO.user.UserDetailsDTO;

import java.util.GregorianCalendar;

/**
 * Created by JK on 2017-04-08.
 */
public abstract class AbstractTestHelper {

    protected UserDetailsDTO getUserDetailsDTOTest(String login, String name, String lastName) {
        UserDetailsDTO userDetailsDTO = buildUserDetailsDTOTest();
        userDetailsDTO.setLogin(login);
        userDetailsDTO.setEmail(login);
        userDetailsDTO.setFirstName(name);
        userDetailsDTO.setLogin(lastName);
        return userDetailsDTO;
    }

    protected UserDetailsDTO getUserDetailsDTOTest(String login, String name, String lastName, Long roleId) {
        UserDetailsDTO userDetailsDTO = getUserDetailsDTOTest(login, name, lastName);
        userDetailsDTO.getRoles().add(roleId);
        return userDetailsDTO;
    }

    protected UserDetailsDTO getUserDetailsDTOTest(String login, String name, String lastName, Long roleId, Long userId) {
        UserDetailsDTO userDetailsDTO = getUserDetailsDTOTest(login, name, lastName);
        userDetailsDTO.setId(userId);
        userDetailsDTO.getRoles().add(roleId);
        return userDetailsDTO;
    }


    protected UserDetailsDTO buildUserDetailsDTOTest() {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setBirthDay(new GregorianCalendar(2012, 3, 12).getTime());
        userDetailsDTO.setHashedPassword("pass");
        userDetailsDTO.setEnabled(true);
        userDetailsDTO.setAccountNonLocked(true);
        userDetailsDTO.setAccountNonExpired(true);
        userDetailsDTO.setCredentialsNonExpired(true);
        return userDetailsDTO;
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
