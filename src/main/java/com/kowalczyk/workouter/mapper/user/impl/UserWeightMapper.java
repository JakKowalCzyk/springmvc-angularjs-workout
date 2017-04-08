package com.kowalczyk.workouter.mapper.user.impl;

import com.kowalczyk.workouter.mapper.user.AbstractUserMapper;
import com.kowalczyk.workouter.model.BO.user.impl.UserWeight;
import com.kowalczyk.workouter.model.DTO.user.impl.UserWeightDTO;
import org.springframework.stereotype.Component;

/**
 * Created by JK on 2017-02-18.
 */
@Component
public class UserWeightMapper extends AbstractUserMapper<UserWeight, UserWeightDTO> {


    @Override
    protected UserWeight buildUserObject(UserWeightDTO objectDTO) {
        UserWeight userWeight = new UserWeight();
        userWeight.setDate(objectDTO.getDate());
        userWeight.setWeightKg(objectDTO.getWeightKg());
        return userWeight;
    }

    @Override
    protected UserWeightDTO buildUserDTOObject(UserWeight modelObject) {
        UserWeightDTO userWeightDTO = new UserWeightDTO();
        userWeightDTO.setDate(modelObject.getDate());
        userWeightDTO.setWeightKg(modelObject.getWeightKg());
        return userWeightDTO;
    }
}
