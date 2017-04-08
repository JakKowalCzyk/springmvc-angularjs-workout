package pl.workout.kowalczyk.com.app.controllers.exercise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.workout.kowalczyk.com.app.controllers.exercise.ExerciseController;
import pl.workout.kowalczyk.com.app.controllers.impl.ModelControllerImpl;
import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.mapper.exercise.ExerciseMapper;
import pl.workout.kowalczyk.com.app.model.BO.exercise.Exercise;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.ExerciseDTO;
import pl.workout.kowalczyk.com.app.services.exercise.ExerciseService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by JK on 2017-01-22.
 */
@RestController
public class ExerciseControllerImpl extends ModelControllerImpl<Exercise, ExerciseDTO> implements ExerciseController {

    @Autowired
    public ExerciseControllerImpl(ExerciseService modelService, ExerciseMapper modelMapper) {
        super(modelService, modelMapper);
    }

    @Override
    public ExerciseDTO getObject(@RequestParam Long id) {
        return super.getObject(id);
    }

    @Override
    public ExerciseDTO updateObject(@RequestBody ExerciseDTO model) {
        return super.updateObject(model);
    }

    @Override
    public ExerciseDTO addObject(@RequestBody ExerciseDTO model) {
        return super.addObject(model);
    }

    @Override
    public List<ExerciseDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteObject(@PathVariable Long id) {
        super.deleteObject(id);
    }

    @Override
    public ExerciseDTO getExerciseByName(@PathVariable String name) {
        return getModelMapper().mapToDTO(((ExerciseService) getModelService()).getExerciseByName(name));
    }

    @Override
    public List<ExerciseDTO> getExercisesByType(@PathVariable ExerciseType exerciseType) {
        return ((ExerciseService) getModelService()).getExercisesForBodyPart(exerciseType).stream().map(exercise -> getModelMapper().mapToDTO(exercise)).collect(Collectors.toList());
    }

}
