package pl.workout.kowalczyk.com.app.services.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workout.kowalczyk.com.app.dao.user.UserDao;
import pl.workout.kowalczyk.com.app.model.BO.user.User;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserDTO;
import pl.workout.kowalczyk.com.app.services.user.UserService;

/**
 * Created by JK on 2016-10-26.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User mapUserDtoToBo(UserDTO userDTO) {
        return new User(userDTO.getId(),userDTO.getUserDetails(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getBirthDay(), userDTO.getEmail());
    }

    @Override
    public UserDTO mapUserBoToDto(User user) {
        return new UserDTO(user.getId(),user.getUserDetails(), user.getFirstName(), user.getLastName(), user.getBirthDay(), user.getEmail());
    }

    public UserDTO getUserByLogin(String login){
        return mapUserBoToDto(userDao.getByLogin(login));
    }

    public void saveUser(UserDTO userDTO){
        userDao.save(mapUserDtoToBo(userDTO));
    }

    public void updateUser(UserDTO userDTO){
        userDao.update(mapUserDtoToBo(userDTO));
    }
}
