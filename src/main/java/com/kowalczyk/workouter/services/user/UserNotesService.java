package com.kowalczyk.workouter.services.user;

import com.kowalczyk.workouter.model.BO.user.impl.UserNote;
import com.kowalczyk.workouter.services.ModelService;

import java.util.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface UserNotesService extends ModelService<UserNote> {

    List<UserNote> getUserNotesByUserId(Long userId);

    List<UserNote> getNotesByDate(Long userId, Date date);
}
