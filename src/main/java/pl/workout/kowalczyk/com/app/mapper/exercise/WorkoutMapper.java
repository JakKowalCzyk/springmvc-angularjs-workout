package pl.workout.kowalczyk.com.app.mapper.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.workout.kowalczyk.com.app.mapper.impl.ModelMapperImpl;
import pl.workout.kowalczyk.com.app.model.BO.ModelObject;
import pl.workout.kowalczyk.com.app.model.BO.exercise.Workout;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.WorkoutDTO;
import pl.workout.kowalczyk.com.app.services.exercise.UserExerciseService;
import pl.workout.kowalczyk.com.app.services.security.UserDetailsService;

import java.util.stream.Collectors;

/**
 * Created by JK on 2017-02-18.
 */
@Component
public class WorkoutMapper extends ModelMapperImpl<Workout, WorkoutDTO> {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserExerciseService userExerciseService;

    @Override
    protected Workout buildBO(WorkoutDTO objectDTO) {
        Workout workout = new Workout();
        workout.setDate(objectDTO.getDate());
        workout.setUserId(userDetailsService.getObject(objectDTO.getUser_id()));
        workout.setUserExercises(objectDTO.getUserExercises().stream().map(aLong -> userExerciseService.getObject(aLong)).collect(Collectors.toList()));
        return workout;
    }

    @Override
    protected WorkoutDTO buildDTO(Workout modelObject) {
        WorkoutDTO workoutDTO = new WorkoutDTO();
        workoutDTO.setDate(modelObject.getDate());
        workoutDTO.setUser_id(modelObject.getUserId().getId());
        workoutDTO.setUserExercises(modelObject.getUserExercises().stream().map(ModelObject::getId).collect(Collectors.toList()));
        return workoutDTO;
    }
}
