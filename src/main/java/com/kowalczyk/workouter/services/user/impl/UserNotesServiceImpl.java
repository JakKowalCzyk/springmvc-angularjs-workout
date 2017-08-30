package com.kowalczyk.workouter.services.user.impl;

import com.kowalczyk.workouter.dao.user.UserNotesDAO;
import com.kowalczyk.workouter.model.BO.user.impl.UserNote;
import com.kowalczyk.workouter.services.impl.ModelServiceImpl;
import com.kowalczyk.workouter.services.user.UserNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
@Service
public class UserNotesServiceImpl extends ModelServiceImpl<UserNote> implements UserNotesService {

    @Autowired
    public UserNotesServiceImpl(UserNotesDAO baseDao) {
        super(baseDao);
    }

    @Override
    public void deleteObject(Long id) {
        removeUserNoteFromUser(id);
        super.deleteObject(id);
    }

    private void removeUserNoteFromUser(Long id) {
        UserNote userNoteToDelete = super.getObject(id);
        userNoteToDelete.getUser().getUserNotes().remove(userNoteToDelete);
    }

    public List<UserNote> getUserNotesByUserId(Long userId) {
        return ((UserNotesDAO) getBaseDao()).getUserNotesByUserId(userId);
    }

    public List<UserNote> getNotesByDate(Long userId, Date date) {
        return ((UserNotesDAO) getBaseDao()).getSingleNoteByDate(userId, date);
    }
}
