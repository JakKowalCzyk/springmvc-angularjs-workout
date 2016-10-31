package pl.workout.kowalczyk.com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.workout.kowalczyk.com.app.model.data.entity.UserExercise;
import pl.workout.kowalczyk.com.app.services.service.UserExerciseService;

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
    public ResponseEntity saveUserExercise(@RequestBody UserExercise userExercise) {
        userExerciseService.saveUserExercise(userExercise);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateUserExercise(@RequestBody UserExercise userExercise) {
        userExerciseService.updateUserExercise(userExercise);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteUserExercise(@RequestBody UserExercise userExercise) {
        userExerciseService.deleteUserExercise(userExercise);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}/{date}", method = RequestMethod.GET)
    public List<UserExercise> getUserExercisesByWorkout(@PathVariable int userId, @PathVariable Date date) {
        return userExerciseService.getUserExercisesByWorkout(userId, date);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public List<UserExercise> getUserExerciseByWorkout(@PathVariable int userId){
        return userExerciseService.getUserExercisesByUserId(userId);
    }


}



