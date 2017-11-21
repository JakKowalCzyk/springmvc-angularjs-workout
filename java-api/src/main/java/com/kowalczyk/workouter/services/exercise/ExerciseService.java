package com.kowalczyk.workouter.services.exercise;

import com.kowalczyk.workouter.enums.ExerciseType;
import com.kowalczyk.workouter.model.BO.exercise.Exercise;
import com.kowalczyk.workouter.services.ModelService;

import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface ExerciseService extends ModelService<Exercise> {

    List<Exercise> getExercisesForBodyPart(ExerciseType exerciseType);

    List<Exercise> searchExercise(String tag);
}
