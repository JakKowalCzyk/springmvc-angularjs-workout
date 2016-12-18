package pl.workout.kowalczyk.com.app.services;

import pl.workout.kowalczyk.com.app.model.BO.User;
import pl.workout.kowalczyk.com.app.model.DTO.UserDTO;

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
