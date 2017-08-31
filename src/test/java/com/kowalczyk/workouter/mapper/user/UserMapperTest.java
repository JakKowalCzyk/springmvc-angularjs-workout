package com.kowalczyk.workouter.mapper.user;

import com.kowalczyk.workouter.mapper.AbstractMapperTest;
import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.model.BO.user.impl.UserNote;
import com.kowalczyk.workouter.model.DTO.user.UserDTO;
import com.kowalczyk.workouter.services.exercise.WorkoutService;
import com.kowalczyk.workouter.services.security.RoleService;
import com.kowalczyk.workouter.services.user.UserInfoService;
import com.kowalczyk.workouter.services.user.UserNotesService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by JK on 2017-04-04.
 */
public class UserMapperTest extends AbstractMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleService roleService;
    @Autowired
    private WorkoutService workoutService;
    @Autowired
    private UserNotesService userNotesService;
    @Autowired
    private UserInfoService userInfoService;
    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        Mockito.when(roleService.getObject(Mockito.anyLong())).thenReturn(getUserRoleTest());
        Mockito.when(workoutService.getWorkoutsByUserId(Mockito.anyLong())).thenReturn(Arrays.asList(getWorkoutTest(), getWorkoutTest()));
        UserNote userNote = getUserNotesTest();
        Mockito.when(userNotesService.getUserNotesByUserId(Mockito.anyLong())).thenReturn(Arrays.asList(userNote));
        Mockito.when(userInfoService.getUserInfoByUserId(Mockito.anyLong())).thenReturn(null);
    }

    private UserNote getUserNotesTest() {
        UserNote userNote = new UserNote();
        userNote.setId(1L);
        return userNote;
    }

    @Test
    public void mapToBO() throws Exception {
        UserDTO userDTO = getUserDetailsDTOTest("login", "name", "lastName", 1L, 10L);
        User user = userMapper.mapToBO(userDTO);
        assertEquals(user.getId(), userDTO.getId());
        assertTrue(user.isEnabled());
        assertTrue(user.isAccountNonExpired());
        assertTrue(user.isAccountNonLocked());
        assertEquals(userDTO.isCredentialsNonExpired(), user.isCredentialsNonExpired());
        assertEquals(userDTO.getFirstName(), user.getFirstName());
        assertEquals(userDTO.getBirthDay(), user.getBirthDay());
        assertEquals(userDTO.getLastName(), user.getLastName());
        assertEquals(userDTO.getEmail(), user.getEmail());
        assertEquals(userDTO.getLogin(), user.getLogin());
        assertEquals(userDTO.getHashedPassword(), user.getHashedPassword());
        Assert.assertEquals(getUserRoleTest().getId(), user.getRoles().iterator().next().getId());
        assertEquals(2, user.getWorkouts().size());
        assertEquals(getWorkoutTest().getId(), user.getWorkouts().get(0).getId());
        assertEquals(1, user.getUserNotes().size());
        assertTrue(user.getUserWeightList().isEmpty());
        assertTrue(user.getUserInfo() == null);
    }

    @Test
    public void mapToDTO() throws Exception {
        User user = getUserDetailsTest();
        user.setUserNotes(Arrays.asList(getUserNotesTest()));
        user.setWorkouts(Arrays.asList(getWorkoutTest(), getWorkoutTest()));
        user.setUserInfo(null);
        UserDTO userDTO = userMapper.mapToDTO(user);
        assertEquals(user.getFirstName(), userDTO.getFirstName());
        assertEquals(user.getBirthDay(), userDTO.getBirthDay());
        assertEquals(user.getLastName(), userDTO.getLastName());
        assertEquals(user.getEmail(), userDTO.getEmail());
        assertEquals(user.getLogin(), userDTO.getLogin());
        assertEquals(user.getHashedPassword(), userDTO.getHashedPassword());
        assertTrue(userDTO.getRoles().iterator().next() == 1L);
        assertTrue(userDTO.isEnabled());
        assertTrue(userDTO.isAccountNonExpired());
        assertTrue(userDTO.isAccountNonLocked());
        assertEquals(user.isCredentialsNonExpired(), userDTO.isCredentialsNonExpired());
    }

}