package com.kowalczyk.workouter.mapper;

import com.kowalczyk.workouter.enums.ExerciseType;
import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.model.BO.exercise.Exercise;
import com.kowalczyk.workouter.model.BO.exercise.UserExercise;
import com.kowalczyk.workouter.model.BO.exercise.Workout;
import com.kowalczyk.workouter.model.BO.security.Role;
import com.kowalczyk.workouter.model.BO.user.UserDetails;
import com.kowalczyk.workouter.model.BO.user.impl.UserWeight;
import com.kowalczyk.workouter.services.exercise.ExerciseService;
import com.kowalczyk.workouter.services.exercise.UserExerciseService;
import com.kowalczyk.workouter.services.exercise.WorkoutService;
import com.kowalczyk.workouter.services.security.RoleService;
import com.kowalczyk.workouter.services.user.UserDetailsService;
import com.kowalczyk.workouter.services.user.UserWeightService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.stream.Collectors;

/**
 * Created by JK on 2017-03-22.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MapperConfigurationTest.class)
public abstract class AbstractMapperTest {

    @MockBean
    protected UserDetailsService userDetailsService;
    @MockBean
    private UserExerciseService userExerciseService;
    @MockBean
    private WorkoutService workoutService;
    @MockBean
    private ExerciseService exerciseService;
    @MockBean
    private UserWeightService userWeightService;
    @MockBean
    private RoleService roleService;


    @Before
    public void setUp() throws Exception {
        Mockito.when(userDetailsService.getObject(Mockito.anyLong())).thenReturn(getUserDetailsTest());
    }

    protected UserDetails getUserDetailsTest() {
        UserDetails userDetails = new UserDetails();
        userDetails.setLogin("log");
        userDetails.setHashedPassword("123");
        userDetails.setEnabled(true);
        userDetails.setAccountNonExpired(true);
        userDetails.setAccountNonLocked(true);
        userDetails.setCredentialsNonExpired(true);
        userDetails.setEnabled(true);
        userDetails.setFirstName("name");
        userDetails.setLastName("lastname");
        userDetails.setBirthDay(new GregorianCalendar(2012, 2, 14).getTime());
        userDetails.setEmail("email");
        userDetails.setId(1L);
        userDetails.setRoles(Arrays.asList(getUserRoleTest()).stream().collect(Collectors.toSet()));
        return userDetails;
    }

    protected Role getUserRoleTest() {
        Role role = new Role();
        role.setId(1L);
        role.setRoleType(RoleType.USER);
        return role;
    }

    protected Workout getWorkoutTest() {
        Workout workout = new Workout(new GregorianCalendar(2010, 1, 4).getTime());
        workout.setDate(new GregorianCalendar().getTime());
        workout.setUser(getUserDetailsTest());
        workout.setUser(getUserDetailsTest());
        workout.setId(10L);
        return workout;
    }

    protected Workout buildWorkoutTest() {
        Workout workout = getWorkoutTest();
        workout.setUserExercises(Arrays.asList(getUserExerciseTest()));
        return workout;
    }

    protected Exercise getExerciseTest() {
        Exercise exercise = new Exercise("name", "desc", ExerciseType.BACK);
        exercise.setId(2L);
        return exercise;
    }

    protected UserExercise getUserExerciseTest() {
        UserExercise userExercise = new UserExercise();
        userExercise.setId(2L);
        userExercise.setSeries(14);
        userExercise.setRepeat(9);
        userExercise.setWorkoutId(getWorkoutTest());
        userExercise.setExercise(getExerciseTest());
        return userExercise;
    }

    protected UserWeight getUserWeightTest() {
        UserWeight userWeight = new UserWeight();
        userWeight.setId(4L);
        userWeight.setUser(getUserDetailsTest());
        userWeight.setDate(null);
        userWeight.setWeightKg(32);
        return userWeight;
    }
}
