package com.kowalczyk.workouter.controllers.user.impl;

import com.kowalczyk.workouter.controllers.impl.ModelControllerImpl;
import com.kowalczyk.workouter.controllers.user.UserDetailsController;
import com.kowalczyk.workouter.mapper.user.UserDetailsMapper;
import com.kowalczyk.workouter.model.BO.user.UserDetails;
import com.kowalczyk.workouter.model.DTO.user.UserDetailsDTO;
import com.kowalczyk.workouter.services.user.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/**
 * Created by JK on 2017-04-08.
 */
@RestController
public class UserDetailsControllerImpl extends ModelControllerImpl<UserDetails, UserDetailsDTO> implements UserDetailsController {

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
    public boolean isExist(@PathVariable Long id) {
        return super.isExist(id);
    }

    @Override
    public UserDetailsDTO getPrincipal(Principal principal) {
        return getModelMapper().mapToDTO(((UserDetailsService) getModelService()).getByLogin(principal.getName()));
    }

    @Override
    public UserDetailsDTO getByLogin(@PathVariable String login) {
        return getModelMapper().mapToDTO(((UserDetailsService) getModelService()).getByLogin(login));
    }
}
