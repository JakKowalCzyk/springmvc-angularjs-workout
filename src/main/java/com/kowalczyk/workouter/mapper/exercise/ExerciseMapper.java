package com.kowalczyk.workouter.mapper.exercise;

import com.kowalczyk.workouter.mapper.impl.ModelMapperImpl;
import com.kowalczyk.workouter.model.BO.exercise.Exercise;
import com.kowalczyk.workouter.model.DTO.exercise.ExerciseDTO;
import org.springframework.stereotype.Component;

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
