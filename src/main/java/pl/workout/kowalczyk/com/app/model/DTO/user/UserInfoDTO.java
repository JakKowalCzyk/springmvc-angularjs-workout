package pl.workout.kowalczyk.com.app.model.DTO.user;

import pl.workout.kowalczyk.com.app.model.DTO.ObjectDTO;

/**
 * Created by JK on 2016-11-18.
 */
public class UserInfoDTO extends ObjectDTO {
    private Long userId;
    private Long actualWeightId;
    private Long favouriteExerciseId;

    public UserInfoDTO() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getActualWeightId() {
        return actualWeightId;
    }

    public void setActualWeightId(Long actualWeightId) {
        this.actualWeightId = actualWeightId;
    }

    public Long getFavouriteExerciseId() {
        return favouriteExerciseId;
    }

    public void setFavouriteExerciseId(Long favouriteExerciseId) {
        this.favouriteExerciseId = favouriteExerciseId;
    }
}
