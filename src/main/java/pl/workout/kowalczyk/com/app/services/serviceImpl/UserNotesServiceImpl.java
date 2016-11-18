package pl.workout.kowalczyk.com.app.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.workout.kowalczyk.com.app.dao.UserNotesDao;
import pl.workout.kowalczyk.com.app.model.BO.UserNotes;
import pl.workout.kowalczyk.com.app.services.service.UserNotesService;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
@Service
@Transactional
public class UserNotesServiceImpl  implements UserNotesService{
    @Autowired
    private UserNotesDao userNotesDao;

    public void saveUserNotes(UserNotes userNotes) {
        userNotesDao.save(userNotes);
    }

    public void updateUserNotes(UserNotes userNotes) {
        userNotesDao.update(userNotes);
    }

    public void deleteUserNotes(UserNotes userNotes) {
        userNotesDao.delete(userNotes);
    }

    public List<UserNotes> getUserNotesByUserId(int userId) {
        return userNotesDao.getUserNotesByUserId(userId);
    }

    public UserNotes getSingleNoteByDate(int userId, Date date) {
        return userNotesDao.getSingleNoteByDate(userId, date);
    }
}
