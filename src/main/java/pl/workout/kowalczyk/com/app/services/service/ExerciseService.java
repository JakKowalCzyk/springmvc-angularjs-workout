package pl.workout.kowalczyk.com.app.services.service;

import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.model.data.entity.Exercise;

import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface ExerciseService {
    void saveExercise(Exercise exercise);
    void getAllExercises();
    Exercise getExerciseByName(String name);
    List<Exercise> getExercisesForBodyPart(ExerciseType exerciseType);
}
