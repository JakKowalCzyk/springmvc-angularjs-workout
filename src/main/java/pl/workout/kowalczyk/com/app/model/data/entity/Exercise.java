package pl.workout.kowalczyk.com.app.model.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import pl.workout.kowalczyk.com.app.enums.ExerciseType;

import javax.persistence.*;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
@Table(name ="saw_exercise")
public class Exercise extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int exercise_id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private ExerciseType exerciseType;

    @OneToOne
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private UserInfo userInfo_id;

    public UserInfo getUserInfo_id() {
        return userInfo_id;
    }

    public void setUserInfo_id(UserInfo userInfo_id) {
        this.userInfo_id = userInfo_id;
    }

    public int getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(int uweight_id) {
        this.exercise_id = uweight_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }
}
