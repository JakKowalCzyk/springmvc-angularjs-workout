package com.kowalczyk.workouter.dao.exercise;

import com.kowalczyk.workouter.dao.BaseDao;
import com.kowalczyk.workouter.model.BO.exercise.UserExercise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface UserExerciseDao extends BaseDao<UserExercise> {

    @Query("SELECT o FROM UserExercise o inner join o.workoutId as workout" +
            " inner join workout.user as user where user.id = :userId")
    List<UserExercise> getUserExercisesByUserId(@Param("userId") Long userId);

    @Query("select wor.userExercises from Workout wor where wor.id = :workoutId")
    List<UserExercise> findByWorkoutId(@Param("workoutId") Long workoutId);
}
