package pl.workout.kowalczyk.com.app.mapper.exercise;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.mapper.AbstractMapperTest;
import pl.workout.kowalczyk.com.app.model.BO.exercise.Exercise;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.ExerciseDTO;

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
        assertEquals(exerciseDTO.getId(), exercise.getId());
        assertEquals(exerciseDTO.getName(), exercise.getName());
        assertEquals(exerciseDTO.getDescription(), exercise.getDescription());
        assertEquals(exerciseDTO.getExerciseType(), exerciseDTO.getExerciseType());
    }

    @Test
    public void buildDTO() throws Exception {
        Exercise exercise = new Exercise("ex", "de", ExerciseType.BACK);
        exercise.setId(4L);
        ExerciseDTO exerciseDTO = exerciseMapper.mapToDTO(exercise);
        assertEquals(exercise.getId(), exerciseDTO.getId());
        assertEquals(exercise.getName(), exerciseDTO.getName());
        assertEquals(exercise.getDescription(), exercise.getDescription());
        assertEquals(exercise.getExerciseType(), exercise.getExerciseType());
    }

}