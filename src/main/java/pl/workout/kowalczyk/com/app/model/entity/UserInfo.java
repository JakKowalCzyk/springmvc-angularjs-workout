package pl.workout.kowalczyk.com.app.model.entity;

import javax.persistence.*;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
@Table(name = "saw_userInfo")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int uinfo_id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private User user_id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserWeight actual_weight;

    @OneToOne(cascade =  CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private FavouriteExercise favouriteExercise;


}
