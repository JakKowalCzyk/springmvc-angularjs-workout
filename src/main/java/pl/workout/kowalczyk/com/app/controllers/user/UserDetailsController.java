package pl.workout.kowalczyk.com.app.controllers.user;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.workout.kowalczyk.com.app.controllers.ModelController;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserDetailsDTO;

import java.security.Principal;
import java.util.List;

/**
 * Created by JK on 2017-04-08.
 */
@Api(tags = "User Details API", description = "Services for UserDetails")
@RequestMapping("/user/details")
public interface UserDetailsController extends ModelController<UserDetailsDTO> {

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    UserDetailsDTO getObject(@PathVariable Long id);

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    UserDetailsDTO updateObject(@RequestBody UserDetailsDTO model);

    @Override
    @RequestMapping(method = RequestMethod.POST)
    UserDetailsDTO addObject(@RequestBody UserDetailsDTO model);

    @Override
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<UserDetailsDTO> findAll();

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteObject(@PathVariable Long id);

    @RequestMapping(value = "/principal", method = RequestMethod.GET)
    UserDetailsDTO getPrincipal(Principal principal);
}