package pl.workout.kowalczyk.com.app.services.service;

import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.model.BO.Exercise;

import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface ExerciseService {
    void saveExercise(Exercise exercise);
    List<Exercise> getAllExercises();
    Exercise getExerciseByName(String name);

    Exercise getExerciseById(int exerciseId);
    List<Exercise> getExercisesForBodyPart(ExerciseType exerciseType);
}
