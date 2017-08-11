package com.kowalczyk.workouter.controllers.exercise;

import com.kowalczyk.workouter.controllers.ModelController;
import com.kowalczyk.workouter.enums.ExerciseType;
import com.kowalczyk.workouter.model.DTO.exercise.ExerciseDTO;
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
@Api(tags = {"Exercise API "}, description = "Services for exercises")
@RequestMapping("/api/exercise")
public interface ExerciseController extends ModelController<ExerciseDTO> {

    @Override
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    ExerciseDTO getObject(@PathVariable Long id);

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    ExerciseDTO updateObject(@RequestBody ExerciseDTO model);

    @Override
    @RequestMapping(method = RequestMethod.POST)
    ExerciseDTO addObject(@RequestBody ExerciseDTO model);

    @Override
    @RequestMapping(path = "/", method = RequestMethod.GET)
    List<ExerciseDTO> findAll();

    @Override
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    void deleteObject(@PathVariable Long id);

    @ApiOperation(value = "Get exercise by name")
    @RequestMapping(path = "/name/{name}", method = RequestMethod.GET)
    ExerciseDTO getExerciseByName(@PathVariable String name);

    @ApiOperation(value = "Get exercise by type")
    @RequestMapping(path = "/type/{exerciseType}", method = RequestMethod.GET)
    List<ExerciseDTO> getExercisesByType(@PathVariable ExerciseType exerciseType);

}
