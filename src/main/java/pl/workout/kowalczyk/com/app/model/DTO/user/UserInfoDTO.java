package pl.workout.kowalczyk.com.app.model.DTO.user;

import pl.workout.kowalczyk.com.app.model.DTO.BaseModel;

/**
 * Created by JK on 2016-11-18.
 */
public class UserInfoDTO extends BaseModel {
    private Integer userId;
    private Integer actualWeightId;
    private Integer favouriteExerciseId;

    public UserInfoDTO(Integer id, Integer userId, Integer actualWeightId, Integer favouriteExerciseId) {
        super(id);
        this.userId = userId;
        this.actualWeightId = actualWeightId;
        this.favouriteExerciseId = favouriteExerciseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActualWeightId() {
        return actualWeightId;
    }

    public void setActualWeightId(Integer actualWeightId) {
        this.actualWeightId = actualWeightId;
    }

    public Integer getFavouriteExerciseId() {
        return favouriteExerciseId;
    }

    public void setFavouriteExerciseId(Integer favouriteExerciseId) {
        this.favouriteExerciseId = favouriteExerciseId;
    }
}
