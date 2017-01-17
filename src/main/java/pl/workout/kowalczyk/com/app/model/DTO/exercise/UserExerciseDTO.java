package pl.workout.kowalczyk.com.app.model.DTO.exercise;

import pl.workout.kowalczyk.com.app.model.DTO.BaseModel;

/**
 * Created by JK on 2016-11-18.
 */
public class UserExerciseDTO extends BaseModel {
    private Integer workoutId;
    private Integer repeat;
    private Integer series;
    private Integer exerciseId;

    public UserExerciseDTO() {
    }

    public UserExerciseDTO(Integer id, Integer workoutId, Integer repeat, Integer series, Integer exerciseId) {
        super(id);
        this.workoutId = workoutId;
        this.repeat = repeat;
        this.series = series;
        this.exerciseId = exerciseId;
    }

    public Integer getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Integer workoutId) {
        this.workoutId = workoutId;
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

    public Integer getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Integer exerciseId) {
        this.exerciseId = exerciseId;
    }
}
