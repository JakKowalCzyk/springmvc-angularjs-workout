package com.kowalczyk.workouter.model.BO.security.token;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by JK on 2018-01-14.
 */
@Entity
public class ResetPasswordToken extends GenericToken {

    private Date expiryDate;

    public ResetPasswordToken() {
        super();
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
