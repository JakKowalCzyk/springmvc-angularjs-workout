package pl.workout.kowalczyk.com.app.services.user;

import pl.workout.kowalczyk.com.app.model.BO.user.UserWeight;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserWeightDTO;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface UserWeightService {
    UserWeight mapUserWeightDtoToBo(UserWeightDTO actual_weight);

    UserWeightDTO mapUserWeightBoToDto(UserWeight actual_weight);

    void saveUserWeight(int userId, UserWeightDTO userWeightDTO);

    void updateUserWeight(UserWeightDTO userWeightDTO);

    List<UserWeightDTO> getWeightByUserId(int userId);

    UserWeightDTO getByUserIdAndDate(int userId, Date date);

    UserWeightDTO getActualWeight(int userId);

    Date getLastDate(int userId);

    boolean checkIfLastWeight(int userId, UserWeightDTO userWeight);
}
