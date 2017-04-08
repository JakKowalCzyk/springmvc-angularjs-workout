package pl.workout.kowalczyk.com.app.controllers.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.workout.kowalczyk.com.app.controllers.impl.ModelControllerImpl;
import pl.workout.kowalczyk.com.app.mapper.user.UserDetailsMapper;
import pl.workout.kowalczyk.com.app.model.BO.user.UserDetails;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserDetailsDTO;
import pl.workout.kowalczyk.com.app.services.user.UserDetailsService;

import java.security.Principal;
import java.util.List;

/**
 * Created by JK on 2017-04-08.
 */
@RestController
public class UserDetailsControllerImpl extends ModelControllerImpl<UserDetails, UserDetailsDTO> implements pl.workout.kowalczyk.com.app.controllers.user.UserDetailsController {

    @Autowired
    public UserDetailsControllerImpl(UserDetailsService modelService, UserDetailsMapper modelMapper) {
        super(modelService, modelMapper);
    }

    @Override
    public UserDetailsDTO updateObject(@RequestBody UserDetailsDTO model) {
        return super.updateObject(model);
    }

    @Override
    public UserDetailsDTO addObject(@RequestBody UserDetailsDTO model) {
        return super.addObject(model);
    }

    @Override
    public List<UserDetailsDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteObject(@PathVariable Long id) {
        super.deleteObject(id);
    }

    @Override
    public UserDetailsDTO getPrincipal(Principal principal) {
        return getModelMapper().mapToDTO(((UserDetailsService) getModelService()).getByLogin(principal.getName()));
    }
}
