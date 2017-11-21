package com.kowalczyk.workouter.mapper.user;

import com.kowalczyk.workouter.mapper.impl.ModelMapperImpl;
import com.kowalczyk.workouter.model.BO.user.AbstractUserObject;
import com.kowalczyk.workouter.model.DTO.user.AbstractUserObjectDTO;
import com.kowalczyk.workouter.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by JK on 2017-04-07.
 */
@Component
public abstract class AbstractUserMapper<T extends AbstractUserObject, E extends AbstractUserObjectDTO> extends ModelMapperImpl<T, E> {

    @Autowired
    private UserService userService;

    @Override
    protected T buildBO(E objectDTO) {
        T userObject = buildUserObject(objectDTO);
        userObject.setUser(userService.getObject(objectDTO.getUserId()));
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
