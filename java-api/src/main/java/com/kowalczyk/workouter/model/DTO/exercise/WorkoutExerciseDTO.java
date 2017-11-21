package com.kowalczyk.workouter.model.DTO.exercise;

import com.kowalczyk.workouter.model.DTO.ObjectDTO;

/**
 * Created by JK on 2016-11-18.
 */
public class WorkoutExerciseDTO extends ObjectDTO {
    private Long workoutId;
    private Integer repeat;
    private Integer series;
    private Long exerciseId;

    public WorkoutExerciseDTO() {
    }

    public Long getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Long workoutId) {
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

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }
}
