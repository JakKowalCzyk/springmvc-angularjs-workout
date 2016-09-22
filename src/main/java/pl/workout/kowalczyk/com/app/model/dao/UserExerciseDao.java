package pl.workout.kowalczyk.com.app.model.dao;

import pl.workout.kowalczyk.com.app.model.entity.UserExercise;

import java.sql.Date;

/**
 * Created by JK on 2016-09-22.
 */
public interface UserExerciseDao extends BaseDao<UserExercise> {
    UserExercise getUserExerciseByUserId(int userId);

    UserExercise getByDate(Date date);


}
