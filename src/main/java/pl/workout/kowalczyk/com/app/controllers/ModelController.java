package pl.workout.kowalczyk.com.app.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pl.workout.kowalczyk.com.app.model.DTO.ObjectDTO;

import java.util.List;

/**
 * Created by JK on 2017-02-19.
 */
public interface ModelController<T extends ObjectDTO> {

    @ApiOperation(value = "Get object by id")
    T getObject(@PathVariable Long id);

    @ApiOperation(value = "Update object")
    T updateObject(@RequestBody T model);

    @ApiOperation(value = "Add new object")
    T addObject(@RequestBody T model);

    @ApiOperation(value = "Find all")
    List<T> findAll();

    @ApiOperation(value = "Delete object by id")
    void deleteObject(@PathVariable Long id);
}
