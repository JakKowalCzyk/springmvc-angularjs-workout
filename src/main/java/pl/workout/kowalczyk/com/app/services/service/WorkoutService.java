package pl.workout.kowalczyk.com.app.services.service;

import pl.workout.kowalczyk.com.app.model.data.model.entity.Workout;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface WorkoutService {
    void saveWorkout(Workout workout);

    void updateWorkout(Workout workout);

    void deleteWorkout(Workout workout);

    List<Workout> getWorkoutsByUserId(int userId);

    Workout getByUserIdAndDate(int userId, Date date);

}
