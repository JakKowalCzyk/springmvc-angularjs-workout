package com.kowalczyk.workouter.dao.security.token;

import com.kowalczyk.workouter.model.BO.security.token.UserConfirmationToken;
import org.springframework.stereotype.Repository;

/**
 * Created by JK on 2017-09-12.
 */
@Repository
public interface UserConfirmationTokenDAO extends GenericTokenDAO<UserConfirmationToken> {

}
