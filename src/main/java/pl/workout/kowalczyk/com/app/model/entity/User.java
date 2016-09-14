package pl.workout.kowalczyk.com.app.model.entity;

import javax.persistence.*;

/**
 * Created by JK on 2016-09-07.
 */
@Entity
@Table(name = "saw.user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;

    private String firstName;

    private String lastName;

    private int age;

    private String email;

    private String password;
}
