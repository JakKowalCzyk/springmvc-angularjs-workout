package com.kowalczyk.workouter.services.user.impl;

import com.kowalczyk.workouter.dao.user.UserNotesDao;
import com.kowalczyk.workouter.model.BO.user.impl.UserNotes;
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
