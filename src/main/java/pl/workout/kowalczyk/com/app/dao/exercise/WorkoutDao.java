package pl.workout.kowalczyk.com.app.dao.exercise;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.workout.kowalczyk.com.app.dao.BaseDao;
import pl.workout.kowalczyk.com.app.model.BO.exercise.Workout;
import pl.workout.kowalczyk.com.app.model.BO.exercise.UserExercise;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface WorkoutDao extends BaseDao<Workout> {

    @Query("SELECT o FROM Workout o inner join o.userId as user" +
            " where user.id = :userId")
    List<Workout> getWorkoutsByUserId(@Param("userId") int userId);

    @Query("SELECT o FROM Workout  o inner join o.userId as user where user.id = :userId and o.date = :date")
    Workout getByUserIdAndDate(@Param("userId") int userId, @Param("date") Date date);

    @Query("SELECT o FROM UserExercise o inner join o.workoutId as workout " +
            "inner join workout.userId as user " +
            "where user.id = :userId and workout.date = :date")
    List<UserExercise> getUserExercisesByIdAndDate(@Param("userId") int userId, @Param("date") Date date);
}
