package pl.workout.kowalczyk.com.app.model.BO.user;

import pl.workout.kowalczyk.com.app.model.BO.AbstractModel;
import pl.workout.kowalczyk.com.app.model.BO.security.UserDetails;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by JK on 2016-09-07.
 */
@Entity
@Table(name = "saw_user")
public class User extends AbstractModel{

    @OneToOne
    private UserDetails userDetails;

    private String firstName;

    private String lastName;

    private Date birthDay;

    private String email;

    public User(Integer userId, UserDetails userDetails, String firstName, String lastName, Date birthDay, String email) {
        super(userId);
        this.firstName = firstName;
        this.userDetails = userDetails;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.email = email;
    }

    public User() {
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
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
