package pl.workout.kowalczyk.com.app.mapper.user;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import pl.workout.kowalczyk.com.app.mapper.AbstractMapperTest;
import pl.workout.kowalczyk.com.app.model.BO.user.UserDetails;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserDetailsDTO;
import pl.workout.kowalczyk.com.app.services.security.UserRoleService;

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
    private UserRoleService userRoleService;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        Mockito.when(userRoleService.getObject(Mockito.anyLong())).thenReturn(getUserRoleTest());
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
        userDetailsDTO.setId(2L);
        userDetailsDTO.setUserRoles(Arrays.asList(1L).stream().collect(Collectors.toSet()));
        UserDetails userDetails = userDetailsMapper.mapToBO(userDetailsDTO);
        assertTrue(userDetails.getId() == 2L);
        assertTrue(userDetails.getEnabled());
        assertEquals(userDetailsDTO.getFirstName(), userDetails.getFirstName());
        assertEquals(userDetailsDTO.getBirthDay(), userDetails.getBirthDay());
        assertEquals(userDetailsDTO.getLastName(), userDetails.getLastName());
        assertEquals(userDetailsDTO.getEmail(), userDetails.getEmail());
        assertEquals(userDetailsDTO.getLogin(), userDetails.getLogin());
        assertEquals(userDetailsDTO.getHashedPassword(), userDetails.getHashedPassword());
        assertEquals(getUserRoleTest().getRole().getId(), userDetails.getUserRoles().iterator().next().getRole().getId());
        assertEquals(getUserRoleTest().getId(), userDetails.getUserRoles().iterator().next().getId());
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
        assertTrue(userDetailsDTO.getUserRoles().iterator().next() == 1L);
    }

}