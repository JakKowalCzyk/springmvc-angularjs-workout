package pl.workout.kowalczyk.com.app.dao.exercise;

import pl.workout.kowalczyk.com.app.dao.BaseDao;
import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.model.BO.exercise.Exercise;

import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface ExerciseDao extends BaseDao<Exercise> {
    Exercise getExerciseByName(String name);

    List<Exercise> getExercisesForBodyPart(ExerciseType exerciseType);
}
