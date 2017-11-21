package com.kowalczyk.workouter.mapper;

import com.kowalczyk.workouter.model.BO.ModelObject;
import com.kowalczyk.workouter.model.DTO.ObjectDTO;

/**
 * Created by JK on 2017-02-18.
 */
public interface ModelMapper<T extends ModelObject, E extends ObjectDTO> {

    T mapToBO(E objectDTO);

    E mapToDTO(T modelObject);
}
