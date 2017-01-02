package pl.workout.kowalczyk.com.app.services.exercise;

import pl.workout.kowalczyk.com.app.model.BO.exercise.UserExercise;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.UserExerciseDTO;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface UserExerciseService {

    UserExercise mapUserExerciseDtoToBo(UserExerciseDTO userExerciseDTO);

    UserExerciseDTO mapUserExerciseBoToDto(UserExercise userExercise);

    void saveUserExercise(UserExerciseDTO userExercise);

    void updateUserExercise(UserExerciseDTO userExercise);

    void deleteUserExercise(Integer userExercise);

    List<UserExerciseDTO> getUserExercisesByWorkout(int userId, Date date);

    List<UserExerciseDTO> getUserExercisesByUserId(int userId);
}
