package pl.workout.kowalczyk.com.app.services.exercise;

import pl.workout.kowalczyk.com.app.model.BO.exercise.Workout;
import pl.workout.kowalczyk.com.app.services.ModelService;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface WorkoutService extends ModelService<Workout> {

    List<Workout> getWorkoutsByUserId(Long userId);

    Workout getByUserIdAndDate(Long userId, Date date);

}
