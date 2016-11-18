package pl.workout.kowalczyk.com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.workout.kowalczyk.com.app.model.BO.Exercise;
import pl.workout.kowalczyk.com.app.services.service.FavouriteExerciseService;

/**
 * Created by JK on 2016-10-26.
 */
@RestController
@RequestMapping(path = "/exercise/favourite")
public class FavouriteExerciseController {
    @Autowired
    private FavouriteExerciseService favouriteExerciseService;

    @RequestMapping(path = "/{exerciseId}", method = RequestMethod.POST)
    public ResponseEntity saveFavouriteExercise(@PathVariable int exerciseId) {
        int userId = 1;
        favouriteExerciseService.updateFavouriteExercise(userId, exerciseId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/{exerciseId}", method = RequestMethod.PUT)
    public ResponseEntity updateFavouriteExercise(@PathVariable int exerciseId) {
        int userId = 1;
        favouriteExerciseService.updateFavouriteExercise(userId, exerciseId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public Exercise getUserFavouriteExercise(@PathVariable int userId){
        return favouriteExerciseService.getUserFavouriteExercise(userId);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteFavouriteExercise(@PathVariable int userId) {
        favouriteExerciseService.deleteFavouriteExercise(userId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
