package pl.workout.kowalczyk.com.app.mapper.user.impl;

import org.springframework.stereotype.Component;
import pl.workout.kowalczyk.com.app.mapper.user.AbstractUserMapper;
import pl.workout.kowalczyk.com.app.model.BO.user.impl.UserWeight;
import pl.workout.kowalczyk.com.app.model.DTO.user.impl.UserWeightDTO;

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
