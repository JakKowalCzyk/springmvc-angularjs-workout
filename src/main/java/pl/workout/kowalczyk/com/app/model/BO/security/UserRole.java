package pl.workout.kowalczyk.com.app.model.BO.security;

import pl.workout.kowalczyk.com.app.model.BO.AbstractModel;

import javax.persistence.*;

/**
 * Created by JK on 2016-12-12.
 */
@Entity
@Table(name = "saw_user_role")
public class UserRole extends AbstractModel{

    private UserDetails userDetails;
    private Role role;

    public UserRole() {
    }

    @ManyToOne
    @JoinColumn(name = "userId")
    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @OneToOne(fetch = FetchType.EAGER)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
