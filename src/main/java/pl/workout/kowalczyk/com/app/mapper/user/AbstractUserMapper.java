package pl.workout.kowalczyk.com.app.mapper.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.workout.kowalczyk.com.app.mapper.impl.ModelMapperImpl;
import pl.workout.kowalczyk.com.app.model.BO.user.AbstractUserObject;
import pl.workout.kowalczyk.com.app.model.DTO.user.AbstractUserObjectDTO;
import pl.workout.kowalczyk.com.app.services.user.UserDetailsService;

/**
 * Created by JK on 2017-04-07.
 */
@Component
public abstract class AbstractUserMapper<T extends AbstractUserObject, E extends AbstractUserObjectDTO> extends ModelMapperImpl<T, E> {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected T buildBO(E objectDTO) {
        T userObject = buildUserObject(objectDTO);
        userObject.setUser(userDetailsService.getObject(objectDTO.getUserId()));
        return userObject;
    }

    protected abstract T buildUserObject(E objectDTO);

    @Override
    protected E buildDTO(T modelObject) {
        E userObjectDTO = buildUserDTOObject(modelObject);
        userObjectDTO.setUserId(modelObject.getUser().getId());
        return userObjectDTO;
    }

    protected abstract E buildUserDTOObject(T modelObject);
}
