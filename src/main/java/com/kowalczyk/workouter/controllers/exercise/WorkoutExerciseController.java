package com.kowalczyk.workouter.controllers.exercise;

import com.kowalczyk.workouter.controllers.ModelController;
import com.kowalczyk.workouter.model.DTO.exercise.WorkoutExerciseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by JK on 2017-01-22.
 */
@Api(tags = {"User exercise API"}, description = "Services for users trained exercises")
public interface WorkoutExerciseController extends ModelController<WorkoutExerciseDTO> {

    String BASE_PATH = "/workout/exercise";

    @Override
    @RequestMapping(value = BASE_PATH + "/{id}", method = RequestMethod.GET)
    WorkoutExerciseDTO getObject(@PathVariable Long id);

    @Override
    @RequestMapping(value = BASE_PATH, method = RequestMethod.PUT)
    WorkoutExerciseDTO updateObject(@RequestBody WorkoutExerciseDTO model);

    @Override
    @RequestMapping(value = BASE_PATH, method = RequestMethod.POST)
    WorkoutExerciseDTO addObject(@RequestBody WorkoutExerciseDTO model);

    @Override
    @RequestMapping(value = BASE_PATH + "/", method = RequestMethod.GET)
    List<WorkoutExerciseDTO> findAll();

    @Override
    @RequestMapping(method = RequestMethod.DELETE, value = BASE_PATH + "/{id}")
    void deleteObject(@PathVariable Long id);

    @Override
    @RequestMapping(value = BASE_PATH + "/exist", method = RequestMethod.GET)
    boolean isExist(@PathVariable Long id);

    @ApiOperation(value = BASE_PATH + "Get all UserExercises for user")
    @RequestMapping(value = BASE_PATH + "user/{id}", method = RequestMethod.GET)
    List<WorkoutExerciseDTO> getWorkoutExerciseByUserId(@PathVariable Long id);

    @ApiOperation(value = BASE_PATH + "Get user exercises by workout")
    @RequestMapping(value = "workout/{id}/exercise", method = RequestMethod.GET)
    List<WorkoutExerciseDTO> getWorkoutExercisesByWorkout(@PathVariable Long id);

}
