package com.kowalczyk.workouter.controllers.user.impl;

import com.kowalczyk.workouter.controllers.impl.ModelControllerImpl;
import com.kowalczyk.workouter.controllers.user.UserController;
import com.kowalczyk.workouter.mapper.user.UserMapper;
import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.model.DTO.security.ResetPasswordObject;
import com.kowalczyk.workouter.model.DTO.user.UserDTO;
import com.kowalczyk.workouter.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * Created by JK on 2017-04-08.
 */
@RestController
public class UserControllerImpl extends ModelControllerImpl<User, UserDTO> implements UserController {

    @Autowired
    public UserControllerImpl(UserService modelService, UserMapper modelMapper) {
        super(modelService, modelMapper);
    }

    @Override
    public UserDTO updateObject(@Valid @RequestBody UserDTO model) {
        return super.updateObject(model);
    }

    @Override
    public UserDTO addObject(@Valid @RequestBody UserDTO model) {
        return super.addObject(model);
    }

    @Override
    public List<UserDTO> findAll() {
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
    public UserDTO getPrincipal(Principal principal) {
        return getModelMapper().mapToDTO(getModelService().getByLogin(principal.getName()));
    }

    @Override
    public UserDTO getByLogin(@PathVariable String login) {
        return getModelMapper().mapToDTO(getModelService().getByLogin(login));
    }

    @Override
    public void startConfirmationProcedure(@RequestParam String uri, @PathVariable Long id) {
        getModelService().startConfirmationProcedure(uri, id);
    }

    @Override
    public ResponseEntity<Boolean> confirmAccount(@PathVariable String token) {
        boolean isAccountConfirmed = getModelService().confirmAccount(token);
        return new ResponseEntity<>(isAccountConfirmed, isAccountConfirmed ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @Override
    public void startResetPasswordProcedure(String body, Long id) {
        getModelService().startResetPasswordProcedure(id, body);
    }

    @Override
    public ResponseEntity<Boolean> resetPassword(ResetPasswordObject resetPasswordObject) {
        boolean isPasswordChanged = getModelService().resetPassword(resetPasswordObject);
        return new ResponseEntity<Boolean>(isPasswordChanged, isPasswordChanged ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @Override
    protected UserService getModelService() {
        return (UserService) super.getModelService();
    }
}
