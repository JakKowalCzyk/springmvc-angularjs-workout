package pl.workout.kowalczyk.com.app.controllers.exercise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.workout.kowalczyk.com.app.controllers.exercise.WorkoutController;
import pl.workout.kowalczyk.com.app.controllers.impl.ModelControllerImpl;
import pl.workout.kowalczyk.com.app.mapper.exercise.WorkoutMapper;
import pl.workout.kowalczyk.com.app.model.BO.exercise.Workout;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.WorkoutDTO;
import pl.workout.kowalczyk.com.app.services.exercise.WorkoutService;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by JK on 2017-01-22.
 */
@RestController
public class WorkoutControllerImpl extends ModelControllerImpl<Workout, WorkoutDTO> implements WorkoutController {

    @Autowired
    public WorkoutControllerImpl(WorkoutService modelService, WorkoutMapper modelMapper) {
        super(modelService, modelMapper);
    }

    @Override
    public WorkoutDTO getObject(@PathVariable Long id) {
        return super.getObject(id);
    }

    @Override
    public WorkoutDTO updateObject(@RequestBody WorkoutDTO model) {
        return super.updateObject(model);
    }

    @Override
    public WorkoutDTO addObject(@RequestBody WorkoutDTO model) {
        return super.addObject(model);
    }

    @Override
    public List<WorkoutDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteObject(@PathVariable Long id) {
        super.deleteObject(id);
    }

    @Override
    public List<WorkoutDTO> getWorkoutsByUser(@PathVariable Long id) {
        return ((WorkoutService) getModelService()).getWorkoutsByUserId(id).stream().map(workout -> getModelMapper().mapToDTO(workout)).collect(Collectors.toList());
    }

    @Override
    public WorkoutDTO getWorkoutByDate(@PathVariable Long id, @PathVariable Date date) {
        return getModelMapper().mapToDTO(((WorkoutService) getModelService()).getByUserIdAndDate(id, date));
    }
}
