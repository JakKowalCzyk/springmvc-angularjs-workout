package pl.workout.kowalczyk.com.app.model.dao;

import pl.workout.kowalczyk.com.app.model.Enums.ExerciseType;
import pl.workout.kowalczyk.com.app.model.entity.Exercise;

import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface ExerciseDao extends BaseDao<Exercise> {
    Exercise getExerciseByName(String name);

    List<Exercise> getExercisesForBodyPart(ExerciseType exerciseType);
}
