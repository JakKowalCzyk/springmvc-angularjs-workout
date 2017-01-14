package pl.workout.kowalczyk.com.app.model.DTO.user;

import pl.workout.kowalczyk.com.app.model.BO.security.UserDetails;
import pl.workout.kowalczyk.com.app.model.DTO.BaseModel;

import java.sql.Date;

/**
 * Created by JK on 2016-11-18.
 */
public class UserDTO extends BaseModel {
    private String firstName;
    private String lastName;
    private Date birthDay;
    private String email;
    private UserDetails userDetails;

    public UserDTO(Integer user_id, UserDetails userDetails, String firstName, String lastName, Date birthDay, String email) {
        super(user_id);
        this.userDetails = userDetails;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.email = email;
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
