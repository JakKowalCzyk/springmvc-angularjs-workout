package pl.workout.kowalczyk.com.app.mapper.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.workout.kowalczyk.com.app.mapper.impl.ModelMapperImpl;
import pl.workout.kowalczyk.com.app.model.BO.user.User;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserDTO;
import pl.workout.kowalczyk.com.app.services.security.UserDetailsService;

/**
 * Created by JK on 2017-02-18.
 */
@Component
public class UserMapper extends ModelMapperImpl<User, UserDTO> {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected User buildBO(UserDTO objectDTO) {
        User user = new User();
        user.setBirthDay(objectDTO.getBirthDay());
        user.setEmail(objectDTO.getEmail());
        user.setFirstName(objectDTO.getFirstName());
        user.setLastName(objectDTO.getLastName());
        user.setUserDetails(userDetailsService.getObject(objectDTO.getUserDetails()));
        return user;
    }

    @Override
    protected UserDTO buildDTO(User modelObject) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(modelObject.getFirstName());
        userDTO.setLastName(modelObject.getLastName());
        userDTO.setEmail(modelObject.getEmail());
        userDTO.setBirthDay(modelObject.getBirthDay());
        userDTO.setUserDetails(modelObject.getUserDetails().getId());
        return userDTO;
    }
}
