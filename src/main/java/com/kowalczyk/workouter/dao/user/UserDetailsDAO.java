package com.kowalczyk.workouter.dao.user;

import com.kowalczyk.workouter.dao.BaseDAO;
import com.kowalczyk.workouter.model.BO.user.UserDetails;
import org.springframework.stereotype.Repository;

/**
 * Created by JK on 2016-12-12.
 */
@Repository
public interface UserDetailsDAO extends BaseDAO<UserDetails> {

    UserDetails findByLogin(String login);

}
