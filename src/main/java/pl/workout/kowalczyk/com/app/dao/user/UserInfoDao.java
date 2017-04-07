package pl.workout.kowalczyk.com.app.dao.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.workout.kowalczyk.com.app.dao.BaseDao;
import pl.workout.kowalczyk.com.app.model.BO.user.impl.UserInfo;

/**
 * Created by JK on 2016-09-22.
 */
@Repository
public interface UserInfoDao extends BaseDao<UserInfo> {

    @Query("SELECT o FROM UserInfo o " +
            "inner join o.user as user " +
            "where user.id = :userId")
    UserInfo getUserInfoByUserId(@Param("userId") Long userId);

}
