package com.kowalczyk.workouter.mapper.exercise;

import com.kowalczyk.workouter.enums.ExerciseType;
import com.kowalczyk.workouter.mapper.AbstractMapperTest;
import com.kowalczyk.workouter.model.BO.exercise.WorkoutExercise;
import com.kowalczyk.workouter.model.DTO.exercise.WorkoutExerciseDTO;
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
public class WorkoutExerciseMapperTest extends AbstractMapperTest {
    @Autowired
    private WorkoutExerciseMapper workoutExerciseMapper;
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
        WorkoutExerciseDTO workoutExerciseDTO = new WorkoutExerciseDTO();
        workoutExerciseDTO.setRepeat(12);
        workoutExerciseDTO.setSeries(13);
        workoutExerciseDTO.setWorkoutId(10L);
        workoutExerciseDTO.setId(5L);
        workoutExerciseDTO.setExerciseId(2L);
        WorkoutExercise workoutExercise = workoutExerciseMapper.mapToBO(workoutExerciseDTO);
        assertEquals(workoutExerciseDTO.getId(), workoutExercise.getId());
        assertEquals(12, workoutExercise.getRepeat());
        assertTrue(workoutExerciseDTO.getSeries() == workoutExercise.getSeries());
        assertEquals(ExerciseType.BACK, workoutExercise.getExercise().getExerciseType());
        assertTrue(10L == workoutExercise.getWorkout().getId());
    }

    @Test
    public void mapToDTO() throws Exception {
        WorkoutExercise workoutExercise = getUserExerciseTest();
        WorkoutExerciseDTO workoutExerciseDTO = workoutExerciseMapper.mapToDTO(workoutExercise);
        assertEquals(workoutExercise.getId(), workoutExerciseDTO.getId());
        assertTrue(14 == workoutExerciseDTO.getSeries());
        assertTrue(workoutExercise.getRepeat() == workoutExerciseDTO.getRepeat());
        assertEquals(getWorkoutTest().getId(), workoutExerciseDTO.getWorkoutId());
        assertEquals(getExerciseTest().getId(), workoutExerciseDTO.getExerciseId());
    }

}