package pl.workout.kowalczyk.com.app.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.workout.kowalczyk.com.app.dao.UserDao;
import pl.workout.kowalczyk.com.app.model.BO.User;
import pl.workout.kowalczyk.com.app.model.DTO.UserDTO;
import pl.workout.kowalczyk.com.app.services.service.UserService;

/**
 * Created by JK on 2016-10-26.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User mapUserDtoToBo(UserDTO userDTO) {
        return new User(userDTO.getUserId(), userDTO.getLogin(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getBirthDay(), userDTO.getEmail(), userDTO.getPassword());
    }

    @Override
    public UserDTO mapUserBoToDto(User user) {
        return new UserDTO(user.getUser_id(), user.getLogin(), user.getFirstName(), user.getLastName(), user.getBirthDay(), user.getEmail(), user.getPassword());
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
