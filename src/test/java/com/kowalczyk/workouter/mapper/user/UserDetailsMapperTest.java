package com.kowalczyk.workouter.mapper.user;

import com.kowalczyk.workouter.mapper.AbstractMapperTest;
import com.kowalczyk.workouter.model.BO.user.UserDetails;
import com.kowalczyk.workouter.model.DTO.user.UserDetailsDTO;
import com.kowalczyk.workouter.services.security.RoleService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by JK on 2017-04-04.
 */
public class UserDetailsMapperTest extends AbstractMapperTest {

    @Autowired
    private UserDetailsMapper userDetailsMapper;
    @Autowired
    private RoleService roleService;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        Mockito.when(roleService.getObject(Mockito.anyLong())).thenReturn(getUserRoleTest());
    }

    @Test
    public void mapToBO() throws Exception {
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
        userDetailsDTO.setId(2L);
        userDetailsDTO.setRoles(Arrays.asList(1L).stream().collect(Collectors.toSet()));
        UserDetails userDetails = userDetailsMapper.mapToBO(userDetailsDTO);
        assertTrue(userDetails.getId() == 2L);
        assertTrue(userDetails.isEnabled());
        assertTrue(userDetails.isAccountNonExpired());
        assertTrue(userDetails.isAccountNonLocked());
        assertEquals(userDetailsDTO.isCredentialsNonExpired(), userDetails.isCredentialsNonExpired());
        assertEquals(userDetailsDTO.getFirstName(), userDetails.getFirstName());
        assertEquals(userDetailsDTO.getBirthDay(), userDetails.getBirthDay());
        assertEquals(userDetailsDTO.getLastName(), userDetails.getLastName());
        assertEquals(userDetailsDTO.getEmail(), userDetails.getEmail());
        assertEquals(userDetailsDTO.getLogin(), userDetails.getLogin());
        assertEquals(userDetailsDTO.getHashedPassword(), userDetails.getHashedPassword());
        Assert.assertEquals(getUserRoleTest().getId(), userDetails.getRoles().iterator().next().getId());
    }

    @Test
    public void mapToDTO() throws Exception {
        UserDetails userDetails = getUserDetailsTest();
        UserDetailsDTO userDetailsDTO = userDetailsMapper.mapToDTO(userDetails);
        assertEquals(userDetails.getFirstName(), userDetailsDTO.getFirstName());
        assertEquals(userDetails.getBirthDay(), userDetailsDTO.getBirthDay());
        assertEquals(userDetails.getLastName(), userDetailsDTO.getLastName());
        assertEquals(userDetails.getEmail(), userDetailsDTO.getEmail());
        assertEquals(userDetails.getLogin(), userDetailsDTO.getLogin());
        assertEquals(userDetails.getHashedPassword(), userDetailsDTO.getHashedPassword());
        assertTrue(userDetailsDTO.getRoles().iterator().next() == 1L);
        assertTrue(userDetailsDTO.isEnabled());
        assertTrue(userDetailsDTO.isAccountNonExpired());
        assertTrue(userDetailsDTO.isAccountNonLocked());
        assertEquals(userDetails.isCredentialsNonExpired(), userDetailsDTO.isCredentialsNonExpired());
    }

}