package com.kowalczyk.workouter.mapper.exercise;

import com.kowalczyk.workouter.mapper.impl.ModelMapperImpl;
import com.kowalczyk.workouter.model.BO.exercise.WorkoutExercise;
import com.kowalczyk.workouter.model.DTO.exercise.WorkoutExerciseDTO;
import com.kowalczyk.workouter.services.exercise.ExerciseService;
import com.kowalczyk.workouter.services.exercise.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by JK on 2017-02-18.
 */
@Component
public class UserExerciseMapper extends ModelMapperImpl<WorkoutExercise, WorkoutExerciseDTO> {

    @Autowired
    private ExerciseService exerciseService;
    @Autowired
    private WorkoutService workoutService;

    @Override
    protected WorkoutExercise buildBO(WorkoutExerciseDTO objectDTO) {
        WorkoutExercise workoutExercise = new WorkoutExercise();
        workoutExercise.setExercise(exerciseService.getObject(objectDTO.getExerciseId()));
        workoutExercise.setWorkout(workoutService.getObject(objectDTO.getWorkoutId()));
        workoutExercise.setRepeat(objectDTO.getRepeat());
        workoutExercise.setSeries(objectDTO.getSeries());
        return workoutExercise;
    }

    @Override
    protected WorkoutExerciseDTO buildDTO(WorkoutExercise modelObject) {
        WorkoutExerciseDTO workoutExerciseDTO = new WorkoutExerciseDTO();
        workoutExerciseDTO.setExerciseId(modelObject.getExercise().getId());
        workoutExerciseDTO.setRepeat(modelObject.getRepeat());
        workoutExerciseDTO.setSeries(modelObject.getSeries());
        workoutExerciseDTO.setWorkoutId(modelObject.getWorkout().getId());
        return workoutExerciseDTO;
    }
}
