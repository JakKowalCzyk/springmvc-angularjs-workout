package pl.workout.kowalczyk.com.app.services.service;

import pl.workout.kowalczyk.com.app.model.BO.UserExercise;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface UserExerciseService {
    void saveUserExercise(UserExercise userExercise);

    void updateUserExercise(UserExercise userExercise);

    void deleteUserExercise(UserExercise userExercise);

    List<UserExercise> getUserExercisesByWorkout(int userId, Date date);

    List<UserExercise> getUserExercisesByUserId(int userId);
}
