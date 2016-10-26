package pl.workout.kowalczyk.com.app.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.workout.kowalczyk.com.app.model.data.model.dao.FavouriteExerciseDao;
import pl.workout.kowalczyk.com.app.model.data.model.dao.UserInfoDao;
import pl.workout.kowalczyk.com.app.model.data.model.entity.FavouriteExercise;
import pl.workout.kowalczyk.com.app.services.service.FavouriteExerciseService;

/**
 * Created by JK on 2016-10-26.
 */
@Service
@Transactional
public class FavouriteExerciseServiceImpl implements FavouriteExerciseService{

    @Autowired
    private FavouriteExerciseDao favouriteExerciseDao;

    @Autowired
    private UserInfoDao userInfoDao;

    public void saveFavouriteExercise(FavouriteExercise favouriteExercise) {
        favouriteExerciseDao.save(favouriteExercise);
    }

    public void updateFavouriteExercise(FavouriteExercise favouriteExercise) {
        favouriteExerciseDao.save(favouriteExercise);
    }

    public void getUserFavouriteExercise(int userId) {
        userInfoDao.getFavouriteExercise(userId);
    }

    public void deleteFavouriteExercise(FavouriteExercise favouriteExercise) {
        favouriteExerciseDao.delete(favouriteExercise);
    }
}
