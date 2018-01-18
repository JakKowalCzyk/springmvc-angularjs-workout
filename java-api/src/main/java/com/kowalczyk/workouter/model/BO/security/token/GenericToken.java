package com.kowalczyk.workouter.model.BO.security.token;

import com.kowalczyk.workouter.model.BO.ModelObject;
import com.kowalczyk.workouter.model.BO.user.User;

import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

/**
 * Created by JK on 2018-01-14.
 */
@MappedSuperclass
public class GenericToken extends ModelObject {

    private String token;

    private User user;

    public GenericToken() {
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


}
