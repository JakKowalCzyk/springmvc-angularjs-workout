package pl.workout.kowalczyk.com.app.controllers.exercise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.workout.kowalczyk.com.app.controllers.exercise.UserExerciseController;
import pl.workout.kowalczyk.com.app.controllers.impl.ModelControllerImpl;
import pl.workout.kowalczyk.com.app.mapper.exercise.UserExerciseMapper;
import pl.workout.kowalczyk.com.app.model.BO.exercise.UserExercise;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.UserExerciseDTO;
import pl.workout.kowalczyk.com.app.services.exercise.UserExerciseService;

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
    public List<UserExerciseDTO> getUserExerciseByUserId(@PathVariable Long id) {
        return ((UserExerciseService) getModelService()).getUserExercisesByUserId(id).stream().map(userExercise -> getModelMapper().mapToDTO(userExercise)).collect(Collectors.toList());
    }

    @Override
    public List<UserExerciseDTO> getUserExercisesByWorkout(@PathVariable Long id) {
        return ((UserExerciseService) getModelService()).findByWorkoutId(id).stream().map(userExercise -> getModelMapper().mapToDTO(userExercise)).collect(Collectors.toList());
    }


}
