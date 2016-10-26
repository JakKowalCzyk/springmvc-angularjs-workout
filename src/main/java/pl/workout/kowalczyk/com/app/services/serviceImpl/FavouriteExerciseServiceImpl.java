package pl.workout.kowalczyk.com.app.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.workout.kowalczyk.com.app.model.data.dao.BaseDao;
import pl.workout.kowalczyk.com.app.model.data.dao.UserInfoDao;
import pl.workout.kowalczyk.com.app.model.data.entity.FavouriteExercise;
import pl.workout.kowalczyk.com.app.services.service.FavouriteExerciseService;

/**
 * Created by JK on 2016-10-26.
 */
@Service
@Transactional
public class FavouriteExerciseServiceImpl implements FavouriteExerciseService{

    @Autowired
    private BaseDao<FavouriteExercise> favouriteExerciseBaseDao;

    @Autowired
    private UserInfoDao userInfoDao;

    public void saveFavouriteExercise(FavouriteExercise favouriteExercise) {
        favouriteExerciseBaseDao.save(favouriteExercise);
    }

    public void updateFavouriteExercise(FavouriteExercise favouriteExercise) {
        favouriteExerciseBaseDao.update(favouriteExercise);
    }

    public FavouriteExercise getUserFavouriteExercise(int userId) {
        return userInfoDao.getFavouriteExercise(userId);
    }

    public void deleteFavouriteExercise(FavouriteExercise favouriteExercise) {
        favouriteExerciseBaseDao.delete(favouriteExercise);
    }
}
