package pl.workout.kowalczyk.com.app.controllers.exercise;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.UserExerciseDTO;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2017-01-22.
 */
@Api(tags = {"User exercise API"}, description = "Services for users trained exercises")
@RequestMapping("/exercise/user")
public interface UserExerciseController {

    @ApiOperation(value = "Save new UserExercise")
    @RequestMapping(method = RequestMethod.POST)
    void saveUserExercise(@RequestBody UserExerciseDTO userExercise);

    @ApiOperation(value = "Update UserExercise")
    @RequestMapping(method = RequestMethod.PUT)
    void updateUserExercise(@RequestBody UserExerciseDTO userExercise);

    @ApiOperation(value = "Delete UserExercise")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{exerciseId}")
    void deleteUserExercise(@PathVariable Integer exerciseId);

    @ApiOperation(value = "Get List with UserExercises by Workout")
    @RequestMapping(value = "userId/{userId}/date/{date}", method = RequestMethod.GET)
    List<UserExerciseDTO> getUserExercisesByWorkout(@PathVariable int userId, @PathVariable Date date);

    @ApiOperation(value = "Get all UserExercises for user")
    @RequestMapping(value = "userId/{userId}", method = RequestMethod.GET)
    List<UserExerciseDTO> getUserExerciseByUserId(@PathVariable int userId);

}
