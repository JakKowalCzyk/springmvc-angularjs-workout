package pl.workout.kowalczyk.com.app.mapper;

import pl.workout.kowalczyk.com.app.model.BO.ModelObject;
import pl.workout.kowalczyk.com.app.model.DTO.ObjectDTO;

/**
 * Created by JK on 2017-02-18.
 */
public interface ModelMapper<T extends ModelObject, E extends ObjectDTO> {

    T mapToBO(E objectDTO);

    E mapToDTO(T modelObject);
}
