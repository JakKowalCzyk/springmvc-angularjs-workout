package com.kowalczyk.workouter.mapper.user.impl;

import com.kowalczyk.workouter.mapper.user.AbstractUserMapper;
import com.kowalczyk.workouter.model.BO.user.impl.UserInfo;
import com.kowalczyk.workouter.model.DTO.user.impl.UserInfoDTO;
import com.kowalczyk.workouter.services.exercise.ExerciseService;
import com.kowalczyk.workouter.services.user.UserWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        if (modelObject.getActualWeight() != null) {
            userInfoDTO.setActualWeightId(modelObject.getActualWeight().getId());
        }
        if (modelObject.getExerciseFavouriteId() != null) {
            userInfoDTO.setFavouriteExerciseId(modelObject.getExerciseFavouriteId().getId());
        }
        return userInfoDTO;
    }
}
