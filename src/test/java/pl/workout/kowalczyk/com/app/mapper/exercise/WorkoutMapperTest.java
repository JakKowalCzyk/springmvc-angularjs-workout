package pl.workout.kowalczyk.com.app.mapper.exercise;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.mapper.AbstractMapperTest;
import pl.workout.kowalczyk.com.app.model.BO.exercise.Workout;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.WorkoutDTO;
import pl.workout.kowalczyk.com.app.services.exercise.UserExerciseService;

import java.util.Arrays;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by JK on 2017-04-06.
 */
public class WorkoutMapperTest extends AbstractMapperTest {

    @Autowired
    private WorkoutMapper workoutMapper;
    @Autowired
    private UserExerciseService userExerciseService;

    @Override
    @Before
    public void setUp() throws Exception {
        Mockito.when(userExerciseService.getObject(Mockito.anyLong())).thenReturn(getUserExerciseTest());
        super.setUp();
    }

    @Test
    public void mapToBO() throws Exception {
        WorkoutDTO workoutDTO = new WorkoutDTO();
        workoutDTO.setUserExercises(Arrays.asList(1L, 2L));
        workoutDTO.setId(2L);
        workoutDTO.setUserId(4L);
        workoutDTO.setDate(new GregorianCalendar(2014, 12, 13).getTime());
        Workout workout = workoutMapper.mapToBO(workoutDTO);
        assertEquals(workoutDTO.getId(), workout.getId());
        assertEquals(workoutDTO.getDate(), workout.getDate());
        assertEquals(getUserDetailsTest().getId(), workout.getUser().getId());
        assertEquals(2, workout.getUserExercises().size());
        assertEquals(ExerciseType.BACK, workout.getUserExercises().get(0).getExercise().getExerciseType());
    }

    @Test
    public void mapToDTO() throws Exception {
        Workout workout = buildWorkoutTest();
        WorkoutDTO workoutDTO = workoutMapper.mapToDTO(workout);
        assertEquals(workout.getId(), workoutDTO.getId());
        assertEquals(workout.getDate(), workoutDTO.getDate());
        assertEquals(1, workoutDTO.getUserExercises().size());
        assertEquals(getUserExerciseTest().getId(), workoutDTO.getUserExercises().get(0));
        assertEquals(getUserDetailsTest().getId(), workoutDTO.getUserId());
    }

}