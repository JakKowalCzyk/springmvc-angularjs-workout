package pl.workout.kowalczyk.com.app.services;

import pl.workout.kowalczyk.com.app.model.BO.Workout;
import pl.workout.kowalczyk.com.app.model.DTO.WorkoutDTO;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface WorkoutService {

    Workout mapWorkoutDtoToBo(WorkoutDTO workoutDTO);

    WorkoutDTO mapWorkoutBoToDto(Workout workout);

    void saveWorkout(WorkoutDTO workoutDTO);

    void updateWorkout(WorkoutDTO workoutDTO);

    void deleteWorkout(Integer workoutId);

    List<WorkoutDTO> getWorkoutsByUserId(int userId);

    WorkoutDTO getByUserIdAndDate(int userId, Date date);

}
