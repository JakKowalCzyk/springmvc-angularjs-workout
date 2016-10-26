package pl.workout.kowalczyk.com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.model.data.entity.Exercise;
import pl.workout.kowalczyk.com.app.services.service.ExerciseService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
@RestController
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;

    @RequestMapping(path = "/exercise", method = RequestMethod.POST)
    public ResponseEntity saveExercise(@RequestBody Exercise exercise) {
        exerciseService.saveExercise(exercise);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/exercise", method = RequestMethod.GET)
    public List<Exercise> getAllExercises(){
        return exerciseService.getAllExercises();
    }

    @RequestMapping(path = "/exercise/{name}", method = RequestMethod.GET)
    public Exercise getExerciseByName(@PathVariable String name){
        return exerciseService.getExerciseByName(name);
    }

    @RequestMapping(path = "exercise/{exerciseType}", method = RequestMethod.GET)
    public List<Exercise> getExercisesByType(@PathVariable ExerciseType exerciseType){
        return exerciseService.getExercisesForBodyPart(exerciseType);
    }

}
