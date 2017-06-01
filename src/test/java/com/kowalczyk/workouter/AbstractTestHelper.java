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
        userWeightDTO.setUserId(getUserDetailsDTOTest().getId());
        return userWeightDTO;
    }

    protected UserDetailsDTO getUserDetailsDTOTest() {
        UserDetailsDTO userDetailsDTO = buildUserDetailsDTOTest();
        userDetailsDTO.setId(1L);
        return userDetailsDTO;
    }

    protected UserDetailsDTO getUserDetailsDTOTest2() {
        UserDetailsDTO userDetailsDTO = buildUserDetailsDTOTest();
        userDetailsDTO.setEmail("mail");
        userDetailsDTO.setId(2L);
        return userDetailsDTO;
    }

    protected UserDetailsDTO buildUserDetailsDTOTest() {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setFirstName("name");
        userDetailsDTO.setLastName("last");
        userDetailsDTO.setBirthDay(new GregorianCalendar(2012, 3, 12).getTime());
        userDetailsDTO.setLogin("log");
        userDetailsDTO.setHashedPassword("pass");
        userDetailsDTO.setEmail("email");
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
