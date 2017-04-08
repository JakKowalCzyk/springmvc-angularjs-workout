package com.kowalczyk.workouter.controllers.user.impl;

import com.kowalczyk.workouter.controllers.impl.ModelControllerImpl;
import com.kowalczyk.workouter.controllers.user.UserInfoController;
import com.kowalczyk.workouter.mapper.user.impl.UserInfoMapper;
import com.kowalczyk.workouter.model.BO.user.impl.UserInfo;
import com.kowalczyk.workouter.model.DTO.user.impl.UserInfoDTO;
import com.kowalczyk.workouter.services.user.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
