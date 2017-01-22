package pl.workout.kowalczyk.com.app.controllers.exercise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.workout.kowalczyk.com.app.controllers.exercise.FavouriteExerciseController;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.ExerciseDTO;
import pl.workout.kowalczyk.com.app.services.exercise.FavouriteExerciseService;

/**
 * Created by JK on 2017-01-22.
 */
@RestController
public class FavouriteExerciseControllerImpl implements FavouriteExerciseController {

    @Autowired
    private FavouriteExerciseService favouriteExerciseService;

    @Override
    public void saveFavouriteExercise(@PathVariable int exerciseId) {
        int userId = 1;
        favouriteExerciseService.updateFavouriteExercise(userId, exerciseId);
    }

    @Override
    public void updateFavouriteExercise(@PathVariable int exerciseId) {
        int userId = 1;
        favouriteExerciseService.updateFavouriteExercise(userId, exerciseId);
    }

    @Override
    public ExerciseDTO getUserFavouriteExercise(@PathVariable int userId) {
        return favouriteExerciseService.getUserFavouriteExercise(userId);
    }

    @Override
    public void deleteFavouriteExercise(@PathVariable int userId) {
        favouriteExerciseService.deleteFavouriteExercise(userId);
    }
}
