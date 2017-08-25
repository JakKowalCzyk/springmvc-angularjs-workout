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
import java.util.List;

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

        userDetailsController.deleteObject(workoutDTO.getUserId());
        assertTrue(workoutExerciseController.findAll().isEmpty());
    }

    private void deleteWorkoutExercise(WorkoutExerciseDTO workoutExerciseDTO1) {
        workoutExerciseController.deleteObject(workoutExerciseDTO1.getId());
        assertFalse(workoutExerciseController.isExist(workoutExerciseDTO1.getId()));
    }

    @Test
    public void updateObject() throws Exception {
        WorkoutDTO workoutDTO1 = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2012, 9, 12).getTime(), userDetailsId1));
        WorkoutDTO workoutDTO2 = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2010, 9, 12).getTime(), userDetailsId1));
        ExerciseDTO exerciseDTO1 = exerciseController.addObject(createExerciseDTOTest("ex1", "dex1", ExerciseType.ARMS));
        ExerciseDTO exerciseDTO2 = exerciseController.addObject(createExerciseDTOTest("ex2", "dex2", ExerciseType.BACK));
        ExerciseDTO exerciseDTO3 = exerciseController.addObject(createExerciseDTOTest("ex3", "dex3", ExerciseType.HANDS));
        ExerciseDTO exerciseDTO4 = exerciseController.addObject(createExerciseDTOTest("ex4", "dex4", ExerciseType.LEGS));

        WorkoutExerciseDTO workoutExerciseDTO1 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO1, exerciseDTO1, 10, 3));
        WorkoutExerciseDTO workoutExerciseDTO2 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO1, exerciseDTO2, 9, 3));

        workoutExerciseDTO1.setExerciseId(exerciseDTO3.getId());
        WorkoutExerciseDTO updatedWorkoutExerciseDTO1 = workoutExerciseController.updateObject(workoutExerciseDTO1);
        assertEquals(workoutExerciseDTO1.getId(), updatedWorkoutExerciseDTO1.getId());
        assertEquals(workoutExerciseDTO1.getExerciseId(), updatedWorkoutExerciseDTO1.getExerciseId());

        workoutExerciseDTO2.setRepeat(100);
        workoutExerciseDTO2.setSeries(5);
        WorkoutExerciseDTO updatedWorkoutExerciseDTO2 = workoutExerciseController.updateObject(workoutExerciseDTO2);
        assertEquals(workoutExerciseDTO2.getId(), updatedWorkoutExerciseDTO2.getId());
        assertEquals(workoutExerciseDTO2.getSeries(), updatedWorkoutExerciseDTO2.getSeries());
        assertEquals(workoutExerciseDTO2.getRepeat(), updatedWorkoutExerciseDTO2.getRepeat());

        deleteWorkoutExercise(workoutExerciseDTO1);
        deleteWorkoutExercise(workoutExerciseDTO2);

        WorkoutExerciseDTO workoutExerciseDTO3 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO1, exerciseDTO3, 3, 5));
        workoutExerciseDTO3.setWorkoutId(workoutDTO2.getId());
        workoutExerciseDTO3 = workoutExerciseController.updateObject(workoutExerciseDTO3);
        assertEquals(workoutDTO1.getId(), workoutExerciseDTO3.getWorkoutId());

        deleteWorkoutExercise(workoutExerciseDTO3);
    }

    @Test
    public void findAll() throws Exception {
        WorkoutDTO workoutDTO1 = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2012, 9, 12).getTime(), userDetailsId1));
        WorkoutDTO workoutDTO2 = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2010, 9, 12).getTime(), userDetailsId1));
        ExerciseDTO exerciseDTO1 = exerciseController.addObject(createExerciseDTOTest("ex1", "dex1", ExerciseType.ARMS));
        ExerciseDTO exerciseDTO2 = exerciseController.addObject(createExerciseDTOTest("ex2", "dex2", ExerciseType.BACK));
        ExerciseDTO exerciseDTO3 = exerciseController.addObject(createExerciseDTOTest("ex3", "dex3", ExerciseType.HANDS));
        ExerciseDTO exerciseDTO4 = exerciseController.addObject(createExerciseDTOTest("ex4", "dex4", ExerciseType.LEGS));
        WorkoutExerciseDTO workoutExerciseDTO1 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO1, exerciseDTO1, 10, 3));
        WorkoutExerciseDTO workoutExerciseDTO2 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO1, exerciseDTO2, 9, 3));
        WorkoutExerciseDTO workoutExerciseDTO3 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO2, exerciseDTO3, 6, 2));

        List<WorkoutExerciseDTO> workoutExerciseDTOList = workoutExerciseController.findAll();
        assertEquals(3, workoutExerciseDTOList.size());

        WorkoutExerciseDTO workoutExerciseDTO4 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO2, exerciseDTO4, 12, 2));
        workoutExerciseDTOList = workoutExerciseController.findAll();
        assertEquals(4, workoutExerciseDTOList.size());

        deleteWorkoutExercise(workoutExerciseDTO1);
        deleteWorkoutExercise(workoutExerciseDTO2);

        workoutExerciseDTOList = workoutExerciseController.findAll();
        assertEquals(2, workoutExerciseDTOList.size());

        deleteWorkoutExercise(workoutExerciseDTO3);
        deleteWorkoutExercise(workoutExerciseDTO4);
        assertTrue(workoutExerciseController.findAll().isEmpty());
    }

    @Test
    public void getWorkoutExerciseByUserId() throws Exception {
        WorkoutDTO workoutDTO1 = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2012, 9, 12).getTime(), userDetailsId1));
        WorkoutDTO workoutDTO2 = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2010, 9, 12).getTime(), userDetailsId2));
        ExerciseDTO exerciseDTO1 = exerciseController.addObject(createExerciseDTOTest("ex1", "dex1", ExerciseType.ARMS));
        ExerciseDTO exerciseDTO2 = exerciseController.addObject(createExerciseDTOTest("ex2", "dex2", ExerciseType.BACK));
        ExerciseDTO exerciseDTO3 = exerciseController.addObject(createExerciseDTOTest("ex3", "dex3", ExerciseType.HANDS));
        ExerciseDTO exerciseDTO4 = exerciseController.addObject(createExerciseDTOTest("ex4", "dex4", ExerciseType.LEGS));
        WorkoutExerciseDTO workoutExerciseDTO11 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO1, exerciseDTO1, 10, 3));
        WorkoutExerciseDTO workoutExerciseDTO12 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO1, exerciseDTO2, 9, 3));
        WorkoutExerciseDTO workoutExerciseDTO21 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO2, exerciseDTO3, 6, 2));
        WorkoutExerciseDTO workoutExerciseDTO22 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO2, exerciseDTO4, 12, 2));

        List<WorkoutExerciseDTO> workoutExerciseDTOSuD1 = workoutExerciseController.getWorkoutExerciseByUserId(userDetailsId1);
        assertEquals(2, workoutExerciseDTOSuD1.size());
        List<WorkoutExerciseDTO> workoutExerciseDTOSuD2 = workoutExerciseController.getWorkoutExerciseByUserId(userDetailsId2);
        assertEquals(2, workoutExerciseDTOSuD2.size());
        assertTrue(workoutExerciseController.getWorkoutExerciseByUserId(userDetailsId2 + 1).isEmpty());

        WorkoutExerciseDTO workoutExerciseDTO13 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO1, exerciseDTO1, 10, 3));
        WorkoutExerciseDTO workoutExerciseDTO14 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO1, exerciseDTO2, 9, 3));
        WorkoutExerciseDTO workoutExerciseDTO15 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO1, exerciseDTO3, 6, 2));
        WorkoutExerciseDTO workoutExerciseDTO23 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO2, exerciseDTO4, 12, 2));

        workoutExerciseDTOSuD1 = workoutExerciseController.getWorkoutExerciseByUserId(userDetailsId1);
        assertEquals(5, workoutExerciseDTOSuD1.size());
        workoutExerciseDTOSuD2 = workoutExerciseController.getWorkoutExerciseByUserId(userDetailsId2);
        assertEquals(3, workoutExerciseDTOSuD2.size());

        deleteWorkoutExercise(workoutExerciseDTO11);
        deleteWorkoutExercise(workoutExerciseDTO12);
        deleteWorkoutExercise(workoutExerciseDTO21);
        deleteWorkoutExercise(workoutExerciseDTO22);
        workoutExerciseDTOSuD1 = workoutExerciseController.getWorkoutExerciseByUserId(userDetailsId1);
        assertEquals(3, workoutExerciseDTOSuD1.size());
        workoutExerciseDTOSuD2 = workoutExerciseController.getWorkoutExerciseByUserId(userDetailsId2);
        assertEquals(1, workoutExerciseDTOSuD2.size());

        deleteWorkoutExercise(workoutExerciseDTO13);
        deleteWorkoutExercise(workoutExerciseDTO14);
        deleteWorkoutExercise(workoutExerciseDTO15);
        deleteWorkoutExercise(workoutExerciseDTO23);
        assertTrue(workoutExerciseController.getWorkoutExerciseByUserId(userDetailsId1).isEmpty());
        assertTrue(workoutExerciseController.getWorkoutExerciseByUserId(userDetailsId2).isEmpty());
        assertTrue(workoutExerciseController.getWorkoutExerciseByUserId(userDetailsId2 + 1).isEmpty());
    }

    @Test
    public void getWorkoutExercisesByWorkout() throws Exception {
        WorkoutDTO workoutDTO11 = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2012, 9, 12).getTime(), userDetailsId1));
        WorkoutDTO workoutDTO12 = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2011, 9, 13).getTime(), userDetailsId1));
        WorkoutDTO workoutDTO13 = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2015, 6, 12).getTime(), userDetailsId1));
        WorkoutDTO workoutDTO21 = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2012, 9, 15).getTime(), userDetailsId2));
        WorkoutDTO workoutDTO22 = workoutController.addObject(createWorkoutDTOTest(new GregorianCalendar(2018, 4, 12).getTime(), userDetailsId2));
        ExerciseDTO exerciseDTO1 = exerciseController.addObject(createExerciseDTOTest("ex1", "dex1", ExerciseType.ARMS));
        ExerciseDTO exerciseDTO2 = exerciseController.addObject(createExerciseDTOTest("ex2", "dex2", ExerciseType.BACK));
        ExerciseDTO exerciseDTO3 = exerciseController.addObject(createExerciseDTOTest("ex3", "dex3", ExerciseType.HANDS));
        ExerciseDTO exerciseDTO4 = exerciseController.addObject(createExerciseDTOTest("ex4", "dex4", ExerciseType.LEGS));
        WorkoutExerciseDTO workoutExerciseDTO111 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO11, exerciseDTO1, 10, 3));
        WorkoutExerciseDTO workoutExerciseDTO112 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO11, exerciseDTO2, 9, 3));
        WorkoutExerciseDTO workoutExerciseDTO113 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO11, exerciseDTO3, 6, 2));
        WorkoutExerciseDTO workoutExerciseDTO114 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO11, exerciseDTO4, 12, 2));
        WorkoutExerciseDTO workoutExerciseDTO121 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO12, exerciseDTO4, 12, 2));
        WorkoutExerciseDTO workoutExerciseDTO122 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO12, exerciseDTO4, 12, 2));
        WorkoutExerciseDTO workoutExerciseDTO211 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO21, exerciseDTO4, 12, 2));
        WorkoutExerciseDTO workoutExerciseDTO212 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO21, exerciseDTO4, 12, 2));
        WorkoutExerciseDTO workoutExerciseDTO213 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO21, exerciseDTO4, 12, 2));
        WorkoutExerciseDTO workoutExerciseDTO221 = workoutExerciseController.addObject(createWorkoutExerciseDTOTest(workoutDTO22, exerciseDTO4, 12, 2));

        assertEquals(4, workoutExerciseController.getWorkoutExercisesByWorkout(workoutDTO11.getId()).size());
        assertEquals(2, workoutExerciseController.getWorkoutExercisesByWorkout(workoutDTO12.getId()).size());
        assertEquals(0, workoutExerciseController.getWorkoutExercisesByWorkout(workoutDTO13.getId()).size());
        assertEquals(3, workoutExerciseController.getWorkoutExercisesByWorkout(workoutDTO21.getId()).size());
        assertEquals(1, workoutExerciseController.getWorkoutExercisesByWorkout(workoutDTO22.getId()).size());
        assertEquals(0, workoutExerciseController.getWorkoutExercisesByWorkout(workoutDTO22.getId() + 1).size());

        deleteWorkoutExercise(workoutExerciseDTO111);
        deleteWorkoutExercise(workoutExerciseDTO112);
        deleteWorkoutExercise(workoutExerciseDTO121);
        deleteWorkoutExercise(workoutExerciseDTO122);
        deleteWorkoutExercise(workoutExerciseDTO211);
        deleteWorkoutExercise(workoutExerciseDTO221);
        assertEquals(2, workoutExerciseController.getWorkoutExercisesByWorkout(workoutDTO11.getId()).size());
        assertEquals(0, workoutExerciseController.getWorkoutExercisesByWorkout(workoutDTO12.getId()).size());
        assertEquals(0, workoutExerciseController.getWorkoutExercisesByWorkout(workoutDTO13.getId()).size());
        assertEquals(2, workoutExerciseController.getWorkoutExercisesByWorkout(workoutDTO21.getId()).size());
        assertEquals(0, workoutExerciseController.getWorkoutExercisesByWorkout(workoutDTO22.getId()).size());
        assertEquals(0, workoutExerciseController.getWorkoutExercisesByWorkout(workoutDTO22.getId() + 1).size());

        deleteWorkoutExercise(workoutExerciseDTO113);
        deleteWorkoutExercise(workoutExerciseDTO114);
        deleteWorkoutExercise(workoutExerciseDTO212);
        deleteWorkoutExercise(workoutExerciseDTO213);
        assertEquals(0, workoutExerciseController.getWorkoutExercisesByWorkout(workoutDTO11.getId()).size());
        assertEquals(0, workoutExerciseController.getWorkoutExercisesByWorkout(workoutDTO12.getId()).size());
        assertEquals(0, workoutExerciseController.getWorkoutExercisesByWorkout(workoutDTO13.getId()).size());
        assertEquals(0, workoutExerciseController.getWorkoutExercisesByWorkout(workoutDTO21.getId()).size());
        assertEquals(0, workoutExerciseController.getWorkoutExercisesByWorkout(workoutDTO22.getId()).size());
        assertEquals(0, workoutExerciseController.getWorkoutExercisesByWorkout(workoutDTO22.getId() + 1).size());
    }

}