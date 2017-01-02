package pl.workout.kowalczyk.com.app.dao.exercise;

import pl.workout.kowalczyk.com.app.dao.BaseDao;
import pl.workout.kowalczyk.com.app.model.BO.exercise.Workout;
import pl.workout.kowalczyk.com.app.model.BO.exercise.UserExercise;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface WorkoutDao extends BaseDao<Workout> {
    List<Workout> getWorkoutsByUserId(int userId);

    Workout getByUserIdAndDate(int userId, Date date);

    List<UserExercise> getUserExercisesByIdAndDate(int userId, Date date);
}
