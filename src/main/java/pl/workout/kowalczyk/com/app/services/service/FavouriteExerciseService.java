package pl.workout.kowalczyk.com.app.services.service;

import pl.workout.kowalczyk.com.app.model.BO.Exercise;

/**
 * Created by JK on 2016-10-26.
 */
public interface FavouriteExerciseService {

    void updateFavouriteExercise(int userId, int exerciseId);

    Exercise getUserFavouriteExercise(int userId);

    void deleteFavouriteExercise(int userId);
}
