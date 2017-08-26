package com.kowalczyk.workouter.controllers.exercise;

import com.kowalczyk.workouter.controllers.AbstractControllerTest;
import com.kowalczyk.workouter.enums.ExerciseType;
import com.kowalczyk.workouter.model.DTO.exercise.ExerciseDTO;
import com.kowalczyk.workouter.model.DTO.exercise.WorkoutDTO;
import com.kowalczyk.workouter.model.DTO.exercise.WorkoutExerciseDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Created by JK on 2017-08-26.
 */
public class WorkoutControllerTest extends AbstractControllerTest {

    @Autowired
    private WorkoutExerciseController workoutExerciseController;
    @Autowired
    private WorkoutController workoutController;
    @Autowired
    private ExerciseController exerciseController;

    @Test
    public void getObject() throws Exception {
        WorkoutDTO workoutDTO1 = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2012, 9, 12).getTime(), userDetailsId1));
        WorkoutDTO workoutDTO2 = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2010, 9, 12).getTime(), userDetailsId1));
        ExerciseDTO exerciseDTO1 = exerciseController.addObject(createExerciseDTOTest("ex1", "dex1", ExerciseType.ARMS));
        ExerciseDTO exerciseDTO2 = exerciseController.addObject(createExerciseDTOTest("ex2", "dex2", ExerciseType.BACK));
        WorkoutExerciseDTO workoutExerciseDTO11 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO1, exerciseDTO1, 10, 3));
        WorkoutExerciseDTO workoutExerciseDTO21 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO1, exerciseDTO2, 9, 3));

        WorkoutDTO expectedWorkoutDTO1 = workoutController.getObject(workoutDTO1.getId());
        assertEquals(workoutDTO1.getId(), expectedWorkoutDTO1.getId());
        assertEquals(workoutDTO1.getDate(), expectedWorkoutDTO1.getDate());
        assertEquals(2, expectedWorkoutDTO1.getUserExercises().size());

        WorkoutDTO expectedWorkoutDTO2 = workoutController.getObject(workoutDTO2.getId());
        assertEquals(workoutDTO2.getId(), expectedWorkoutDTO2.getId());
        assertTrue(expectedWorkoutDTO2.getUserExercises().isEmpty());

        deleteWorkout(workoutDTO1);
        deleteWorkout(workoutDTO2);

        WorkoutDTO workoutDTO3 = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2012, 9, 12).getTime(), userDetailsId1));
        WorkoutDTO workoutDTO4 = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2010, 9, 12).getTime(), userDetailsId1));
        WorkoutDTO workoutDTO5 = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2010, 9, 12).getTime(), userDetailsId2));
        userDetailsController.deleteObject(workoutDTO3.getUserId());
        assertEquals(1, workoutController.findAll().size());

        userDetailsController.deleteObject(workoutDTO5.getUserId());
        assertTrue(workoutController.findAll().isEmpty());
    }

    private void deleteWorkout(WorkoutDTO workoutDTO1) {
        workoutController.deleteObject(workoutDTO1.getId());
        assertFalse(workoutController.isExist(workoutDTO1.getId()));
    }

    @Test
    public void updateObject() throws Exception {
        WorkoutDTO workoutDTO1 = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2012, 9, 12).getTime(), userDetailsId1));
        WorkoutDTO workoutDTO2 = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2010, 9, 12).getTime(), userDetailsId1));
        ExerciseDTO exerciseDTO1 = exerciseController.addObject(createExerciseDTOTest("ex1", "dex1", ExerciseType.ARMS));
        ExerciseDTO exerciseDTO2 = exerciseController.addObject(createExerciseDTOTest("ex2", "dex2", ExerciseType.BACK));
        WorkoutExerciseDTO workoutExerciseDTO11 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO1, exerciseDTO1, 10, 3));
        WorkoutExerciseDTO workoutExerciseDTO12 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO1, exerciseDTO2, 9, 3));

        workoutDTO1.setDate(new GregorianCalendar().getTime());
        WorkoutDTO updatedWorkoutDTO1 = workoutController.updateObject(workoutDTO1);
        assertEquals(workoutDTO1.getId(), updatedWorkoutDTO1.getId());
        assertEquals(workoutDTO1.getDate(), updatedWorkoutDTO1.getDate());
        assertTrue(updatedWorkoutDTO1.getUserExercises().isEmpty());
        assertTrue(workoutExerciseController.findAll().isEmpty());

        deleteWorkout(workoutDTO1);
        deleteWorkout(workoutDTO2);

        WorkoutDTO workoutDTO3 = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2012, 9, 12).getTime(), userDetailsId1));
        WorkoutDTO workoutDTO4 = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2010, 9, 12).getTime(), userDetailsId1));
        WorkoutExerciseDTO workoutExerciseDTO31 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO3, exerciseDTO1, 10, 3));
        WorkoutExerciseDTO workoutExerciseDTO32 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO3, exerciseDTO2, 9, 3));

        workoutDTO3 = workoutController.getObject(workoutDTO3.getId());
        workoutDTO3.getUserExercises().remove(1);
        WorkoutDTO updatedWorkoutDTO3 = workoutController.updateObject(workoutDTO3);
        assertEquals(workoutDTO3.getId(), updatedWorkoutDTO3.getId());
        assertEquals(1, updatedWorkoutDTO3.getUserExercises().size());

        deleteWorkout(workoutDTO3);
        deleteWorkout(workoutDTO4);
    }

    @Test
    public void findAll() throws Exception {

    }

    @Test
    public void getWorkoutsByUser() throws Exception {

    }

    @Test
    public void getWorkoutByDate() throws Exception {

    }

}