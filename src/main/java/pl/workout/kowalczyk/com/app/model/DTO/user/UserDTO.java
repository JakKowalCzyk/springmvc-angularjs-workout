package pl.workout.kowalczyk.com.app.model.DTO.user;

import pl.workout.kowalczyk.com.app.model.DTO.ObjectDTO;

import java.sql.Date;

/**
 * Created by JK on 2016-11-18.
 */
public class UserDTO extends ObjectDTO {
    private String firstName;
    private String lastName;
    private Date birthDay;
    private String email;
    private Long userDetails;

    public Long getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(Long userDetails) {
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
