package pl.workout.kowalczyk.com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.model.DTO.ExerciseDTO;
import pl.workout.kowalczyk.com.app.services.ExerciseService;

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
    public ResponseEntity saveExercise(@RequestBody ExerciseDTO exercise) {
        exerciseService.saveExercise(exercise);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ExerciseDTO> getAllExercises() {
        return exerciseService.getAllExercisesDTO();
    }

    @RequestMapping(path = "/name/{name}", method = RequestMethod.GET)
    public ExerciseDTO getExerciseByName(@PathVariable String name) {
        return exerciseService.getExerciseDTOByName(name);
    }

    @RequestMapping(path = "/type/{exerciseType}", method = RequestMethod.GET)
    public List<ExerciseDTO> getExercisesByType(@PathVariable ExerciseType exerciseType) {
        return exerciseService.getExercisesDTOForBodyPart(exerciseType);
    }

}
