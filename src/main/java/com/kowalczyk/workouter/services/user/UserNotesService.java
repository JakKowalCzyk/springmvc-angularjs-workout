package com.kowalczyk.workouter.services.user;

import com.kowalczyk.workouter.model.BO.user.impl.UserNotes;
import com.kowalczyk.workouter.services.ModelService;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface UserNotesService extends ModelService<UserNotes> {

    List<UserNotes> getUserNotesByUserId(Long userId);

    List<UserNotes> getNotesByDate(Long userId, Date date);
}
