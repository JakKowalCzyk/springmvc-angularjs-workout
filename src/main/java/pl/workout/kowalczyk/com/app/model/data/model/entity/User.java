package pl.workout.kowalczyk.com.app.model.data.model.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by JK on 2016-09-07.
 */
@Entity
@Table(name = "saw_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    private String login;

    private String firstName;

    private String lastName;

    private Date birthDay;

    private String email;

    private String password;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
