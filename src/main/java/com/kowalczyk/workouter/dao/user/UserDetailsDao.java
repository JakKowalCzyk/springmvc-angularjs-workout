package com.kowalczyk.workouter.dao.user;

import com.kowalczyk.workouter.dao.BaseDao;
import com.kowalczyk.workouter.model.BO.user.UserDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by JK on 2016-12-12.
 */
public interface UserDetailsDao extends BaseDao<UserDetails> {

    @Query("select u from UserDetails as u where u.login = :login")
    UserDetails getByLogin(@Param("login") String login);

}
