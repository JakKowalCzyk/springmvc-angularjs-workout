package pl.workout.kowalczyk.com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserWeightDTO;
import pl.workout.kowalczyk.com.app.services.user.UserWeightService;

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
    public ResponseEntity saveUserWeight(@RequestBody UserWeightDTO userWeightDTO) {
        int userId =1 ;
        userWeightService.saveUserWeight(userId, userWeightDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateUserWeight(@RequestBody UserWeightDTO userWeightDTO) {
        userWeightService.updateUserWeight(userWeightDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public List<UserWeightDTO> getWeightByUserId(@PathVariable int userId) {
        return userWeightService.getWeightByUserId(userId);
    }

    @RequestMapping(value = "/{userId}/{date}", method = RequestMethod.GET)
    public UserWeightDTO getWeightByDate(@PathVariable int userId, @PathVariable Date date) {
        return userWeightService.getByUserIdAndDate(userId, date);
    }

    @RequestMapping(value = "/actual/{userId}", method = RequestMethod.GET)
    public UserWeightDTO getActualWeight(@PathVariable int userId) {
        return userWeightService.getActualWeight(userId);
    }
}
