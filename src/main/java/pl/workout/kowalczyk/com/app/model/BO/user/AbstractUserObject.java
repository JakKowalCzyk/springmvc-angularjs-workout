package pl.workout.kowalczyk.com.app.model.BO.user;

import pl.workout.kowalczyk.com.app.model.BO.ModelObject;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * Created by JK on 2017-04-07.
 */
@MappedSuperclass
public abstract class AbstractUserObject extends ModelObject {

    private UserDetails user;

    public AbstractUserObject() {
    }

    @ManyToOne
    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails userId) {
        this.user = userId;
    }
}
