package pl.workout.kowalczyk.com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.workout.kowalczyk.com.app.model.data.entity.Workout;
import pl.workout.kowalczyk.com.app.services.service.WorkoutService;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-31.
 */
@RestController
@RequestMapping("/workout")
public class WorkoutController {
    @Autowired
    private WorkoutService workoutService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveWorkout(@RequestBody Workout workout) {
        workoutService.saveWorkout(workout);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateWorkout(@RequestBody Workout workout) {
        workoutService.updateWorkout(workout);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteWorkout(@RequestBody Workout workout) {
        workoutService.deleteWorkout(workout);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public List<Workout> getWorkoutsById(@PathVariable int userId) {
        return workoutService.getWorkoutsByUserId(userId);
    }

    @RequestMapping(value = "/{userId}/{date}", method = RequestMethod.GET)
    public Workout getWorkoutByDate(@PathVariable int userId, @PathVariable Date date) {
        return workoutService.getByUserIdAndDate(userId, date);
    }
}
