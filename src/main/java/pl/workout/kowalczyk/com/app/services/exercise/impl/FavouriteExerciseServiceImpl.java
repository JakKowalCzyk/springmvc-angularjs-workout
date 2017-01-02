package pl.workout.kowalczyk.com.app.services.exercise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.workout.kowalczyk.com.app.dao.user.UserInfoDao;
import pl.workout.kowalczyk.com.app.model.BO.user.UserInfo;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.ExerciseDTO;
import pl.workout.kowalczyk.com.app.services.exercise.ExerciseService;
import pl.workout.kowalczyk.com.app.services.exercise.FavouriteExerciseService;
import pl.workout.kowalczyk.com.app.services.user.UserInfoService;

/**
 * Created by JK on 2016-10-26.
 */
@Service
@Transactional
public class FavouriteExerciseServiceImpl implements FavouriteExerciseService{

    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private ExerciseService exerciseService;

    public void updateFavouriteExercise(int userId, int exerciseId) {
        UserInfo userInfo = getUserInfo(userId);
        userInfo.setExerciseFavourite_id(exerciseService.getExerciseById(exerciseId));
        userInfoService.updateUserInfo(userInfo);
    }

    public ExerciseDTO getUserFavouriteExercise(int userId) {
        return exerciseService.mapExerciseBoToDTO(userInfoDao.getFavouriteExercise(userId));
    }

    public void deleteFavouriteExercise(int userId) {
        UserInfo userInfo = getUserInfo(userId);
        userInfo.setExerciseFavourite_id(null);
        userInfoService.updateUserInfo(userInfo);
    }

    public UserInfo getUserInfo(int userId) {
       return userInfoService.getUserInfoByUserId(userId);
    }


}
