package com.kowalczyk.workouter.mapper;

import com.kowalczyk.workouter.AbstractTestHelper;
import com.kowalczyk.workouter.enums.ExerciseType;
import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.model.BO.exercise.Exercise;
import com.kowalczyk.workouter.model.BO.exercise.Workout;
import com.kowalczyk.workouter.model.BO.exercise.WorkoutExercise;
import com.kowalczyk.workouter.model.BO.security.Role;
import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.model.BO.user.impl.UserWeight;
import com.kowalczyk.workouter.services.exercise.ExerciseService;
import com.kowalczyk.workouter.services.exercise.WorkoutExerciseService;
import com.kowalczyk.workouter.services.exercise.WorkoutService;
import com.kowalczyk.workouter.services.security.RoleService;
import com.kowalczyk.workouter.services.user.UserInfoService;
import com.kowalczyk.workouter.services.user.UserNotesService;
import com.kowalczyk.workouter.services.user.UserService;
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
public abstract class AbstractMapperTest extends AbstractTestHelper {

    @MockBean
    protected UserService userService;
    @MockBean
    private WorkoutExerciseService workoutExerciseService;
    @MockBean
    private WorkoutService workoutService;
    @MockBean
    private ExerciseService exerciseService;
    @MockBean
    private UserWeightService userWeightService;
    @MockBean
    private RoleService roleService;
    @MockBean
    private UserInfoService userInfoService;
    @MockBean
    private UserNotesService userNotesService;

    @Before
    public void setUp() throws Exception {
        Mockito.when(userService.getObject(Mockito.anyLong())).thenReturn(getUserDetailsTest());
    }

    protected User getUserDetailsTest() {
        User user = new User();
        user.setLogin("log");
        user.setHashedPassword("123");
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setFirstName("name");
        user.setLastName("lastname");
        user.setBirthDay(new GregorianCalendar(2012, 2, 14).getTime());
        user.setEmail("email");
        user.setId(1L);
        user.setRoles(Arrays.asList(getUserRoleTest()).stream().collect(Collectors.toSet()));
        return user;
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
        workout.setWorkoutExercises(Arrays.asList(getUserExerciseTest()));
        return workout;
    }

    protected Exercise getExerciseTest() {
        Exercise exercise = new Exercise("name", "desc", ExerciseType.BACK);
        exercise.setId(2L);
        return exercise;
    }

    protected WorkoutExercise getUserExerciseTest() {
        WorkoutExercise workoutExercise = new WorkoutExercise();
        workoutExercise.setId(2L);
        workoutExercise.setSeries(14);
        workoutExercise.setRepeat(9);
        workoutExercise.setWorkout(getWorkoutTest());
        workoutExercise.setExercise(getExerciseTest());
        return workoutExercise;
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
