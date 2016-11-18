package pl.workout.kowalczyk.com.app.model.DTO;

import pl.workout.kowalczyk.com.app.enums.ExerciseType;

/**
 * Created by JK on 2016-11-18.
 */
public class ExerciseDTO {

    private Integer exerciseId;

    private String name;

    private String description;

    private ExerciseType exerciseType;


    public ExerciseDTO(Integer exercise_id, String name, String description, ExerciseType exerciseType) {
        this.exerciseId = exercise_id;
        this.name = name;
        this.description = description;
        this.exerciseType = exerciseType;
    }

    public Integer getExercise_id() {
        return exerciseId;
    }

    public void setExercise_id(Integer exercise_id) {
        this.exerciseId = exercise_id;
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
