package pl.workout.kowalczyk.com.app.mapper.impl;

import pl.workout.kowalczyk.com.app.mapper.ModelMapper;
import pl.workout.kowalczyk.com.app.model.BO.ModelObject;
import pl.workout.kowalczyk.com.app.model.DTO.ObjectDTO;

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
        E objectDTO = buildDTO(modelObject);
        objectDTO.setId(modelObject.getId());
        return objectDTO;
    }
}
