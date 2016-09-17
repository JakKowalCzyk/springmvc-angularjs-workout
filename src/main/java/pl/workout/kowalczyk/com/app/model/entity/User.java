package pl.workout.kowalczyk.com.app.model.entity;

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
    private int id;

    private String login;

    private String firstName;

    private String lastName;

    private Date birthDay;

    private String email;

    private String password;
}
