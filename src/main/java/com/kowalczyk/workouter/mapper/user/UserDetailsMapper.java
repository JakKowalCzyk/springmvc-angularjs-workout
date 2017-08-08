package com.kowalczyk.workouter.mapper.user;


import com.kowalczyk.workouter.mapper.impl.ModelMapperImpl;
import com.kowalczyk.workouter.model.BO.ModelObject;
import com.kowalczyk.workouter.model.BO.user.UserDetails;
import com.kowalczyk.workouter.model.BO.user.impl.UserInfo;
import com.kowalczyk.workouter.model.DTO.user.UserDetailsDTO;
import com.kowalczyk.workouter.services.exercise.WorkoutService;
import com.kowalczyk.workouter.services.security.RoleService;
import com.kowalczyk.workouter.services.user.UserInfoService;
import com.kowalczyk.workouter.services.user.UserNotesService;
import com.kowalczyk.workouter.services.user.UserWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
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
        Optional<UserInfo> userInfoOptional = Optional.ofNullable(userInfoService.getUserInfoByUserId(objectDTO.getId()));
        userInfoOptional.ifPresent(userInfo -> userDetails.setUserInfo(userInfoOptional.get()));
        userDetails.getUserWeightList().addAll(userWeightService.getWeightByUserId(objectDTO.getId()));
        userDetails.getUserNotes().addAll(userNotesService.getUserNotesByUserId(objectDTO.getId()));
        userDetails.getWorkouts().addAll(workoutService.getWorkoutsByUserId(objectDTO.getId()));
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
        return userDetailsDTO;
    }
}
