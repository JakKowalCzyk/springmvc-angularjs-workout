package com.kowalczyk.workouter.controllers.exercise.impl;

import com.kowalczyk.workouter.controllers.exercise.ExerciseController;
import com.kowalczyk.workouter.controllers.impl.ModelControllerImpl;
import com.kowalczyk.workouter.enums.ExerciseType;
import com.kowalczyk.workouter.mapper.exercise.ExerciseMapper;
import com.kowalczyk.workouter.model.BO.exercise.Exercise;
import com.kowalczyk.workouter.model.DTO.exercise.ExerciseDTO;
import com.kowalczyk.workouter.services.exercise.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public boolean isExist(@PathVariable Long id) {
        return super.isExist(id);
    }

    @Override
    public List<ExerciseDTO> searchExercise(@RequestParam String tag) {
        return (((ExerciseService) getModelService()).searchExercise(tag)).stream().map(exercise -> getModelMapper().mapToDTO(exercise)).collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDTO> getExercisesByType(@PathVariable ExerciseType exerciseType) {
        return ((ExerciseService) getModelService()).getExercisesForBodyPart(exerciseType).stream().map(exercise -> getModelMapper().mapToDTO(exercise)).collect(Collectors.toList());
    }

}
