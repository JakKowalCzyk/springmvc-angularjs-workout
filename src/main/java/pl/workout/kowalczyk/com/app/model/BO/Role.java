package pl.workout.kowalczyk.com.app.model.BO;

import javax.persistence.*;

/**
 * Created by JK on 2016-12-14.
 */
@Entity
@Table(name = "saw_role")
public class Role {
    private Integer roleId;
    private String name;

    public Role() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
