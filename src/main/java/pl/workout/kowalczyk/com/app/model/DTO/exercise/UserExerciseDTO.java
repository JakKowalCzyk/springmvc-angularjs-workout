package pl.workout.kowalczyk.com.app.model.DTO.exercise;

import pl.workout.kowalczyk.com.app.model.DTO.BaseModel;

/**
 * Created by JK on 2016-11-18.
 */
public class UserExerciseDTO extends BaseModel {
    private ExerciseDTO exercise;
    private Integer workout_id;
    private Integer repeat;
    private Integer series;
    private Integer exerciseId;

    public UserExerciseDTO() {
    }

    public UserExerciseDTO(Integer userExercise_id, ExerciseDTO exercise, Integer workout_id, Integer repeat, Integer series) {
        super(userExercise_id);
        this.exercise = exercise;
        this.workout_id = workout_id;
        this.repeat = repeat;
        this.series = series;
    }

    public UserExerciseDTO(Integer workout_id, Integer repeat, Integer series, Integer exerciseId) {
        this.workout_id = workout_id;
        this.repeat = repeat;
        this.series = series;
        this.exerciseId = exerciseId;
    }


    public Integer getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Integer exerciseId) {
        this.exerciseId = exerciseId;
    }

    public ExerciseDTO getExercise() {
        return exercise;
    }

    public void setExercise(ExerciseDTO exercise) {
        this.exercise = exercise;
    }

    public Integer getWorkout_id() {
        return workout_id;
    }

    public void setWorkout_id(Integer workout_id) {
        this.workout_id = workout_id;
    }

    public Integer getRepeat() {
        return repeat;
    }

    public void setRepeat(Integer repeat) {
        this.repeat = repeat;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }
}