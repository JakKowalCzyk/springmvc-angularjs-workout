package pl.workout.kowalczyk.com.app.services.exercise;

import pl.workout.kowalczyk.com.app.model.DTO.exercise.ExerciseDTO;

/**
 * Created by JK on 2016-10-26.
 */
public interface FavouriteExerciseService {

    void updateFavouriteExercise(int userId, int exerciseId);

    ExerciseDTO getUserFavouriteExercise(int userId);

    void deleteFavouriteExercise(int userId);
}
