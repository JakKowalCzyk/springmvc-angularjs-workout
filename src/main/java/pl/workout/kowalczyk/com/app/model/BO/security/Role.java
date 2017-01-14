package pl.workout.kowalczyk.com.app.model.BO.security;

import pl.workout.kowalczyk.com.app.model.BO.AbstractModel;

import javax.persistence.*;

/**
 * Created by JK on 2016-12-14.
 */
@Entity
@Table(name = "saw_role")
public class Role extends AbstractModel {
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
