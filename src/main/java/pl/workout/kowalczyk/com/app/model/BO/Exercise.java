package pl.workout.kowalczyk.com.app.model.BO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.workout.kowalczyk.com.app.enums.ExerciseType;

import javax.persistence.*;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
@Table(name ="saw_exercise")
public class Exercise extends BaseModel{
 
    private Integer exercise_id;

    private String name;

    private String description;

    private ExerciseType exerciseType;
    
    @JsonIgnore
    private UserInfo userInfo_id;

    public Exercise(Integer exercise_id, String name, String description, ExerciseType exerciseType) {
        this.exercise_id = exercise_id;
        this.name = name;
        this.description = description;
        this.exerciseType = exerciseType;
    }

    @OneToOne(mappedBy = "exerciseFavourite_id")
    public UserInfo getUserInfo_id() {
        return userInfo_id;
    }

    public void setUserInfo_id(UserInfo userInfo_id) {
        this.userInfo_id = userInfo_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(int exercise_id) {
        this.exercise_id = exercise_id;
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
