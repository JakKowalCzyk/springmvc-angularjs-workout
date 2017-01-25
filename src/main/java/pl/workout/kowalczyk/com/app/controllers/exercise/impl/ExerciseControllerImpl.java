package pl.workout.kowalczyk.com.app.controllers.exercise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.workout.kowalczyk.com.app.controllers.exercise.ExerciseController;
import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.ExerciseDTO;
import pl.workout.kowalczyk.com.app.services.exercise.ExerciseService;

import java.util.List;

/**
 * Created by JK on 2017-01-22.
 */
@RestController
public class ExerciseControllerImpl implements ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @Override
    public void saveExercise(@RequestBody ExerciseDTO exercise) {
        exerciseService.saveExercise(exercise);
    }

    @Override
    public List<ExerciseDTO> getAllExercises() {
        return exerciseService.getAllExercisesDTO();
    }

    @Override
    public ExerciseDTO getExerciseByName(@PathVariable String name) {
        return exerciseService.getExerciseDTOByName(name);
    }

    @Override
    public List<ExerciseDTO> getExercisesByType(@PathVariable ExerciseType exerciseType) {
        return exerciseService.getExercisesDTOForBodyPart(exerciseType);
    }

    @Override
    public ExerciseDTO getExerciseById(@PathVariable Integer exerciseId) {
        return exerciseService.getExerciseDTOById(exerciseId);
    }
}
