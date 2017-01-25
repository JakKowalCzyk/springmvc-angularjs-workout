package pl.workout.kowalczyk.com.app.controllers.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.workout.kowalczyk.com.app.controllers.user.UserWeightController;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserWeightDTO;
import pl.workout.kowalczyk.com.app.services.user.UserWeightService;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2017-01-22.
 */
@RestController
public class UserWeightControllerImpl implements UserWeightController {

    @Autowired
    private UserWeightService userWeightService;

    @Override
    public void saveUserWeight(@RequestBody UserWeightDTO userWeightDTO) {
        userWeightService.saveUserWeight(userWeightDTO);
    }

    @Override
    public void updateUserWeight(@RequestBody UserWeightDTO userWeightDTO) {
        userWeightService.updateUserWeight(userWeightDTO);
    }

    @Override
    public List<UserWeightDTO> getWeightByUserId(@PathVariable int userId) {
        return userWeightService.getWeightByUserId(userId);
    }

    @Override
    public UserWeightDTO getWeightByDate(@PathVariable int userId, @PathVariable Date date) {
        return userWeightService.getByUserIdAndDate(userId, date);
    }

    @Override
    public UserWeightDTO getActualWeight(@PathVariable int userId) {
        return userWeightService.getActualWeight(userId);
    }
}
