package pl.workout.kowalczyk.com.app.dao.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("SELECT o FROM UserInfo o " +
            "inner join o.user_id as user " +
            "where user.id = :userId")
    UserInfo getUserInfoByUserId(@Param("userId") int userId);

    @Query("select o FROM UserWeight o inner join o.userInfo_id as ui " +
            "inner join ui.user_id as user " +
            "where user.id = :userId")
    UserWeight getActualWeight(@Param("userId") int userId);

    @Query("select o FROM Exercise o inner join o.userInfo_id as userInfo " +
            "inner join userInfo.user_id as user " +
            "where user.id = :userId")
    Exercise getFavouriteExercise(@Param("userId") int userId);
}
