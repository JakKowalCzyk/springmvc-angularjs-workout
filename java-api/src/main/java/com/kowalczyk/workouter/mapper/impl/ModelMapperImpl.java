package com.kowalczyk.workouter.mapper.impl;

import com.kowalczyk.workouter.mapper.ModelMapper;
import com.kowalczyk.workouter.model.BO.ModelObject;
import com.kowalczyk.workouter.model.DTO.ObjectDTO;
import com.kowalczyk.workouter.model.exception.NotFoundException;

/**
 * Created by JK on 2017-02-18.
 */
public abstract class ModelMapperImpl<T extends ModelObject, E extends ObjectDTO> implements ModelMapper<T, E> {

    protected abstract T buildBO(E objectDTO);

    protected abstract E buildDTO(T modelObject);

    @Override
    public T mapToBO(E objectDTO) {
        T modelObject = buildBO(objectDTO);
        modelObject.setId(objectDTO.getId());
        return modelObject;
    }

    @Override
    public E mapToDTO(T modelObject) {
        checkIdObjectExists(modelObject);
        E objectDTO = buildDTO(modelObject);
        objectDTO.setId(modelObject.getId());
        return objectDTO;
    }

    private void checkIdObjectExists(T modelObject) {
        if (modelObject == null) {
            throw new NotFoundException("Can't find object");
        }
    }
}
