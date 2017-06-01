package com.kowalczyk.workouter.mapper.user;


import com.kowalczyk.workouter.mapper.impl.ModelMapperImpl;
import com.kowalczyk.workouter.model.BO.ModelObject;
import com.kowalczyk.workouter.model.BO.user.UserDetails;
import com.kowalczyk.workouter.model.DTO.user.UserDetailsDTO;
import com.kowalczyk.workouter.services.exercise.WorkoutService;
import com.kowalczyk.workouter.services.security.RoleService;
import com.kowalczyk.workouter.services.user.UserInfoService;
import com.kowalczyk.workouter.services.user.UserNotesService;
import com.kowalczyk.workouter.services.user.UserWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Created by JK on 2017-04-04.
 */
@Component
public class UserDetailsMapper extends ModelMapperImpl<UserDetails, UserDetailsDTO> {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserWeightService userWeightService;
    @Autowired
    private UserNotesService userNotesService;
    @Autowired
    private WorkoutService workoutService;

    @Override
    protected UserDetails buildBO(UserDetailsDTO objectDTO) {
        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName(objectDTO.getFirstName());
        userDetails.setLastName(objectDTO.getLastName());
        userDetails.setBirthDay(objectDTO.getBirthDay());
        userDetails.setEmail(objectDTO.getEmail());
        userDetails.setEnabled(objectDTO.isEnabled());
        userDetails.setAccountNonExpired(objectDTO.isAccountNonExpired());
        userDetails.setAccountNonLocked(objectDTO.isAccountNonLocked());
        userDetails.setCredentialsNonExpired(objectDTO.isCredentialsNonExpired());
        userDetails.setLogin(objectDTO.getLogin());
        userDetails.setHashedPassword(objectDTO.getHashedPassword());
        userDetails.setRoles(objectDTO.getRoles().stream().map(userRoleDTO -> roleService.getObject(userRoleDTO)).collect(Collectors.toSet()));
        userDetails.setUserInfoList(objectDTO.getUserInfoList().stream().map(id -> userInfoService.getObject(id)).collect(Collectors.toList()));
        userDetails.setUserWeightList(objectDTO.getUserWeightList().stream().map(id -> userWeightService.getObject(id)).collect(Collectors.toList()));
        userDetails.setUserNotes(objectDTO.getUserNotes().stream().map(id -> userNotesService.getObject(id)).collect(Collectors.toList()));
        userDetails.setWorkouts(objectDTO.getWorkouts().stream().map(id -> workoutService.getObject(id)).collect(Collectors.toList()));
        return userDetails;
    }

    @Override
    protected UserDetailsDTO buildDTO(UserDetails modelObject) {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setFirstName(modelObject.getFirstName());
        userDetailsDTO.setLastName(modelObject.getLastName());
        userDetailsDTO.setBirthDay(modelObject.getBirthDay());
        userDetailsDTO.setEmail(modelObject.getEmail());
        userDetailsDTO.setEnabled(modelObject.isEnabled());
        userDetailsDTO.setAccountNonExpired(modelObject.isAccountNonExpired());
        userDetailsDTO.setCredentialsNonExpired(modelObject.isCredentialsNonExpired());
        userDetailsDTO.setAccountNonLocked(modelObject.isAccountNonLocked());
        userDetailsDTO.setLogin(modelObject.getLogin());
        userDetailsDTO.setHashedPassword(modelObject.getHashedPassword());
        userDetailsDTO.setRoles(modelObject.getRoles().stream().map(ModelObject::getId).collect(Collectors.toSet()));
        userDetailsDTO.setUserInfoList(modelObject.getUserInfoList().stream().map(ModelObject::getId).collect(Collectors.toList()));
        userDetailsDTO.setUserWeightList(modelObject.getUserWeightList().stream().map(ModelObject::getId).collect(Collectors.toList()));
        userDetailsDTO.setUserNotes(modelObject.getUserNotes().stream().map(ModelObject::getId).collect(Collectors.toList()));
        userDetailsDTO.setWorkouts(modelObject.getWorkouts().stream().map(ModelObject::getId).collect(Collectors.toList()));
        return userDetailsDTO;
    }
}
