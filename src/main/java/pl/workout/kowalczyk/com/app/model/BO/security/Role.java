package pl.workout.kowalczyk.com.app.model.BO.security;

import pl.workout.kowalczyk.com.app.model.BO.AbstractModel;

import javax.persistence.*;

/**
 * Created by JK on 2016-12-14.
 */
@Entity
public class Role extends AbstractModel {
    private Integer id;
    private String name;

    public Role() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
