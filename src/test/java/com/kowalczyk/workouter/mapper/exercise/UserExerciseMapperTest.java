package com.kowalczyk.workouter.mapper.exercise;

import com.kowalczyk.workouter.enums.ExerciseType;
import com.kowalczyk.workouter.mapper.AbstractMapperTest;
import com.kowalczyk.workouter.model.BO.exercise.UserExercise;
import com.kowalczyk.workouter.model.DTO.exercise.UserExerciseDTO;
import com.kowalczyk.workouter.services.exercise.ExerciseService;
import com.kowalczyk.workouter.services.exercise.WorkoutService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by JK on 2017-04-06.
 */
public class UserExerciseMapperTest extends AbstractMapperTest {
    @Autowired
    private UserExerciseMapper userExerciseMapper;
    @Autowired
    private ExerciseService exerciseService;
    @Autowired
    private WorkoutService workoutService;

    @Override
    @Before
    public void setUp() throws Exception {
        Mockito.when(exerciseService.getObject(Mockito.anyLong())).thenReturn(getExerciseTest());
        Mockito.when(workoutService.getObject(Mockito.anyLong())).thenReturn(getWorkoutTest());
        super.setUp();
    }

    @Test
    public void mapToBO() throws Exception {
        UserExerciseDTO userExerciseDTO = new UserExerciseDTO();
        userExerciseDTO.setRepeat(12);
        userExerciseDTO.setSeries(13);
        userExerciseDTO.setWorkoutId(10L);
        userExerciseDTO.setId(5L);
        userExerciseDTO.setExerciseId(2L);
        UserExercise userExercise = userExerciseMapper.mapToBO(userExerciseDTO);
        assertEquals(userExerciseDTO.getId(), userExercise.getId());
        assertEquals(12, userExercise.getRepeat());
        assertTrue(userExerciseDTO.getSeries() == userExercise.getSeries());
        assertEquals(ExerciseType.BACK, userExercise.getExercise().getExerciseType());
        assertTrue(10L == userExercise.getWorkoutId().getId());
    }

    @Test
    public void mapToDTO() throws Exception {
        UserExercise userExercise = getUserExerciseTest();
        UserExerciseDTO userExerciseDTO = userExerciseMapper.mapToDTO(userExercise);
        assertEquals(userExercise.getId(), userExerciseDTO.getId());
        assertTrue(14 == userExerciseDTO.getSeries());
        assertTrue(userExercise.getRepeat() == userExerciseDTO.getRepeat());
        assertEquals(getWorkoutTest().getId(), userExerciseDTO.getWorkoutId());
        assertEquals(getExerciseTest().getId(), userExerciseDTO.getExerciseId());
    }

}