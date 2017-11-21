package com.kowalczyk.workouter.controllers.exercise;

import com.kowalczyk.workouter.controllers.AbstractControllerTest;
import com.kowalczyk.workouter.enums.ExerciseType;
import com.kowalczyk.workouter.model.DTO.exercise.ExerciseDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by JK on 2017-08-16.
 */
public class ExerciseControllerTest extends AbstractControllerTest {

    @Autowired
    private ExerciseController exerciseController;

    @Test
    public void getObject() throws Exception {
        ExerciseDTO exerciseDTO1 = exerciseController.addObject(createExerciseDTOTest("ex1", "dex1", ExerciseType.ARMS));
        ExerciseDTO exerciseDTO2 = exerciseController.addObject(createExerciseDTOTest("ex2", "dex2", ExerciseType.BACK));

        ExerciseDTO expectedExerciseDTO1 = exerciseController.getObject(exerciseDTO1.getId());
        assertEquals(exerciseDTO1.getId(), expectedExerciseDTO1.getId());
        assertEquals(exerciseDTO1.getExerciseType(), expectedExerciseDTO1.getExerciseType());

        ExerciseDTO expectedExerciseDTO2 = exerciseController.getObject(exerciseDTO2.getId());
        assertEquals(exerciseDTO2.getName(), expectedExerciseDTO2.getName());

        deleteExercise(exerciseDTO1);
        deleteExercise(exerciseDTO2);

    }

    private void deleteExercise(ExerciseDTO exerciseDTO1) {
        exerciseController.deleteObject(exerciseDTO1.getId());
        assertFalse(exerciseController.isExist(exerciseDTO1.getId()));
    }

    @Test
    public void updateObject() throws Exception {
        ExerciseDTO exerciseDTO1 = exerciseController.addObject(createExerciseDTOTest("ex1", "dex1", ExerciseType.ARMS));
        ExerciseDTO exerciseDTO2 = exerciseController.addObject(createExerciseDTOTest("ex2", "dex2", ExerciseType.BACK));

        exerciseDTO1.setExerciseType(ExerciseType.BACK);
        exerciseDTO1.setDescription("new Desc1");
        exerciseDTO1.setName("new Nam");
        ExerciseDTO updatedExerciseDTO1 = exerciseController.updateObject(exerciseDTO1);
        assertEquals(exerciseDTO1.getId(), updatedExerciseDTO1.getId());
        assertEquals(exerciseDTO1.getExerciseType(), updatedExerciseDTO1.getExerciseType());
        assertEquals(exerciseDTO1.getName(), updatedExerciseDTO1.getName());

        deleteExercise(exerciseDTO1);
        deleteExercise(exerciseDTO2);
    }

    @Test
    public void findAll() throws Exception {
        List<ExerciseDTO> exerciseDTOList = exerciseController.findAll();
        assertTrue(exerciseDTOList.isEmpty());

        ExerciseDTO exerciseDTO1 = exerciseController.addObject(createExerciseDTOTest("ex1", "dex1", ExerciseType.ARMS));
        exerciseDTOList = exerciseController.findAll();
        assertEquals(1, exerciseDTOList.size());

        ExerciseDTO exerciseDTO2 = exerciseController.addObject(createExerciseDTOTest("ex2", "dex2", ExerciseType.BACK));
        ExerciseDTO exerciseDTO3 = exerciseController.addObject(createExerciseDTOTest("ex3", "dex3", ExerciseType.BACK));
        ExerciseDTO exerciseDTO4 = exerciseController.addObject(createExerciseDTOTest("ex4", "dex4", ExerciseType.BACK));
        exerciseDTOList = exerciseController.findAll();
        assertEquals(4, exerciseDTOList.size());

        deleteExercise(exerciseDTO1);
        deleteExercise(exerciseDTO2);
        exerciseDTOList = exerciseController.findAll();
        assertEquals(2, exerciseDTOList.size());

        deleteExercise(exerciseDTO3);
        deleteExercise(exerciseDTO4);
        exerciseDTOList = exerciseController.findAll();
        assertTrue(exerciseDTOList.isEmpty());
    }

    @Test
    public void searchExercise() throws Exception {
        ExerciseDTO exerciseDTO1 = exerciseController.addObject(createExerciseDTOTest("EX1", "Pushing", ExerciseType.ARMS));
        ExerciseDTO exerciseDTO2 = exerciseController.addObject(createExerciseDTOTest("eexx2", "pulling", ExerciseType.BACK));
        ExerciseDTO exerciseDTO3 = exerciseController.addObject(createExerciseDTOTest("eexx22", "pulling2", ExerciseType.BACK));
        ExerciseDTO exerciseDTO4 = exerciseController.addObject(createExerciseDTOTest("e3X3X", "dex4", ExerciseType.BACK));
        ExerciseDTO exerciseDTO5 = exerciseController.addObject(createExerciseDTOTest("Last", "Squat", ExerciseType.LEGS));

        List<ExerciseDTO> exerciseDTOS = exerciseController.searchExercise("EX1");
        assertTrue(exerciseDTOS.size() == 1);
        assertTrue(exerciseDTOS.stream().anyMatch(exerciseDTO -> exerciseDTO.getId().equals(exerciseDTO1.getId())));
        exerciseDTOS = exerciseController.searchExercise("push");
        assertTrue(exerciseDTOS.size() == 1);
        assertTrue(exerciseDTOS.stream().anyMatch(exerciseDTO -> exerciseDTO.getId().equals(exerciseDTO1.getId())));
        exerciseDTOS = exerciseController.searchExercise(ExerciseType.ARMS.name());
        assertTrue(exerciseDTOS.size() == 1);
        assertTrue(exerciseDTOS.stream().anyMatch(exerciseDTO -> exerciseDTO.getId().equals(exerciseDTO1.getId())));

        exerciseDTOS = exerciseController.searchExercise("ee");
        assertTrue(exerciseDTOS.size() == 2);
        assertTrue(exerciseDTOS.stream().anyMatch(exerciseDTO -> exerciseDTO.getId().equals(exerciseDTO2.getId())));
        assertTrue(exerciseDTOS.stream().anyMatch(exerciseDTO -> exerciseDTO.getId().equals(exerciseDTO3.getId())));
        exerciseDTOS = exerciseController.searchExercise("pulling");
        assertTrue(exerciseDTOS.size() == 2);
        assertTrue(exerciseDTOS.stream().anyMatch(exerciseDTO -> exerciseDTO.getId().equals(exerciseDTO2.getId())));
        assertTrue(exerciseDTOS.stream().anyMatch(exerciseDTO -> exerciseDTO.getId().equals(exerciseDTO3.getId())));
        exerciseDTOS = exerciseController.searchExercise("bac");
        assertTrue(exerciseDTOS.size() == 3);
        assertTrue(exerciseDTOS.stream().anyMatch(exerciseDTO -> exerciseDTO.getId().equals(exerciseDTO2.getId())));
        assertTrue(exerciseDTOS.stream().anyMatch(exerciseDTO -> exerciseDTO.getId().equals(exerciseDTO3.getId())));
        assertTrue(exerciseDTOS.stream().anyMatch(exerciseDTO -> exerciseDTO.getId().equals(exerciseDTO4.getId())));

        exerciseDTOS = exerciseController.searchExercise("sT");
        assertTrue(exerciseDTOS.size() == 1);
        assertTrue(exerciseDTOS.stream().anyMatch(exerciseDTO -> exerciseDTO.getId().equals(exerciseDTO5.getId())));

        exerciseDTOS = exerciseController.searchExercise(ExerciseType.SHOULDERS.name());
        assertTrue(exerciseDTOS.size() == 0);
        exerciseDTOS = exerciseController.searchExercise("pulling3");
        assertTrue(exerciseDTOS.size() == 0);

        deleteExercise(exerciseDTO1);
        deleteExercise(exerciseDTO2);
        deleteExercise(exerciseDTO3);
        deleteExercise(exerciseDTO4);
        deleteExercise(exerciseDTO5);
    }

    @Test
    public void getExercisesByType() throws Exception {
        ExerciseDTO exerciseDTO1 = exerciseController.addObject(createExerciseDTOTest("ex1", "dex1", ExerciseType.ARMS));
        ExerciseDTO exerciseDTO21 = exerciseController.addObject(createExerciseDTOTest("ex2", "dex2", ExerciseType.BACK));
        ExerciseDTO exerciseDTO22 = exerciseController.addObject(createExerciseDTOTest("ex3", "dex3", ExerciseType.BACK));
        ExerciseDTO exerciseDTO23 = exerciseController.addObject(createExerciseDTOTest("ex4", "dex4", ExerciseType.BACK));
        ExerciseDTO exerciseDTO31 = exerciseController.addObject(createExerciseDTOTest("ex5", "dex5", ExerciseType.CHEST));
        ExerciseDTO exerciseDTO32 = exerciseController.addObject(createExerciseDTOTest("ex6", "dex6", ExerciseType.CHEST));
        ExerciseDTO exerciseDTO4 = exerciseController.addObject(createExerciseDTOTest("ex7", "dex7", ExerciseType.SHOULDERS));

        assertEquals(1, exerciseController.getExercisesByType(ExerciseType.ARMS).size());
        assertEquals(3, exerciseController.getExercisesByType(ExerciseType.BACK).size());
        assertEquals(2, exerciseController.getExercisesByType(ExerciseType.CHEST).size());
        assertEquals(1, exerciseController.getExercisesByType(ExerciseType.SHOULDERS).size());

        assertTrue(exerciseController.getExercisesByType(ExerciseType.LEGS).isEmpty());
        deleteExercise(exerciseDTO1);
        deleteExercise(exerciseDTO21);
        deleteExercise(exerciseDTO22);
        deleteExercise(exerciseDTO23);
        deleteExercise(exerciseDTO31);
        deleteExercise(exerciseDTO32);
        deleteExercise(exerciseDTO4);
    }

}