package com.kowalczyk.workouter.controllers.exercise;

import com.kowalczyk.workouter.controllers.AbstractControllerTest;
import com.kowalczyk.workouter.enums.ExerciseType;
import com.kowalczyk.workouter.model.DTO.exercise.ExerciseDTO;
import com.kowalczyk.workouter.model.DTO.exercise.WorkoutDTO;
import com.kowalczyk.workouter.model.DTO.exercise.WorkoutExerciseDTO;
import com.kowalczyk.workouter.services.exercise.WorkoutExerciseService;
import com.kowalczyk.workouter.services.exercise.WorkoutService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Created by JK on 2017-08-17.
 */
public class WorkoutExerciseControllerTest extends AbstractControllerTest {

    @Autowired
    private WorkoutExerciseController workoutExerciseController;
    @Autowired
    private WorkoutController workoutController;
    @Autowired
    private ExerciseController exerciseController;
    @Autowired
    private WorkoutService workoutService;
    @Autowired
    private WorkoutExerciseService workoutExerciseService;

    @Test
    public void getObject() throws Exception {
        WorkoutDTO workoutDTO = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2012, 9, 12).getTime(), userDetailsId1));
        ExerciseDTO exerciseDTO1 = exerciseController.addObject(createExerciseDTOTest("ex1", "dex1", ExerciseType.ARMS));
        ExerciseDTO exerciseDTO2 = exerciseController.addObject(createExerciseDTOTest("ex2", "dex2", ExerciseType.BACK));
        ExerciseDTO exerciseDTO3 = exerciseController.addObject(createExerciseDTOTest("ex3", "dex3", ExerciseType.HANDS));
        ExerciseDTO exerciseDTO4 = exerciseController.addObject(createExerciseDTOTest("ex4", "dex4", ExerciseType.LEGS));

        WorkoutExerciseDTO workoutExerciseDTO1 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO, exerciseDTO1, 10, 3));
        WorkoutExerciseDTO workoutExerciseDTO2 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO, exerciseDTO2, 9, 3));
        WorkoutExerciseDTO workoutExerciseDTO3 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO, exerciseDTO3, 6, 2));
        WorkoutExerciseDTO workoutExerciseDTO4 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO, exerciseDTO4, 12, 2));

        WorkoutExerciseDTO expectedWorkoutExerciseDTO1 = workoutExerciseController.getObject(workoutExerciseDTO1.getId());
        assertEquals(workoutExerciseDTO1.getId(), expectedWorkoutExerciseDTO1.getId());
        assertEquals(workoutExerciseDTO1.getExerciseId(), expectedWorkoutExerciseDTO1.getExerciseId());
        assertEquals(workoutExerciseDTO1.getWorkoutId(), expectedWorkoutExerciseDTO1.getWorkoutId());
        assertEquals(workoutExerciseDTO1.getRepeat(), expectedWorkoutExerciseDTO1.getRepeat());
        assertEquals(workoutExerciseDTO1.getSeries(), expectedWorkoutExerciseDTO1.getSeries());

        WorkoutExerciseDTO expectedWorkoutExerciseDTO2 = workoutExerciseController.getObject(workoutExerciseDTO2.getId());
        assertEquals(workoutExerciseDTO2.getRepeat(), expectedWorkoutExerciseDTO2.getRepeat());

        assertEquals(4, workoutController.getObject(workoutDTO.getId()).getUserExercises().size());

        deleteWorkoutExercise(workoutExerciseDTO1);
        assertEquals(3, workoutController.getObject(workoutDTO.getId()).getUserExercises().size());

        workoutController.deleteObject(workoutDTO.getId());
        assertTrue(workoutExerciseController.findAll().isEmpty());

        WorkoutDTO workoutDTO1 = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2012, 9, 12).getTime(), userDetailsId1));
        WorkoutExerciseDTO workoutExerciseDTO5 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO1, exerciseDTO3, 6, 2));
        WorkoutExerciseDTO workoutExerciseDTO6 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO1, exerciseDTO4, 12, 2));
        assertEquals(2, workoutExerciseController.findAll().size());

        userDetailsController.deleteObject(workoutDTO.getId());
        assertTrue(workoutExerciseController.findAll().isEmpty());

    }

    private void deleteWorkoutExercise(WorkoutExerciseDTO workoutExerciseDTO1) {
        workoutExerciseController.deleteObject(workoutExerciseDTO1.getId());
        assertFalse(workoutExerciseController.isExist(workoutExerciseDTO1.getId()));
    }

    @Test
    public void updateObject() throws Exception {

    }

    @Test
    public void findAll() throws Exception {

    }

    @Test
    public void deleteObject() throws Exception {

    }

    @Test
    public void isExist() throws Exception {

    }

    @Test
    public void getWorkoutExerciseByUserId() throws Exception {

    }

    @Test
    public void getWorkoutExercisesByWorkout() throws Exception {

    }

}