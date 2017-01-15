package pl.workout.kowalczyk.com.app.dao.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
            "inner join o.userId as user " +
            "where user.id = :userId")
    UserInfo getUserInfoByUserId(@Param("userId") Integer userId);

    @Query("select o FROM UserWeight o inner join o.userInfoId as ui " +
            "inner join ui.userId as user " +
            "where user.id = :userId")
    UserWeight getActualWeight(@Param("userId") Integer userId);

    @Query("select o FROM Exercise o inner join o.userInfoId as userInfo " +
            "inner join userInfo.userId as user " +
            "where user.id = :userId")
    Exercise getFavouriteExercise(@Param("userId") Integer userId);

    @Modifying
    @Transactional
    @Query("Update UserInfo user set user.exerciseFavouriteId = :exerciseId  where user.userId.id = :userId ")
    void updateFavouriteExercise(@Param("userId") Integer userId, @Param("exerciseId") Exercise exerciseId);
}
