package com.kowalczyk.workouter.model.DTO.exercise;

import com.kowalczyk.workouter.enums.ExerciseType;
import com.kowalczyk.workouter.model.DTO.ObjectDTO;

/**
 * Created by JK on 2016-11-18.
 */
public class ExerciseDTO extends ObjectDTO {

    private String name;

    private String description;

    private ExerciseType exerciseType;


    public ExerciseDTO() {
    }

    public ExerciseDTO(String name, String description, ExerciseType exerciseType) {
        this.name = name;
        this.description = description;
        this.exerciseType = exerciseType;
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
