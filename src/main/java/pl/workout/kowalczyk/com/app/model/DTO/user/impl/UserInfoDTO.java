package pl.workout.kowalczyk.com.app.model.DTO.user.impl;

import pl.workout.kowalczyk.com.app.model.DTO.user.AbstractUserObjectDTO;

/**
 * Created by JK on 2016-11-18.
 */
public class UserInfoDTO extends AbstractUserObjectDTO {
    private Long actualWeightId;
    private Long favouriteExerciseId;

    public UserInfoDTO() {
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
