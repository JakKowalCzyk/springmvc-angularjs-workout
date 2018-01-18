package com.kowalczyk.workouter.dao.security.token;

import com.kowalczyk.workouter.dao.BaseDAO;
import com.kowalczyk.workouter.model.BO.security.token.GenericToken;
import com.kowalczyk.workouter.model.BO.user.User;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by JK on 2018-01-14.
 */
@NoRepositoryBean
public interface GenericTokenDAO<T extends GenericToken> extends BaseDAO<T> {

    T findByUser(User user);

    T findByToken(String token);

}
