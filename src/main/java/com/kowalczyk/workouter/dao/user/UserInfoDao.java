package com.kowalczyk.workouter.dao.user;

import com.kowalczyk.workouter.dao.BaseDao;
import com.kowalczyk.workouter.model.BO.user.impl.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
