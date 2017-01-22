package pl.workout.kowalczyk.com.app.controllers.exercise;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.WorkoutDTO;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2017-01-22.
 */
@Api(tags = {"Workout API"}, description = "Services for workouts")
@RequestMapping("/exercise/workout")
public interface WorkoutController {

    @ApiOperation(value = "Save new workout")
    @RequestMapping(method = RequestMethod.POST)
    void saveWorkout(@RequestBody WorkoutDTO workout);

    @ApiOperation(value = "Update existing workout")
    @RequestMapping(method = RequestMethod.PUT)
    void updateWorkout(@RequestBody WorkoutDTO workout);

    @ApiOperation(value = "Delete workout")
    @RequestMapping(value = "/workoutId/{workoutId}", method = RequestMethod.DELETE)
    void deleteWorkout(@PathVariable Integer workoutId);

    @ApiOperation(value = "Get workout for user")
    @RequestMapping(value = "user/{userId}", method = RequestMethod.GET)
    List<WorkoutDTO> getWorkoutsById(@PathVariable int userId);

    @ApiOperation(value = "Get workout by date for user")
    @RequestMapping(value = "user/{userId}/date/{date}", method = RequestMethod.GET)
    WorkoutDTO getWorkoutByDate(@PathVariable int userId, @PathVariable Date date);
}
