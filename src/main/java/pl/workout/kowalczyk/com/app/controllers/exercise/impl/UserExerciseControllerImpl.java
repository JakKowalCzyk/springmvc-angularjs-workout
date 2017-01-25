package pl.workout.kowalczyk.com.app.controllers.exercise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.workout.kowalczyk.com.app.controllers.exercise.UserExerciseController;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.UserExerciseDTO;
import pl.workout.kowalczyk.com.app.services.exercise.UserExerciseService;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2017-01-22.
 */
@RestController
public class UserExerciseControllerImpl implements UserExerciseController {

    @Autowired
    private UserExerciseService userExerciseService;

    @Override
    public void saveUserExercise(@RequestBody UserExerciseDTO userExercise) {
        userExerciseService.saveUserExercise(userExercise);
    }

    @Override
    public void updateUserExercise(@RequestBody UserExerciseDTO userExercise) {
        userExerciseService.updateUserExerciseWithRepeatAndSeries(userExercise);
    }

    @Override
    public void deleteUserExercise(@PathVariable Integer exerciseId) {
        userExerciseService.deleteUserExercise(exerciseId);
    }

    @Override
    public List<UserExerciseDTO> getUserExercisesByWorkoutDate(@PathVariable int userId, @PathVariable Date date) {
        return userExerciseService.getUserExercisesByWorkoutDate(userId, date);
    }

    @Override
    public List<UserExerciseDTO> getUserExerciseByUserId(@PathVariable int userId) {
        return userExerciseService.getUserExercisesByUserId(userId);
    }

    @Override
    public List<UserExerciseDTO> getUserExercisesByWorkout(@PathVariable int workoutId) {
        return userExerciseService.getUserExercisesBoWorkout(workoutId);
    }
}
