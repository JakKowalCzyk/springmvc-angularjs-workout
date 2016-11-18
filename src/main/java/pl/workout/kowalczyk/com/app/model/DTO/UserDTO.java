package pl.workout.kowalczyk.com.app.model.DTO;

import java.sql.Date;

/**
 * Created by JK on 2016-11-18.
 */
public class UserDTO {
    private Integer userId;
    private String login;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private String email;
    private String password;

    public UserDTO(Integer user_id, String login, String firstName, String lastName, Date birthDay, String email, String password) {
        this.userId = user_id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.email = email;
        this.password = password;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
