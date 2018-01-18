package com.kowalczyk.workouter.dao.security.token;

import com.kowalczyk.workouter.model.BO.security.token.ResetPasswordToken;
import org.springframework.stereotype.Repository;

/**
 * Created by JK on 2018-01-14.
 */
@Repository
public interface ResetPasswordTokenDAO extends GenericTokenDAO<ResetPasswordToken> {
}
