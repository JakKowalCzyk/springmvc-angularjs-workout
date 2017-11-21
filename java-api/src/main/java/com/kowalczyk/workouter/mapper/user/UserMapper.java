package com.kowalczyk.workouter.mapper.user;


import com.kowalczyk.workouter.mapper.impl.ModelMapperImpl;
import com.kowalczyk.workouter.model.BO.ModelObject;
import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.model.BO.user.impl.UserInfo;
import com.kowalczyk.workouter.model.DTO.user.UserDTO;
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
public class UserMapper extends ModelMapperImpl<User, UserDTO> {

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
    protected User buildBO(UserDTO objectDTO) {
        User user = new User();
        user.setFirstName(objectDTO.getFirstName());
        user.setLastName(objectDTO.getLastName());
        user.setBirthDay(objectDTO.getBirthDay());
        user.setEmail(objectDTO.getEmail());
        user.setEnabled(objectDTO.isEnabled());
        user.setAccountNonExpired(objectDTO.isAccountNonExpired());
        user.setAccountNonLocked(objectDTO.isAccountNonLocked());
        user.setCredentialsNonExpired(objectDTO.isCredentialsNonExpired());
        user.setLogin(objectDTO.getLogin());
        user.setHashedPassword(objectDTO.getHashedPassword());
        user.setRoles(objectDTO.getRoles().stream().map(userRoleDTO -> roleService.getObject(userRoleDTO)).collect(Collectors.toSet()));
        Optional<UserInfo> userInfoOptional = Optional.ofNullable(userInfoService.getUserInfoByUserId(objectDTO.getId()));
        userInfoOptional.ifPresent(userInfo -> user.setUserInfo(userInfoOptional.get()));
        user.getUserWeightList().addAll(userWeightService.getWeightByUserId(objectDTO.getId()));
        user.getUserNotes().addAll(userNotesService.getUserNotesByUserId(objectDTO.getId()));
        user.getWorkouts().addAll(workoutService.getWorkoutsByUserId(objectDTO.getId()));
        return user;
    }

    @Override
    protected UserDTO buildDTO(User modelObject) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(modelObject.getFirstName());
        userDTO.setLastName(modelObject.getLastName());
        userDTO.setBirthDay(modelObject.getBirthDay());
        userDTO.setEmail(modelObject.getEmail());
        userDTO.setEnabled(modelObject.isEnabled());
        userDTO.setAccountNonExpired(modelObject.isAccountNonExpired());
        userDTO.setCredentialsNonExpired(modelObject.isCredentialsNonExpired());
        userDTO.setAccountNonLocked(modelObject.isAccountNonLocked());
        userDTO.setLogin(modelObject.getLogin());
        userDTO.setHashedPassword(modelObject.getHashedPassword());
        userDTO.setRoles(modelObject.getRoles().stream().map(ModelObject::getId).collect(Collectors.toSet()));
        return userDTO;
    }
}
