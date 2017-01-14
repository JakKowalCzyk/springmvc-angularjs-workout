package pl.workout.kowalczyk.com.app.dao.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.workout.kowalczyk.com.app.dao.BaseDao;
import pl.workout.kowalczyk.com.app.model.BO.user.UserNotes;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface UserNotesDao extends BaseDao<UserNotes> {

    @Query("SELECT o FROM UserNotes o  join o.user_id as userid where userid.id = :userId")
    List<UserNotes> getUserNotesByUserId(@Param("userId") int userId);

    @Query("SELECT o FROM UserNotes o join o.user_id as userid where userid.id = :userId and o.date = :date")
    List<UserNotes> getSingleNoteByDate(@Param("userId") int userId, @Param("date") Date date);
}
