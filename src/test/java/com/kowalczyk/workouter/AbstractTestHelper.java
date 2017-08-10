package com.kowalczyk.workouter;

import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.model.DTO.security.RoleDTO;
import com.kowalczyk.workouter.model.DTO.user.UserDetailsDTO;
import com.kowalczyk.workouter.model.DTO.user.impl.UserWeightDTO;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.stream.Collectors;

/**
 * Created by JK on 2017-04-08.
 */
public abstract class AbstractTestHelper {

    protected UserWeightDTO buildUserWeightDTOTest() {
        UserWeightDTO userWeightDTO = new UserWeightDTO();
        userWeightDTO.setDate(new GregorianCalendar(2012, 12, 2).getTime());
        userWeightDTO.setWeightKg(56);
        userWeightDTO.setUserId(getUserDetailsDTOTest("login1", "name1", "lastN1").getId());
        return userWeightDTO;
    }


    protected UserDetailsDTO getUserDetailsDTOTest(String login, String name, String lastName) {
        UserDetailsDTO userDetailsDTO = buildUserDetailsDTOTest();
        userDetailsDTO.setLogin(login);
        userDetailsDTO.setEmail(login);
        userDetailsDTO.setFirstName(name);
        userDetailsDTO.setLogin(lastName);
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
        userDetailsDTO.setRoles(Arrays.asList(1L).stream().collect(Collectors.toSet()));
        return userDetailsDTO;
    }

    protected RoleDTO getRoleDTOTest() {
        RoleDTO roleDTO = buildRoleDTOTest();
        roleDTO.setId(1L);
        return roleDTO;
    }

    protected RoleDTO buildRoleDTOTest() {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleType(RoleType.ADMIN);
        return roleDTO;
    }
}
