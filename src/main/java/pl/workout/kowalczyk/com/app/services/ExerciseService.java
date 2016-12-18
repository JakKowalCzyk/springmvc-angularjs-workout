package pl.workout.kowalczyk.com.app.services;

import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.model.BO.Exercise;
import pl.workout.kowalczyk.com.app.model.DTO.ExerciseDTO;

import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface ExerciseService {
    Exercise mapExerciseDtoToBo(ExerciseDTO exerciseDTO);
    ExerciseDTO mapExerciseBoToDTO(Exercise exercise);
    void saveExercise(ExerciseDTO exercise);
    List<ExerciseDTO> getAllExercisesDTO();
    ExerciseDTO getExerciseDTOByName(String name);

    ExerciseDTO getExerciseDTOById(int exerciseId);

    Exercise getExerciseById(int exerciseId);

    List<ExerciseDTO> getExercisesDTOForBodyPart(ExerciseType exerciseType);
}
