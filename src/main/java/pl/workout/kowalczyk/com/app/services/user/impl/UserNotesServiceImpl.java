package pl.workout.kowalczyk.com.app.services.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workout.kowalczyk.com.app.dao.security.UserDetailsDao;
import pl.workout.kowalczyk.com.app.dao.user.UserNotesDao;
import pl.workout.kowalczyk.com.app.model.BO.user.UserNotes;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserNotesDTO;
import pl.workout.kowalczyk.com.app.services.user.UserNotesService;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by JK on 2016-10-26.
 */
@Service
public class UserNotesServiceImpl  implements UserNotesService{
    @Autowired
    private UserNotesDao userNotesDao;
    @Autowired
    private UserDetailsDao userDetailsDao;

    @Override
    public UserNotes mapUserNotesDtoToBo(UserNotesDTO userNotesDTO) {
        return new UserNotes(userDetailsDao.get(userNotesDTO.getUser_id()),  userNotesDTO.getNote(), userNotesDTO.getDate());
    }

    @Override
    public UserNotesDTO mapUserNotesBoToDto(UserNotes userNotes) {
        return new UserNotesDTO(userNotes.getId(), userNotes.getUser_id().getId(), userNotes.getNote(), userNotes.getDate());
    }

    public void saveUserNotes(UserNotesDTO userNotesDto) {
        userNotesDao.save(mapUserNotesDtoToBo(userNotesDto));
    }

    public void updateUserNotes(UserNotesDTO userNotesDTO) {
        UserNotes userNotes = mapUserNotesDtoToBo(userNotesDTO);
        userNotes.setId(userNotesDTO.getId());
        userNotesDao.update(userNotes);
    }

    public void deleteUserNotes(Integer noteId) {
        UserNotes userNotes = userNotesDao.get(noteId);
        userNotesDao.delete(userNotes);
    }

    public List<UserNotesDTO> getUserNotesByUserId(int userId) {
        return userNotesDao.getUserNotesByUserId(userId).stream().map(this::mapUserNotesBoToDto).collect(Collectors.toList());
    }

    public List<UserNotesDTO> getNotesByDate(int userId, Date date) {
        return userNotesDao.getSingleNoteByDate(userId, date).stream().map(this::mapUserNotesBoToDto).collect(Collectors.toList());
    }
}
