package pl.workout.kowalczyk.com.app.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.workout.kowalczyk.com.app.model.data.dao.UserInfoDao;
import pl.workout.kowalczyk.com.app.model.data.entity.Exercise;
import pl.workout.kowalczyk.com.app.model.data.entity.UserInfo;
import pl.workout.kowalczyk.com.app.services.service.ExerciseService;
import pl.workout.kowalczyk.com.app.services.service.FavouriteExerciseService;
import pl.workout.kowalczyk.com.app.services.service.UserInfoService;

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

    public Exercise getUserFavouriteExercise(int userId) {
        return userInfoDao.getFavouriteExercise(userId);
    }

    public void deleteFavouriteExercise(int userId) {
        updateFavouriteExercise(userId, -1);
    }

    public UserInfo getUserInfo(int userId) {
       return userInfoService.getUserInfoByUserId(userId);
    }

}
