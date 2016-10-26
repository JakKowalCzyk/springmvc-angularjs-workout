package pl.workout.kowalczyk.com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.workout.kowalczyk.com.app.model.data.entity.FavouriteExercise;
import pl.workout.kowalczyk.com.app.services.service.FavouriteExerciseService;

/**
 * Created by JK on 2016-10-26.
 */
@RestController
public class FavouriteExerciseController {
    @Autowired
    private FavouriteExerciseService favouriteExerciseService;

    @RequestMapping(path = "/favouriteExercise", method = RequestMethod.POST)
    public ResponseEntity saveFavouriteExercise(@RequestBody FavouriteExercise favouriteExercise) {
        favouriteExerciseService.saveFavouriteExercise(favouriteExercise);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/favouriteExercise", method = RequestMethod.PUT)
    public ResponseEntity updateFavouriteExercise(@RequestBody FavouriteExercise favouriteExercise) {
        favouriteExerciseService.updateFavouriteExercise(favouriteExercise);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/favouriteExercise/{userId}", method = RequestMethod.GET)
    public FavouriteExercise getUserFavouriteExercise(@PathVariable int userId){
        return favouriteExerciseService.getUserFavouriteExercise(userId);
    }

    @RequestMapping(value = "/favouriteExercise", method = RequestMethod.DELETE)
    public ResponseEntity deleteFavouriteExercise(@RequestBody FavouriteExercise favouriteExercise) {
        favouriteExerciseService.deleteFavouriteExercise(favouriteExercise);
        return new ResponseEntity(HttpStatus.OK);
    }
}
