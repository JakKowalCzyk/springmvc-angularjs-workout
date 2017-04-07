package pl.workout.kowalczyk.com.app.controllers.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.workout.kowalczyk.com.app.controllers.impl.ModelControllerImpl;
import pl.workout.kowalczyk.com.app.controllers.user.UserInfoController;
import pl.workout.kowalczyk.com.app.mapper.user.impl.UserInfoMapper;
import pl.workout.kowalczyk.com.app.model.BO.user.impl.UserInfo;
import pl.workout.kowalczyk.com.app.model.DTO.user.impl.UserInfoDTO;
import pl.workout.kowalczyk.com.app.services.user.UserInfoService;

import java.util.List;

/**
 * Created by JK on 2017-01-22.
 */
@RestController
public class UserInfoControllerImpl extends ModelControllerImpl<UserInfo, UserInfoDTO> implements UserInfoController {

    @Autowired
    public UserInfoControllerImpl(UserInfoService modelService, UserInfoMapper modelMapper) {
        super(modelService, modelMapper);
    }

    @Override
    public UserInfoDTO getObject(@PathVariable Long id) {
        return super.getObject(id);
    }

    @Override
    public UserInfoDTO updateObject(@RequestBody UserInfoDTO model) {
        return super.updateObject(model);
    }

    @Override
    public UserInfoDTO addObject(@RequestBody UserInfoDTO model) {
        return super.addObject(model);
    }

    @Override
    public List<UserInfoDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteObject(@PathVariable Long id) {
        super.deleteObject(id);
    }

    @Override
    public UserInfoDTO getById(@PathVariable Long id) {
        return getModelMapper().mapToDTO(((UserInfoService) getModelService()).getUserInfoByUserId(id));
    }
}
