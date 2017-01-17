package pl.workout.kowalczyk.com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.UserExerciseDTO;
import pl.workout.kowalczyk.com.app.services.exercise.UserExerciseService;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
@RestController
@RequestMapping(value = "/user/exercise")
public class UserExerciseController {
    @Autowired
    private UserExerciseService userExerciseService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveUserExercise(@RequestBody UserExerciseDTO userExercise) {
        userExerciseService.saveUserExercise(userExercise);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateUserExercise(@RequestBody UserExerciseDTO userExercise) {
        userExerciseService.updateUserExerciseWithRepeatAndSeries(userExercise);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{exerciseId}")
    public ResponseEntity deleteUserExercise(@PathVariable Integer exerciseId) {
        userExerciseService.deleteUserExercise(exerciseId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "userId/{userId}/date/{date}", method = RequestMethod.GET)
    public List<UserExerciseDTO> getUserExercisesByWorkout(@PathVariable int userId, @PathVariable Date date) {
        return userExerciseService.getUserExercisesByWorkout(userId, date);
    }

    @RequestMapping(value = "userId/{userId}", method = RequestMethod.GET)
    public List<UserExerciseDTO> getUserExerciseByUserId(@PathVariable int userId){
        return userExerciseService.getUserExercisesByUserId(userId);
    }


}



