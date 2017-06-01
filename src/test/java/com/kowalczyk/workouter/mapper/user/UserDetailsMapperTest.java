package com.kowalczyk.workouter.mapper.user;

import com.kowalczyk.workouter.mapper.AbstractMapperTest;
import com.kowalczyk.workouter.model.BO.user.UserDetails;
import com.kowalczyk.workouter.model.BO.user.impl.UserNotes;
import com.kowalczyk.workouter.model.DTO.user.UserDetailsDTO;
import com.kowalczyk.workouter.services.exercise.WorkoutService;
import com.kowalczyk.workouter.services.security.RoleService;
import com.kowalczyk.workouter.services.user.UserNotesService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;

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
    @Autowired
    private WorkoutService workoutService;
    @Autowired
    private UserNotesService userNotesService;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        Mockito.when(roleService.getObject(Mockito.anyLong())).thenReturn(getUserRoleTest());
        Mockito.when(workoutService.getObject(Mockito.anyLong())).thenReturn(getWorkoutTest());
        UserNotes userNotes = getUserNotesTest();
        Mockito.when(userNotesService.getObject(Mockito.anyLong())).thenReturn(userNotes);
    }

    private UserNotes getUserNotesTest() {
        UserNotes userNotes = new UserNotes();
        userNotes.setId(1L);
        return userNotes;
    }

    @Test
    public void mapToBO() throws Exception {
        UserDetailsDTO userDetailsDTO = getUserDetailsDTOTest();
        userDetailsDTO.setWorkouts(Arrays.asList(1L, 2L));
        userDetailsDTO.setUserNotes(Arrays.asList(1L));
        userDetailsDTO.setUserInfoList(new ArrayList<>());
        UserDetails userDetails = userDetailsMapper.mapToBO(userDetailsDTO);
        assertEquals(userDetails.getId(), userDetailsDTO.getId());
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
        assertEquals(2, userDetails.getWorkouts().size());
        assertEquals(getWorkoutTest().getId(), userDetails.getWorkouts().get(0).getId());
        assertEquals(1, userDetails.getUserNotes().size());
        assertTrue(userDetails.getUserWeightList().isEmpty());
        assertTrue(userDetails.getUserInfoList().isEmpty());
    }

    @Test
    public void mapToDTO() throws Exception {
        UserDetails userDetails = getUserDetailsTest();
        userDetails.setUserNotes(Arrays.asList(getUserNotesTest()));
        userDetails.setWorkouts(Arrays.asList(getWorkoutTest(), getWorkoutTest()));
        userDetails.setUserInfoList(new ArrayList<>());
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
        assertEquals(1, userDetailsDTO.getUserNotes().size());
        assertEquals(getUserNotesTest().getId(), userDetailsDTO.getUserNotes().get(0));
        assertEquals(2, userDetailsDTO.getWorkouts().size());
        assertTrue(userDetailsDTO.getUserInfoList().isEmpty());
        assertTrue(userDetailsDTO.getUserWeightList().isEmpty());
    }

}