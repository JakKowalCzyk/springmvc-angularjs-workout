package com.kowalczyk.workouter.dao.exercise;

import com.kowalczyk.workouter.dao.BaseDao;
import com.kowalczyk.workouter.model.BO.exercise.UserExercise;
import com.kowalczyk.workouter.model.BO.exercise.Workout;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface WorkoutDao extends BaseDao<Workout> {

    @Query("SELECT o FROM Workout o inner join o.user as user" +
            " where user.id = :userId")
    List<Workout> getWorkoutsByUserId(@Param("userId") Long userId);

    @Query("SELECT o FROM Workout  o inner join o.user as user where user.id = :userId and o.date = :date")
    Workout getByUserIdAndDate(@Param("userId") Long userId, @Param("date") Date date);

    @Query("SELECT o FROM UserExercise o inner join o.workoutId as workout " +
            "inner join workout.user as user " +
            "where user.id = :userId and workout.date = :date")
    List<UserExercise> getUserExercisesByIdAndDate(@Param("userId") Long userId, @Param("date") Date date);
}
