package pl.workout.kowalczyk.com.app.model.data.model.dao;

import pl.workout.kowalczyk.com.app.model.data.model.entity.FavouriteExercise;
import pl.workout.kowalczyk.com.app.model.data.model.entity.UserInfo;
import pl.workout.kowalczyk.com.app.model.data.model.entity.UserWeight;

/**
 * Created by JK on 2016-09-22.
 */
public interface UserInfoDao extends BaseDao<UserInfo> {
    UserInfo getUserInfoByUserId(int userId);

    UserWeight getActualWeight(int userId);

    FavouriteExercise getFavouriteExercise(int userId);
}
