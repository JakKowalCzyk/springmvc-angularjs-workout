package pl.workout.kowalczyk.com.app.dao;

import pl.workout.kowalczyk.com.app.model.BO.UserExercise;

import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface UserExerciseDao extends BaseDao<UserExercise> {
    List<UserExercise> getUserExercisesByUserId(int userId);

}
