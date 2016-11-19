package pl.workout.kowalczyk.com.app.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.workout.kowalczyk.com.app.dao.UserDao;
import pl.workout.kowalczyk.com.app.dao.UserNotesDao;
import pl.workout.kowalczyk.com.app.model.BO.UserNotes;
import pl.workout.kowalczyk.com.app.model.DTO.UserNotesDTO;
import pl.workout.kowalczyk.com.app.services.service.UserNotesService;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by JK on 2016-10-26.
 */
@Service
@Transactional
public class UserNotesServiceImpl  implements UserNotesService{
    @Autowired
    private UserNotesDao userNotesDao;
    @Autowired
    private UserDao userDao;

    @Override
    public UserNotes mapUserNotesDtoToBo(UserNotesDTO userNotesDTO) {
        return new UserNotes(userNotesDTO.getUserNotesId(), userDao.get(userNotesDTO.getUser_id()),  userNotesDTO.getNote(), userNotesDTO.getDate());
    }

    @Override
    public UserNotesDTO mapUserNotesBoToDto(UserNotes userNotes) {
        return new UserNotesDTO(userNotes.getUserNotes_id(), userNotes.getUser_id().getUser_id(), userNotes.getNote(), userNotes.getDate());
    }

    public void saveUserNotes(UserNotesDTO userNotesDto) {
        userNotesDao.save(mapUserNotesDtoToBo(userNotesDto));
    }

    public void updateUserNotes(UserNotesDTO userNotesDTO) {
        userNotesDao.update(mapUserNotesDtoToBo(userNotesDTO));
    }

    public void deleteUserNotes(UserNotesDTO userNotesDTO) {
        userNotesDao.delete(mapUserNotesDtoToBo(userNotesDTO));
    }

    public List<UserNotesDTO> getUserNotesByUserId(int userId) {
        return userNotesDao.getUserNotesByUserId(userId).stream().map(this::mapUserNotesBoToDto).collect(Collectors.toList());
    }

    public UserNotesDTO getSingleNoteByDate(int userId, Date date) {
        return mapUserNotesBoToDto(userNotesDao.getSingleNoteByDate(userId, date));
    }
}
