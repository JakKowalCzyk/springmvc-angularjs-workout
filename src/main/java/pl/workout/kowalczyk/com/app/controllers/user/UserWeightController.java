package pl.workout.kowalczyk.com.app.controllers.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserWeightDTO;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2017-01-22.
 */
@Api(tags = {"User's weight API"}, description = "Services for user's weight")
@RequestMapping("/user/weight")
public interface UserWeightController {

    @ApiOperation(value = "Save new user's weight")
    @RequestMapping(method = RequestMethod.POST)
    void saveUserWeight(@RequestBody UserWeightDTO userWeightDTO);

    @ApiOperation(value = "Update existing user's weight")
    @RequestMapping(method = RequestMethod.PUT)
    void updateUserWeight(@RequestBody UserWeightDTO userWeightDTO);

    @ApiOperation(value = "Get weight for user")
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    List<UserWeightDTO> getWeightByUserId(@PathVariable int userId);

    @ApiOperation(value = "Get weight for user by date")
    @RequestMapping(value = "/user/{userId}/date/{date}", method = RequestMethod.GET)
    UserWeightDTO getWeightByDate(@PathVariable int userId, @PathVariable Date date);

    @ApiOperation(value = "Get actual weight for user")
    @RequestMapping(value = "/actual/user/{userId}", method = RequestMethod.GET)
    UserWeightDTO getActualWeight(@PathVariable int userId);

}
