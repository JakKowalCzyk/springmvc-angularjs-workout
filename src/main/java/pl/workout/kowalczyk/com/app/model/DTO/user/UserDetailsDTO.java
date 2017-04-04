package pl.workout.kowalczyk.com.app.model.DTO.user;

import pl.workout.kowalczyk.com.app.model.DTO.ObjectDTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by JK on 2017-04-04.
 */
public class UserDetailsDTO extends ObjectDTO {

    private String login;
    private String hashedPassword;
    private Boolean enabled;
    private Set<Long> userRoles = new HashSet<Long>();
    private String firstName;
    private String lastName;
    private Date birthDay;
    private String email;

    public UserDetailsDTO() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Long> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<Long> userRoles) {
        this.userRoles = userRoles;
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
