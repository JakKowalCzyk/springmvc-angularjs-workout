package com.kowalczyk.workouter.dao.exercise;

import com.kowalczyk.workouter.dao.BaseDAO;
import com.kowalczyk.workouter.model.BO.exercise.WorkoutExercise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface WorkoutExerciseDAO extends BaseDAO<WorkoutExercise> {

    @Query("SELECT o FROM WorkoutExercise o inner join o.workout as workout inner join workout.user as user where user.id = :userId")
    List<WorkoutExercise> getUserExercisesByUserId(@Param("userId") Long userId);

    @Query("select wor.workoutExercises from Workout wor where wor.id = :workoutId")
    List<WorkoutExercise> findByWorkoutId(@Param("workoutId") Long workoutId);
}
