package pl.workout.kowalczyk.com.app.model.BO.security;

import pl.workout.kowalczyk.com.app.model.BO.ModelObject;

import javax.persistence.Entity;

/**
 * Created by JK on 2016-12-14.
 */
@Entity
public class Role extends ModelObject {

    private String name;

    public Role() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
