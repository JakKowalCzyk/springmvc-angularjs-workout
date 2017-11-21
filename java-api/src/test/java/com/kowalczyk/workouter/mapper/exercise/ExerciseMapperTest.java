package com.kowalczyk.workouter.mapper.exercise;

import com.kowalczyk.workouter.enums.ExerciseType;
import com.kowalczyk.workouter.mapper.AbstractMapperTest;
import com.kowalczyk.workouter.model.BO.exercise.Exercise;
import com.kowalczyk.workouter.model.DTO.exercise.ExerciseDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Created by JK on 2017-03-22.
 */
public class ExerciseMapperTest extends AbstractMapperTest {
    @Autowired
    private ExerciseMapper exerciseMapper;

    @Test
    public void buildBO() throws Exception {
        ExerciseDTO exerciseDTO = new ExerciseDTO("exercise", "desc", ExerciseType.ARMS);
        exerciseDTO.setId(1L);
        Exercise exercise = exerciseMapper.mapToBO(exerciseDTO);
        Assert.assertEquals(exerciseDTO.getId(), exercise.getId());
        assertEquals(exerciseDTO.getName(), exercise.getName());
        assertEquals(exerciseDTO.getDescription(), exercise.getDescription());
        assertEquals(exerciseDTO.getExerciseType(), exerciseDTO.getExerciseType());
    }

    @Test
    public void buildDTO() throws Exception {
        Exercise exercise = new Exercise("ex", "de", ExerciseType.BACK);
        exercise.setId(4L);
        ExerciseDTO exerciseDTO = exerciseMapper.mapToDTO(exercise);
        Assert.assertEquals(exercise.getId(), exerciseDTO.getId());
        assertEquals(exercise.getName(), exerciseDTO.getName());
        assertEquals(exercise.getDescription(), exercise.getDescription());
        assertEquals(exercise.getExerciseType(), exercise.getExerciseType());
    }

}