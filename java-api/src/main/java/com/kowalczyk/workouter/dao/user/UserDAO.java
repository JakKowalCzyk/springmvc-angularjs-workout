package com.kowalczyk.workouter.dao.user;

import com.kowalczyk.workouter.dao.BaseDAO;
import com.kowalczyk.workouter.model.BO.user.User;
import org.springframework.stereotype.Repository;

/**
 * Created by JK on 2016-12-12.
 */
@Repository
public interface UserDAO extends BaseDAO<User> {

    User findByLogin(String login);

}
