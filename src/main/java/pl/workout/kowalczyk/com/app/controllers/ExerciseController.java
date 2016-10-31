package pl.workout.kowalczyk.com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.model.data.entity.Exercise;
import pl.workout.kowalczyk.com.app.services.service.ExerciseService;

import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
@RestController
@RequestMapping(path = "/exercise")
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveExercise(@RequestBody Exercise exercise) {
        exerciseService.saveExercise(exercise);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Exercise> getAllExercises() {
        return exerciseService.getAllExercises();
    }

    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public Exercise getExerciseByName(@PathVariable String name) {
        return exerciseService.getExerciseByName(name);
    }

    @RequestMapping(path = "/{exerciseType}", method = RequestMethod.GET)
    public List<Exercise> getExercisesByType(@PathVariable ExerciseType exerciseType) {
        return exerciseService.getExercisesForBodyPart(exerciseType);
    }

}
