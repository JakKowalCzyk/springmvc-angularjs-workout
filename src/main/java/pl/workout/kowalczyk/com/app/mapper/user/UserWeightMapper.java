package pl.workout.kowalczyk.com.app.mapper.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.workout.kowalczyk.com.app.mapper.impl.ModelMapperImpl;
import pl.workout.kowalczyk.com.app.model.BO.user.UserWeight;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserWeightDTO;
import pl.workout.kowalczyk.com.app.services.user.UserDetailsService;

/**
 * Created by JK on 2017-02-18.
 */
@Component
public class UserWeightMapper extends ModelMapperImpl<UserWeight, UserWeightDTO> {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected UserWeight buildBO(UserWeightDTO objectDTO) {
        UserWeight userWeight = new UserWeight();
        userWeight.setDate(objectDTO.getDate());
        userWeight.setUserId(userDetailsService.getObject(objectDTO.getUserId()));
        userWeight.setWeightKg(objectDTO.getWeightKg());
        return userWeight;
    }

    @Override
    protected UserWeightDTO buildDTO(UserWeight modelObject) {
        UserWeightDTO userWeightDTO = new UserWeightDTO();
        userWeightDTO.setDate(modelObject.getDate());
        userWeightDTO.setUserId(modelObject.getUserId().getId());
        userWeightDTO.setWeightKg(modelObject.getWeightKg());
        return userWeightDTO;
    }
}
