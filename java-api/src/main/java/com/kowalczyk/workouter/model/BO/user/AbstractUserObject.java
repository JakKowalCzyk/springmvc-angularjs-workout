package com.kowalczyk.workouter.model.BO.user;

import com.kowalczyk.workouter.model.BO.ModelObject;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * Created by JK on 2017-04-07.
 */
@MappedSuperclass
public abstract class AbstractUserObject extends ModelObject {

    private User user;

    public AbstractUserObject() {
    }

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }
}
