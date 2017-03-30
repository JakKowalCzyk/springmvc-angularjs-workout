package pl.workout.kowalczyk.com.app.mapper;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pl.workout.kowalczyk.com.app.model.BO.security.Role;
import pl.workout.kowalczyk.com.app.model.BO.security.UserDetails;
import pl.workout.kowalczyk.com.app.model.BO.security.UserRole;
import pl.workout.kowalczyk.com.app.services.exercise.ExerciseService;
import pl.workout.kowalczyk.com.app.services.exercise.UserExerciseService;
import pl.workout.kowalczyk.com.app.services.exercise.WorkoutService;
import pl.workout.kowalczyk.com.app.services.security.UserDetailsService;
import pl.workout.kowalczyk.com.app.services.user.UserWeightService;

import java.util.Arrays;
import java.util.HashSet;

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

    @Before
    public void setUp() throws Exception {
        Mockito.when(userDetailsService.getObject(Mockito.anyLong())).thenReturn(getUserDetailsTest());
    }

    protected UserDetails getUserDetailsTest() {
        UserDetails userDetails = new UserDetails("log", "123", true, new HashSet<>(Arrays.asList(getUserRoleTest())));
        userDetails.setId(1L);
        return userDetails;
    }

    protected UserRole getUserRoleTest() {
        UserRole userRole = new UserRole();
        userRole.setId(1L);
        Role role = new Role();
        role.setId(1L);
        role.setName("A");
        userRole.setRole(role);
        return userRole;
    }
}
