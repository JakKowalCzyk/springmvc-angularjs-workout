package com.kowalczyk.workouter.services.exercise;

import com.kowalczyk.workouter.model.BO.exercise.Workout;
import com.kowalczyk.workouter.services.ModelService;

import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface WorkoutService extends ModelService<Workout> {

    List<Workout> getWorkoutsByUserId(Long userId);

}
