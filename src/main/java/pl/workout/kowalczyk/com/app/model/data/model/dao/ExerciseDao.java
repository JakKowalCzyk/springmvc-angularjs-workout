package pl.workout.kowalczyk.com.app.model.data.model.dao;

import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.model.data.model.entity.Exercise;

import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface ExerciseDao extends BaseDao<Exercise> {
    Exercise getExerciseByName(String name);

    List<Exercise> getExercisesForBodyPart(ExerciseType exerciseType);
}
