package pl.workout.kowalczyk.com.app.controllers.exercise;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.ExerciseDTO;

/**
 * Created by JK on 2017-01-22.
 */
@Api(tags = {"Favourite exercise API"}, description = "Services for favourite exercises")
@RequestMapping("/exercise/favourite")
public interface FavouriteExerciseController {

    @ApiOperation(value = "Save new favourite exercise")
    @RequestMapping(path = "/{exerciseId}", method = RequestMethod.POST)
    void saveFavouriteExercise(@PathVariable int exerciseId);

    @ApiOperation(value = "Update existing favourite exercise with new one")
    @RequestMapping(path = "/{exerciseId}", method = RequestMethod.PUT)
    void updateFavouriteExercise(@PathVariable int exerciseId);

    @ApiOperation(value = "Get favourite exercise for user")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    ExerciseDTO getUserFavouriteExercise(@PathVariable int userId);

    @ApiOperation(value = "Delete favourite exercise")
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    void deleteFavouriteExercise(@PathVariable int userId);
}
