package pl.workout.kowalczyk.com.app.mapper.exercise;

import org.springframework.stereotype.Component;
import pl.workout.kowalczyk.com.app.mapper.impl.ModelMapperImpl;
import pl.workout.kowalczyk.com.app.model.BO.exercise.Exercise;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.ExerciseDTO;

/**
 * Created by JK on 2017-02-18.
 */
@Component
public class ExerciseMapper extends ModelMapperImpl<Exercise, ExerciseDTO> {
    @Override
    protected Exercise buildBO(ExerciseDTO objectDTO) {
        return new Exercise(objectDTO.getName(), objectDTO.getDescription(), objectDTO.getExerciseType());
    }

    @Override
    protected ExerciseDTO buildDTO(Exercise modelObject) {
        return new ExerciseDTO(modelObject.getName(), modelObject.getDescription(), modelObject.getExerciseType());
    }
}
