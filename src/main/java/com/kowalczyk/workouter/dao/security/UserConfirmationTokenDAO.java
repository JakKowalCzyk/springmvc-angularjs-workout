package com.kowalczyk.workouter.dao.security;

import com.kowalczyk.workouter.dao.BaseDAO;
import com.kowalczyk.workouter.model.BO.security.UserConfirmationToken;
import com.kowalczyk.workouter.model.BO.user.User;
import org.springframework.stereotype.Repository;

/**
 * Created by JK on 2017-09-12.
 */
@Repository
public interface UserConfirmationTokenDAO extends BaseDAO<UserConfirmationToken> {

    UserConfirmationToken findByUser(User user);

    UserConfirmationToken findByToken(String token);
}
