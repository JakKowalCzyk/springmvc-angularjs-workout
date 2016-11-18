package pl.workout.kowalczyk.com.app.services.service;

import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.model.DTO.ExerciseDTO;

import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface ExerciseService {
    void saveExercise(ExerciseDTO exercise);
    List<ExerciseDTO> getAllExercises();
    ExerciseDTO getExerciseByName(String name);

    ExerciseDTO getExerciseById(int exerciseId);
    List<ExerciseDTO> getExercisesForBodyPart(ExerciseType exerciseType);
}
