package pl.workout.kowalczyk.com.app.model.dao;

import pl.workout.kowalczyk.com.app.model.entity.Exercise;

/**
 * Created by JK on 2016-09-22.
 */
public interface ExerciseDao extends BaseDao<Exercise> {
    Exercise getExerciseByUserId(int userId);
}
