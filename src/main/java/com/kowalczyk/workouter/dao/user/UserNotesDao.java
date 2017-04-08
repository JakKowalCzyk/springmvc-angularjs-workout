package com.kowalczyk.workouter.dao.user;

import com.kowalczyk.workouter.dao.BaseDao;
import com.kowalczyk.workouter.model.BO.user.impl.UserNotes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface UserNotesDao extends BaseDao<UserNotes> {

    @Query("SELECT o FROM UserNotes o  join o.user as userid where userid.id = :userId")
    List<UserNotes> getUserNotesByUserId(@Param("userId") Long userId);

    @Query("SELECT o FROM UserNotes o join o.user as userid where userid.id = :userId and o.date = :date")
    List<UserNotes> getSingleNoteByDate(@Param("userId") Long userId, @Param("date") Date date);
}
