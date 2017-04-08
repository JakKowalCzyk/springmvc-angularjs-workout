package com.kowalczyk.workouter.services.exercise;

import com.kowalczyk.workouter.model.BO.exercise.UserExercise;
import com.kowalczyk.workouter.services.ModelService;

import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface UserExerciseService extends ModelService<UserExercise> {

    List<UserExercise> getUserExercisesByUserId(Long userId);

    List<UserExercise> findByWorkoutId(Long workoutId);
}
