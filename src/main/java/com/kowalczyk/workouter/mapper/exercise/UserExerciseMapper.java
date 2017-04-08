package com.kowalczyk.workouter.mapper.exercise;

import com.kowalczyk.workouter.mapper.impl.ModelMapperImpl;
import com.kowalczyk.workouter.model.BO.exercise.UserExercise;
import com.kowalczyk.workouter.model.DTO.exercise.UserExerciseDTO;
import com.kowalczyk.workouter.services.exercise.ExerciseService;
import com.kowalczyk.workouter.services.exercise.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by JK on 2017-02-18.
 */
@Component
public class UserExerciseMapper extends ModelMapperImpl<UserExercise, UserExerciseDTO> {

    @Autowired
    private ExerciseService exerciseService;
    @Autowired
    private WorkoutService workoutService;

    @Override
    protected UserExercise buildBO(UserExerciseDTO objectDTO) {
        UserExercise userExercise = new UserExercise();
        userExercise.setExercise(exerciseService.getObject(objectDTO.getExerciseId()));
        userExercise.setWorkoutId(workoutService.getObject(objectDTO.getWorkoutId()));
        userExercise.setRepeat(objectDTO.getRepeat());
        userExercise.setSeries(objectDTO.getSeries());
        return userExercise;
    }

    @Override
    protected UserExerciseDTO buildDTO(UserExercise modelObject) {
        UserExerciseDTO userExerciseDTO = new UserExerciseDTO();
        userExerciseDTO.setExerciseId(modelObject.getExercise().getId());
        userExerciseDTO.setRepeat(modelObject.getRepeat());
        userExerciseDTO.setSeries(modelObject.getSeries());
        userExerciseDTO.setWorkoutId(modelObject.getWorkoutId().getId());
        return userExerciseDTO;
    }
}
