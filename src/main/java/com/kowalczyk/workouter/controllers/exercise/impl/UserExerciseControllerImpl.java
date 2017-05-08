package com.kowalczyk.workouter.controllers.exercise.impl;

import com.kowalczyk.workouter.controllers.exercise.UserExerciseController;
import com.kowalczyk.workouter.controllers.impl.ModelControllerImpl;
import com.kowalczyk.workouter.mapper.exercise.UserExerciseMapper;
import com.kowalczyk.workouter.model.BO.exercise.UserExercise;
import com.kowalczyk.workouter.model.DTO.exercise.UserExerciseDTO;
import com.kowalczyk.workouter.services.exercise.UserExerciseService;
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
public class UserExerciseControllerImpl extends ModelControllerImpl<UserExercise, UserExerciseDTO> implements UserExerciseController {

    @Autowired
    public UserExerciseControllerImpl(UserExerciseService modelService, UserExerciseMapper modelMapper) {
        super(modelService, modelMapper);
    }

    @Override
    public UserExerciseDTO getObject(@PathVariable Long id) {
        return super.getObject(id);
    }

    @Override
    public UserExerciseDTO updateObject(@RequestBody UserExerciseDTO model) {
        return super.updateObject(model);
    }

    @Override
    public UserExerciseDTO addObject(@RequestBody UserExerciseDTO model) {
        return super.addObject(model);
    }

    @Override
    public List<UserExerciseDTO> findAll() {
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
    public List<UserExerciseDTO> getUserExerciseByUserId(@PathVariable Long id) {
        return ((UserExerciseService) getModelService()).getUserExercisesByUserId(id).stream().map(userExercise -> getModelMapper().mapToDTO(userExercise)).collect(Collectors.toList());
    }

    @Override
    public List<UserExerciseDTO> getUserExercisesByWorkout(@PathVariable Long id) {
        return ((UserExerciseService) getModelService()).findByWorkoutId(id).stream().map(userExercise -> getModelMapper().mapToDTO(userExercise)).collect(Collectors.toList());
    }


}
