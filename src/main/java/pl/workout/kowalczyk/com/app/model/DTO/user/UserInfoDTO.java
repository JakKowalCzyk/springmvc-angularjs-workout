package pl.workout.kowalczyk.com.app.model.DTO.user;

import pl.workout.kowalczyk.com.app.model.DTO.BaseModel;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.ExerciseDTO;

/**
 * Created by JK on 2016-11-18.
 */
public class UserInfoDTO extends BaseModel {
    private Integer userId;
    private UserWeightDTO actual_weight;
    private ExerciseDTO exerciseFavourite_id;

    public UserInfoDTO(Integer userInfo_id, Integer user_id, UserWeightDTO actual_weight, ExerciseDTO exerciseFavourite_id) {
        super(userInfo_id);
        this.userId = user_id;
        this.actual_weight = actual_weight;
        this.exerciseFavourite_id = exerciseFavourite_id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserWeightDTO getActual_weight() {
        return actual_weight;
    }

    public void setActual_weight(UserWeightDTO actual_weight) {
        this.actual_weight = actual_weight;
    }

    public ExerciseDTO getExerciseFavourite_id() {
        return exerciseFavourite_id;
    }

    public void setExerciseFavourite_id(ExerciseDTO exerciseFavourite_id) {
        this.exerciseFavourite_id = exerciseFavourite_id;
    }
}
