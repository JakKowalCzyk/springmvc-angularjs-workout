package com.kowalczyk.workouter.services.exercise;

import com.kowalczyk.workouter.model.BO.exercise.WorkoutExercise;
import com.kowalczyk.workouter.services.ModelService;

import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface WorkoutExerciseService extends ModelService<WorkoutExercise> {

    List<WorkoutExercise> getWorkoutExercisesByUserId(Long userId);

    List<WorkoutExercise> findByWorkoutId(Long workoutId);
}
