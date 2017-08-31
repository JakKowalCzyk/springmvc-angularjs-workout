package com.kowalczyk.workouter.mapper.user.impl;

import com.kowalczyk.workouter.mapper.impl.ModelMapperImpl;
import com.kowalczyk.workouter.model.BO.user.impl.UserInfo;
import com.kowalczyk.workouter.model.DTO.user.impl.UserInfoDTO;
import com.kowalczyk.workouter.services.exercise.ExerciseService;
import com.kowalczyk.workouter.services.user.UserService;
import com.kowalczyk.workouter.services.user.UserWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by JK on 2017-02-18.
 */
@Component
public class UserInfoMapper extends ModelMapperImpl<UserInfo, UserInfoDTO> {

    @Autowired
    private UserWeightService userWeightService;
    @Autowired
    private ExerciseService exerciseService;
    @Autowired
    private UserService userService;

    @Override
    protected UserInfo buildBO(UserInfoDTO objectDTO) {
        UserInfo userInfo = new UserInfo();
        if (objectDTO.getActualWeightId() != null) {
            userInfo.setActualWeight(userWeightService.getObject(objectDTO.getActualWeightId()));
        }
        if (objectDTO.getFavouriteExerciseId() != null) {
            userInfo.setFavouriteExercise(exerciseService.getObject(objectDTO.getFavouriteExerciseId()));
        }
        userInfo.setUser(userService.getObject(objectDTO.getUserId()));
        return userInfo;
    }

    @Override
    protected UserInfoDTO buildDTO(UserInfo modelObject) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        if (modelObject.getActualWeight() != null) {
            userInfoDTO.setActualWeightId(modelObject.getActualWeight().getId());
        }
        if (modelObject.getFavouriteExercise() != null) {
            userInfoDTO.setFavouriteExerciseId(modelObject.getFavouriteExercise().getId());
        }
        userInfoDTO.setUserId(modelObject.getUser().getId());
        return userInfoDTO;
    }


}
