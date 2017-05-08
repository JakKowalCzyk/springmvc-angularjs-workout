package com.kowalczyk.workouter.controllers.exercise;

import com.kowalczyk.workouter.controllers.ModelController;
import com.kowalczyk.workouter.model.DTO.exercise.WorkoutDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2017-01-22.
 */
@Api(tags = {"Workout API"}, description = "Services for workouts")
@RequestMapping("/workout")
public interface WorkoutController extends ModelController<WorkoutDTO> {

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    WorkoutDTO getObject(@PathVariable Long id);

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    WorkoutDTO updateObject(@RequestBody WorkoutDTO model);

    @Override
    @RequestMapping(method = RequestMethod.POST)
    WorkoutDTO addObject(@RequestBody WorkoutDTO model);

    @Override
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<WorkoutDTO> findAll();

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteObject(@PathVariable Long id);

    @Override
    @RequestMapping(value = "/exist", method = RequestMethod.GET)
    boolean isExist(@PathVariable Long id);

    @ApiOperation(value = "Get workout for user")
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    List<WorkoutDTO> getWorkoutsByUser(@PathVariable Long id);

    @ApiOperation(value = "Get workout by date for user")
    @RequestMapping(value = "user/{id}/date/{date}", method = RequestMethod.GET)
    WorkoutDTO getWorkoutByDate(@PathVariable Long id, @PathVariable Date date);
}
