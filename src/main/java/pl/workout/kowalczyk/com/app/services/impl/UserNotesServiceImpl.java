package pl.workout.kowalczyk.com.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.workout.kowalczyk.com.app.dao.UserDetailsDao;
import pl.workout.kowalczyk.com.app.dao.UserNotesDao;
import pl.workout.kowalczyk.com.app.model.BO.UserDetails;
import pl.workout.kowalczyk.com.app.model.BO.UserNotes;
import pl.workout.kowalczyk.com.app.model.DTO.UserNotesDTO;
import pl.workout.kowalczyk.com.app.services.UserNotesService;

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
    private UserDetailsDao userDetailsDao;

    @Override
    public UserNotes mapUserNotesDtoToBo(UserNotesDTO userNotesDTO) {
        return new UserNotes(userDetailsDao.get(userNotesDTO.getUser_id()),  userNotesDTO.getNote(), userNotesDTO.getDate());
    }

    @Override
    public UserNotesDTO mapUserNotesBoToDto(UserNotes userNotes) {
        return new UserNotesDTO(userNotes.getUserNotes_id(), userNotes.getUser_id().getUserId(), userNotes.getNote(), userNotes.getDate());
    }

    public void saveUserNotes(UserNotesDTO userNotesDto) {
        userNotesDao.save(mapUserNotesDtoToBo(userNotesDto));
    }

    public void updateUserNotes(UserNotesDTO userNotesDTO) {
        UserNotes userNotes = mapUserNotesDtoToBo(userNotesDTO);
        userNotes.setUserNotes_id(userNotesDTO.getUserNotesId());
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
