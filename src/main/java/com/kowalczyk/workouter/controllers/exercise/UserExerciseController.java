package com.kowalczyk.workouter.controllers.exercise;

import com.kowalczyk.workouter.controllers.ModelController;
import com.kowalczyk.workouter.model.DTO.exercise.UserExerciseDTO;
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
@RequestMapping("/user/exercise")
public interface UserExerciseController extends ModelController<UserExerciseDTO> {

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    UserExerciseDTO getObject(@PathVariable Long id);

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    UserExerciseDTO updateObject(@RequestBody UserExerciseDTO model);

    @Override
    @RequestMapping(method = RequestMethod.POST)
    UserExerciseDTO addObject(@RequestBody UserExerciseDTO model);

    @Override
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<UserExerciseDTO> findAll();

    @Override
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    void deleteObject(@PathVariable Long id);

    @ApiOperation(value = "Get all UserExercises for user")
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    List<UserExerciseDTO> getUserExerciseByUserId(@PathVariable Long id);

    @ApiOperation(value = "Get user exercises by workout")
    @RequestMapping(value = "workout/{id}", method = RequestMethod.GET)
    List<UserExerciseDTO> getUserExercisesByWorkout(@PathVariable Long id);

}
