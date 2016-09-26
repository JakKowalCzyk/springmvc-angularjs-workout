package pl.workout.kowalczyk.com.app.model.dao;

import pl.workout.kowalczyk.com.app.model.entity.UserExercise;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface UserExerciseDao extends BaseDao<UserExercise> {
    List<UserExercise> getUserExercisesByUserId(int userId);

    List<UserExercise> getByDate(int userId, Date date);

}
