package pl.workout.kowalczyk.com.app.mapper.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.workout.kowalczyk.com.app.mapper.user.AbstractUserMapper;
import pl.workout.kowalczyk.com.app.model.BO.user.impl.UserInfo;
import pl.workout.kowalczyk.com.app.model.DTO.user.impl.UserInfoDTO;
import pl.workout.kowalczyk.com.app.services.exercise.ExerciseService;
import pl.workout.kowalczyk.com.app.services.user.UserWeightService;

/**
 * Created by JK on 2017-02-18.
 */
@Component
public class UserInfoMapper extends AbstractUserMapper<UserInfo, UserInfoDTO> {

    @Autowired
    private UserWeightService userWeightService;
    @Autowired
    private ExerciseService exerciseService;

    @Override
    protected UserInfo buildUserObject(UserInfoDTO objectDTO) {
        UserInfo userInfo = new UserInfo();
        userInfo.setActualWeight(userWeightService.getObject(objectDTO.getActualWeightId()));
        userInfo.setExerciseFavouriteId(exerciseService.getObject(objectDTO.getFavouriteExerciseId()));
        return userInfo;
    }

    @Override
    protected UserInfoDTO buildUserDTOObject(UserInfo modelObject) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setActualWeightId(modelObject.getActualWeight().getId());
        userInfoDTO.setFavouriteExerciseId(modelObject.getExerciseFavouriteId().getId());
        return userInfoDTO;
    }
}
