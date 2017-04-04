package pl.workout.kowalczyk.com.app.model.BO.user;

import pl.workout.kowalczyk.com.app.model.BO.ModelObject;
import pl.workout.kowalczyk.com.app.model.BO.security.UserRole;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by JK on 2016-12-12.
 */
@Entity
public class UserDetails extends ModelObject {
    private String login;
    private String password;
    private Boolean enabled;
    private Set<UserRole> userRoles = new HashSet<>();
    private String firstName;
    private String lastName;
    private Date birthDay;
    private String email;


    public UserDetails(String login, String password, Boolean enabled, Set<UserRole> userRoles, String firstName, String lastName, Date birthDay, String email) {
        this.login = login;
        this.password = password;
        this.enabled = enabled;
        this.userRoles = userRoles;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.email = email;
    }

    public UserDetails() {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
