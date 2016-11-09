package pl.workout.kowalczyk.com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.workout.kowalczyk.com.app.model.data.entity.UserWeight;
import pl.workout.kowalczyk.com.app.services.service.UserInfoService;
import pl.workout.kowalczyk.com.app.services.service.UserWeightService;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-31.
 */
@RestController
@RequestMapping("/user/weight")
public class UserWeightController {
    @Autowired
    private UserWeightService userWeightService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveUserWeight(@RequestBody UserWeight userWeight) {
        int userId =1 ;
        userWeightService.saveUserWeight(userId, userWeight);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateUserWeight(@RequestBody UserWeight userWeight) {
        userWeightService.updateUserWeight(userWeight);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public List<UserWeight> getWeightByUserId(@PathVariable int userId) {
        return userWeightService.getWeightByUserId(userId);
    }

    @RequestMapping(value = "/{userId}/{date}", method = RequestMethod.GET)
    public UserWeight getWeightByDate(@PathVariable int userId, @PathVariable Date date) {
        return userWeightService.getByUserIdAndDate(userId, date);
    }

    @RequestMapping(value = "/actual/{userId}", method = RequestMethod.GET)
    public UserWeight getActualWeight(@PathVariable int userId) {
        return userWeightService.getActualWeight(userId);
    }
}
