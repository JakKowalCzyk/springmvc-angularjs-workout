package com.kowalczyk.workouter.model.BO.security;

import com.kowalczyk.workouter.model.BO.ModelObject;
import com.kowalczyk.workouter.model.BO.user.User;
import org.apache.commons.lang.time.DateUtils;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by JK on 2017-09-12.
 */
@Entity
public class UserConfirmationToken extends ModelObject {

    private String token;

    private User user;

    private Date expiryDate;

    public UserConfirmationToken() {
        this.expiryDate = DateUtils.addDays(new GregorianCalendar().getTime(), 1);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @OneToOne(fetch = FetchType.EAGER)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
