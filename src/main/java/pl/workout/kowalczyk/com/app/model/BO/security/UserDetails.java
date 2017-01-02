package pl.workout.kowalczyk.com.app.model.BO.security;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by JK on 2016-12-12.
 */
@Entity
@Table(name = "saw_user_details")
public class UserDetails {

    private Integer userId;
    private String login;
    private String password;
    private Boolean enabled;
    private Set<UserRole> userRoles = new HashSet<>();


    public UserDetails(String login, String password, Boolean enabled, Set<UserRole> userRoleSet) {
        this.login = login;
        this.password = password;
        this.enabled = enabled;
        this.userRoles = userRoleSet;
    }

    public UserDetails() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userDetails")
    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoleSet) {
        this.userRoles = userRoleSet;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
