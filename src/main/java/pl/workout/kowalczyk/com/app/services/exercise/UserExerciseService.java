package pl.workout.kowalczyk.com.app.services.exercise;

import pl.workout.kowalczyk.com.app.model.BO.exercise.UserExercise;
import pl.workout.kowalczyk.com.app.services.ModelService;

import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface UserExerciseService extends ModelService<UserExercise> {

    List<UserExercise> getUserExercisesByUserId(Long userId);

    List<UserExercise> findByWorkoutId(Long workoutId);
}
