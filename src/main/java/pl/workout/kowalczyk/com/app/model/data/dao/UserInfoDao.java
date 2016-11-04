package pl.workout.kowalczyk.com.app.model.data.dao;

import org.springframework.stereotype.Repository;
import pl.workout.kowalczyk.com.app.model.data.entity.Exercise;
import pl.workout.kowalczyk.com.app.model.data.entity.UserInfo;
import pl.workout.kowalczyk.com.app.model.data.entity.UserWeight;

/**
 * Created by JK on 2016-09-22.
 */
@Repository
public interface UserInfoDao extends BaseDao<UserInfo> {
    UserInfo getUserInfoByUserId(int userId);

    UserWeight getActualWeight(int userId);

    Exercise getFavouriteExercise(int userId);
}
