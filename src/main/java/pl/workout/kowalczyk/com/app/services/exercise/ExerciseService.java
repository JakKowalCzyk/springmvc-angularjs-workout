package pl.workout.kowalczyk.com.app.services.exercise;

import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.model.BO.exercise.Exercise;
import pl.workout.kowalczyk.com.app.services.ModelService;

import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface ExerciseService extends ModelService<Exercise> {

    Exercise getExerciseByName(String name);

    List<Exercise> getExercisesForBodyPart(ExerciseType exerciseType);
}
