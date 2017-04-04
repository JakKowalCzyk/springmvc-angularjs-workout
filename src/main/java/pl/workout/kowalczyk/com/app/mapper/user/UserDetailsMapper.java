package pl.workout.kowalczyk.com.app.mapper.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.workout.kowalczyk.com.app.mapper.impl.ModelMapperImpl;
import pl.workout.kowalczyk.com.app.model.BO.ModelObject;
import pl.workout.kowalczyk.com.app.model.BO.user.UserDetails;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserDetailsDTO;
import pl.workout.kowalczyk.com.app.services.security.UserRoleService;

import java.util.stream.Collectors;

/**
 * Created by JK on 2017-04-04.
 */
@Component
public class UserDetailsMapper extends ModelMapperImpl<UserDetails, UserDetailsDTO> {

    @Autowired
    private UserRoleService userRoleService;

    @Override
    protected UserDetails buildBO(UserDetailsDTO objectDTO) {
        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName(objectDTO.getFirstName());
        userDetails.setLastName(objectDTO.getLastName());
        userDetails.setBirthDay(objectDTO.getBirthDay());
        userDetails.setEmail(objectDTO.getEmail());
        userDetails.setEnabled(objectDTO.getEnabled());
        userDetails.setLogin(objectDTO.getLogin());
        userDetails.setHashedPassword(objectDTO.getHashedPassword());
        userDetails.setUserRoles(objectDTO.getUserRoles().stream().map(userRoleDTO -> userRoleService.getObject(userRoleDTO)).collect(Collectors.toSet()));
        return userDetails;
    }

    @Override
    protected UserDetailsDTO buildDTO(UserDetails modelObject) {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setFirstName(modelObject.getFirstName());
        userDetailsDTO.setLastName(modelObject.getLastName());
        userDetailsDTO.setBirthDay(modelObject.getBirthDay());
        userDetailsDTO.setEmail(modelObject.getEmail());
        userDetailsDTO.setEnabled(modelObject.getEnabled());
        userDetailsDTO.setLogin(modelObject.getLogin());
        userDetailsDTO.setHashedPassword(modelObject.getHashedPassword());
        userDetailsDTO.setUserRoles(modelObject.getUserRoles().stream().map(ModelObject::getId).collect(Collectors.toSet()));
        return null;
    }
}
