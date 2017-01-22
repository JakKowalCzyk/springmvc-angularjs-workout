package pl.workout.kowalczyk.com.app.controllers.exercise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.workout.kowalczyk.com.app.controllers.exercise.WorkoutController;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.WorkoutDTO;
import pl.workout.kowalczyk.com.app.services.exercise.WorkoutService;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2017-01-22.
 */
@RestController
public class WorkoutControllerImpl implements WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @Override
    public void saveWorkout(@RequestBody WorkoutDTO workout) {
        workoutService.saveWorkout(workout);
    }

    @Override
    public void updateWorkout(@RequestBody WorkoutDTO workout) {
        workoutService.updateWorkout(workout);
    }

    @Override
    public void deleteWorkout(@PathVariable Integer workoutId) {
        workoutService.deleteWorkout(workoutId);
    }

    @Override
    public List<WorkoutDTO> getWorkoutsById(@PathVariable int userId) {
        return workoutService.getWorkoutsByUserId(userId);
    }

    @Override
    public WorkoutDTO getWorkoutByDate(@PathVariable int userId, @PathVariable Date date) {
        return workoutService.getByUserIdAndDate(userId, date);
    }
}
