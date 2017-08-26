package com.kowalczyk.workouter.controllers.exercise.impl;

import com.kowalczyk.workouter.controllers.exercise.WorkoutExerciseController;
import com.kowalczyk.workouter.controllers.impl.ModelControllerImpl;
import com.kowalczyk.workouter.mapper.exercise.WorkoutExerciseMapper;
import com.kowalczyk.workouter.model.BO.exercise.WorkoutExercise;
import com.kowalczyk.workouter.model.DTO.exercise.WorkoutExerciseDTO;
import com.kowalczyk.workouter.services.exercise.WorkoutExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by JK on 2017-01-22.
 */
@RestController
public class WorkoutExerciseControllerImpl extends ModelControllerImpl<WorkoutExercise, WorkoutExerciseDTO> implements WorkoutExerciseController {

    @Autowired
    public WorkoutExerciseControllerImpl(WorkoutExerciseService modelService, WorkoutExerciseMapper modelMapper) {
        super(modelService, modelMapper);
    }

    @Override
    public WorkoutExerciseDTO getObject(@PathVariable Long id) {
        return super.getObject(id);
    }

    @Override
    public WorkoutExerciseDTO updateObject(@RequestBody WorkoutExerciseDTO model) {
        return super.updateObject(model);
    }

    @Override
    public WorkoutExerciseDTO addObject(@RequestBody WorkoutExerciseDTO model) {
        return super.addObject(model);
    }

    @Override
    public List<WorkoutExerciseDTO> findAll() {
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
    public List<WorkoutExerciseDTO> getWorkoutExerciseByUserId(@PathVariable Long id) {
        return ((WorkoutExerciseService) getModelService()).getWorkoutExercisesByUserId(id).stream().map(userExercise -> getModelMapper().mapToDTO(userExercise)).collect(Collectors.toList());
    }

    @Override
    public List<WorkoutExerciseDTO> getWorkoutExercisesByWorkout(@PathVariable Long id) {
        return ((WorkoutExerciseService) getModelService()).findByWorkoutId(id).stream().map(userExercise -> getModelMapper().mapToDTO(userExercise)).collect(Collectors.toList());
    }


}
