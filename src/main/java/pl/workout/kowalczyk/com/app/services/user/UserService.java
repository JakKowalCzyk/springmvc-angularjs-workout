package pl.workout.kowalczyk.com.app.services.user;

import pl.workout.kowalczyk.com.app.model.BO.user.User;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserDTO;

/**
 * Created by JK on 2016-10-26.
 */
public interface UserService{

    User mapUserDtoToBo(UserDTO userDTO);

    UserDTO mapUserBoToDto(User user);

    UserDTO getUserByLogin(String login);

    void saveUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);
}
