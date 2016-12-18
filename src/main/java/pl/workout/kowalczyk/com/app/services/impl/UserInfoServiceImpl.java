package pl.workout.kowalczyk.com.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.workout.kowalczyk.com.app.dao.UserDao;
import pl.workout.kowalczyk.com.app.dao.UserInfoDao;
import pl.workout.kowalczyk.com.app.model.BO.UserInfo;
import pl.workout.kowalczyk.com.app.model.BO.UserWeight;
import pl.workout.kowalczyk.com.app.model.DTO.UserInfoDTO;
import pl.workout.kowalczyk.com.app.services.ExerciseService;
import pl.workout.kowalczyk.com.app.services.UserInfoService;
import pl.workout.kowalczyk.com.app.services.UserWeightService;

/**
 * Created by JK on 2016-10-26.
 */
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserWeightService userWeightService;

    @Autowired
    private ExerciseService exerciseService;

    @Override
    public UserInfoDTO mapUserInfoBoToDto(UserInfo userInfo) {
        return new UserInfoDTO(userInfo.getUserInfo_id(), userInfo.getUser_id().getUser_id(), userWeightService.mapUserWeightBoToDto(userInfo.getActual_weight()), exerciseService.mapExerciseBoToDTO(userInfo.getExerciseFavourite_id()));
    }

    @Override
    public UserInfo mapUserInfoDtoToBo(UserInfoDTO userInfoDTO) {
        UserInfo userInfo = new UserInfo(userInfoDTO.getUserInfoId());
        userInfo.setUser_id(userDao.get(userInfoDTO.getUserId()));
        userInfo.setExerciseFavourite_id(exerciseService.mapExerciseDtoToBo(userInfoDTO.getExerciseFavourite_id()));
        userInfo.setActual_weight(userWeightService.mapUserWeightDtoToBo(userInfoDTO.getActual_weight()));
        return userInfo;
    }

    public void saveUserInfo(UserInfoDTO userInfoDTO) {
        userInfoDao.save(mapUserInfoDtoToBo(userInfoDTO));
    }

    public void updateUserInfoDTO(UserInfoDTO userInfoDTO) {
        updateUserInfo(mapUserInfoDtoToBo(userInfoDTO));
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoDao.update(userInfo);
    }

    public UserInfoDTO getUserInfoDTOByUserId(int userId) {
        return mapUserInfoBoToDto(userInfoDao.getUserInfoByUserId(userId));
    }

    @Override
    public UserInfo getUserInfoByUserId(int userId) {
        return userInfoDao.getUserInfoByUserId(userId);
    }


    @Override
    public void updateUserInfoWithUserWeight(int userId, UserWeight userWeight) {
        UserInfo userInfo = getUserInfoByUserId(userId);
        userInfo.setActual_weight(userWeight);
        updateUserInfo(userInfo);
    }
}
