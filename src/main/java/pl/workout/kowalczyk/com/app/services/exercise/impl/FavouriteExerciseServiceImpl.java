package pl.workout.kowalczyk.com.app.services.exercise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workout.kowalczyk.com.app.dao.user.UserInfoDao;
import pl.workout.kowalczyk.com.app.model.BO.exercise.Exercise;
import pl.workout.kowalczyk.com.app.model.BO.user.UserInfo;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.ExerciseDTO;
import pl.workout.kowalczyk.com.app.services.exercise.ExerciseService;
import pl.workout.kowalczyk.com.app.services.exercise.FavouriteExerciseService;
import pl.workout.kowalczyk.com.app.services.user.UserInfoService;

/**
 * Created by JK on 2016-10-26.
 */
@Service
public class FavouriteExerciseServiceImpl implements FavouriteExerciseService{

    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private ExerciseService exerciseService;

    public void updateFavouriteExercise(int userId, int exerciseId) {
        Exercise exercise = exerciseService.getExerciseById(exerciseId);
        userInfoDao.updateFavouriteExercise(userId, exercise);
    }

    public ExerciseDTO getUserFavouriteExercise(int userId) {
        return exerciseService.mapExerciseBoToDTO(userInfoDao.getFavouriteExercise(userId));
    }

    public void deleteFavouriteExercise(int userId) {
        userInfoDao.updateFavouriteExercise(userId, null);
    }

    public UserInfo getUserInfo(int userId) {
       return userInfoService.getUserInfoByUserId(userId);
    }

}
