package com.kowalczyk.workouter.model.BO.exercise;

import com.kowalczyk.workouter.enums.ExerciseType;
import com.kowalczyk.workouter.model.BO.ModelObject;
import com.kowalczyk.workouter.model.BO.user.impl.UserInfo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
public class Exercise extends ModelObject {
    private String name;

    private String description;

    private ExerciseType exerciseType;
    
    private UserInfo userInfoId;

    public Exercise(String name, String description, ExerciseType exerciseType) {
        this.name = name;
        this.description = description;
        this.exerciseType = exerciseType;
    }

    public Exercise() {
    }

    @OneToOne(mappedBy = "favouriteExercise")
    public UserInfo getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(UserInfo userInfoId) {
        this.userInfoId = userInfoId;
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
