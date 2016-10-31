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
@RequestMapping(path = "/exercise/favourite")
public class FavouriteExerciseController {
    @Autowired
    private FavouriteExerciseService favouriteExerciseService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveFavouriteExercise(@RequestBody FavouriteExercise favouriteExercise) {
        favouriteExerciseService.saveFavouriteExercise(favouriteExercise);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateFavouriteExercise(@RequestBody FavouriteExercise favouriteExercise) {
        favouriteExerciseService.updateFavouriteExercise(favouriteExercise);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public FavouriteExercise getUserFavouriteExercise(@PathVariable int userId){
        return favouriteExerciseService.getUserFavouriteExercise(userId);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteFavouriteExercise(@RequestBody FavouriteExercise favouriteExercise) {
        favouriteExerciseService.deleteFavouriteExercise(favouriteExercise);
        return new ResponseEntity(HttpStatus.OK);
    }
}
