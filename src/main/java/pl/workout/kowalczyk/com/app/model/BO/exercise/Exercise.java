package pl.workout.kowalczyk.com.app.model.BO.exercise;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.model.BO.AbstractModel;
import pl.workout.kowalczyk.com.app.model.BO.user.UserInfo;

import javax.persistence.*;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
@Table(name ="saw_exercise")
public class Exercise extends AbstractModel{
 
    private String name;

    private String description;

    private ExerciseType exerciseType;
    
    @JsonIgnore
    private UserInfo userInfo_id;

    public Exercise(String name, String description, ExerciseType exerciseType) {
        this.name = name;
        this.description = description;
        this.exerciseType = exerciseType;
    }

    public Exercise() {
    }

    @OneToOne(mappedBy = "exerciseFavourite_id")
    public UserInfo getUserInfo_id() {
        return userInfo_id;
    }

    public void setUserInfo_id(UserInfo userInfo_id) {
        this.userInfo_id = userInfo_id;
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

    @Enumerated(EnumType.STRING)
    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }
}
