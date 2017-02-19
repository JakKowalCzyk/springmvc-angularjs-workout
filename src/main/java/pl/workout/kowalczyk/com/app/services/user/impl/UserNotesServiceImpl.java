package pl.workout.kowalczyk.com.app.services.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workout.kowalczyk.com.app.dao.user.UserNotesDao;
import pl.workout.kowalczyk.com.app.model.BO.user.UserNotes;
import pl.workout.kowalczyk.com.app.services.impl.ModelServiceImpl;
import pl.workout.kowalczyk.com.app.services.user.UserNotesService;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
@Service
public class UserNotesServiceImpl extends ModelServiceImpl<UserNotes> implements UserNotesService {

    @Autowired
    public UserNotesServiceImpl(UserNotesDao baseDao) {
        super(baseDao);
    }

    public List<UserNotes> getUserNotesByUserId(Long userId) {
        return ((UserNotesDao) getBaseDao()).getUserNotesByUserId(userId);
    }

    public List<UserNotes> getNotesByDate(Long userId, Date date) {
        return ((UserNotesDao) getBaseDao()).getSingleNoteByDate(userId, date);
    }
}
