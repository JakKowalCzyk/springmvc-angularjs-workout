package pl.workout.kowalczyk.com.app.model.data.model.entity;

import pl.workout.kowalczyk.com.app.model.Enums.ExerciseType;

import javax.persistence.*;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
@Table(name ="saw_exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int exercise_id;

    private String name;

    private String description;

    @Enumerated
    private ExerciseType exerciseType;

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
