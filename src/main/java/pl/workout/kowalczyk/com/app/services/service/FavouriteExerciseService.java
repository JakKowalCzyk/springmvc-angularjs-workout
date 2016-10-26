package pl.workout.kowalczyk.com.app.services.service;

import pl.workout.kowalczyk.com.app.model.data.entity.FavouriteExercise;

/**
 * Created by JK on 2016-10-26.
 */
public interface FavouriteExerciseService {
    void saveFavouriteExercise(FavouriteExercise favouriteExercise);

    void updateFavouriteExercise(FavouriteExercise favouriteExercise);

    FavouriteExercise getUserFavouriteExercise(int userId);

    void deleteFavouriteExercise(FavouriteExercise favouriteExercise);
}
