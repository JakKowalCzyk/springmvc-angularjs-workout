package com.kowalczyk.workouter.controllers.impl;

import com.kowalczyk.workouter.controllers.ModelController;
import com.kowalczyk.workouter.mapper.ModelMapper;
import com.kowalczyk.workouter.model.BO.ModelObject;
import com.kowalczyk.workouter.model.DTO.ObjectDTO;
import com.kowalczyk.workouter.services.ModelService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by JK on 2017-02-19.
 */
public abstract class ModelControllerImpl<E extends ModelObject, T extends ObjectDTO> implements ModelController<T> {

    private ModelService<E> modelService;
    private ModelMapper<E, T> modelMapper;

    public ModelControllerImpl(ModelService<E> modelService, ModelMapper<E, T> modelMapper) {
        super();
        this.modelService = modelService;
        this.modelMapper = modelMapper;
    }

    @Override
    public T getObject(@PathVariable Long id) {
        return modelMapper.mapToDTO(modelService.getObject(id));
    }

    @Override
    public T updateObject(@RequestBody T model) {
        return modelMapper.mapToDTO(modelService.updateObject(modelMapper.mapToBO(model)));
    }

    @Override
    public T addObject(@RequestBody T model) {
        return modelMapper.mapToDTO(modelService.addObject(modelMapper.mapToBO(model)));
    }

    @Override
    public List<T> findAll() {
        return modelService.getAll().stream().map(e -> modelMapper.mapToDTO(e)).collect(Collectors.toList());
    }

    @Override
    public void deleteObject(@PathVariable Long id) {
        modelService.deleteObject(id);
    }

    protected ModelService<E> getModelService() {
        return modelService;
    }

    protected ModelMapper<E, T> getModelMapper() {
        return modelMapper;
    }
}
