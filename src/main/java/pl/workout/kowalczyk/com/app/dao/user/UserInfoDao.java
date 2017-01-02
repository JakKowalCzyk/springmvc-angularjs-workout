package pl.workout.kowalczyk.com.app.dao.user;

import org.springframework.stereotype.Repository;
import pl.workout.kowalczyk.com.app.dao.BaseDao;
import pl.workout.kowalczyk.com.app.model.BO.exercise.Exercise;
import pl.workout.kowalczyk.com.app.model.BO.user.UserInfo;
import pl.workout.kowalczyk.com.app.model.BO.user.UserWeight;

/**
 * Created by JK on 2016-09-22.
 */
@Repository
public interface UserInfoDao extends BaseDao<UserInfo> {
    UserInfo getUserInfoByUserId(int userId);

    UserWeight getActualWeight(int userId);

    Exercise getFavouriteExercise(int userId);
}
