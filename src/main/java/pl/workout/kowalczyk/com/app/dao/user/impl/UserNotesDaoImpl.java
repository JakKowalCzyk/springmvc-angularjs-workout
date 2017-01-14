package pl.workout.kowalczyk.com.app.dao.user.impl;

import org.springframework.stereotype.Repository;
import pl.workout.kowalczyk.com.app.dao.impl.BaseDaoImpl;
import pl.workout.kowalczyk.com.app.dao.user.UserNotesDao;
import pl.workout.kowalczyk.com.app.model.BO.user.UserNotes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-09-23.
 */
@Repository
public class UserNotesDaoImpl extends BaseDaoImpl<UserNotes> implements UserNotesDao {

    private static final String getByUserIdSql = "SELECT o FROM UserNotes o  join o.user_id as userid where userid.userId = :userId";
    private static final String getSingleNoteSql = "SELECT o FROM UserNotes o join o.user_id as userid where userid.userId = :userId and o.date = :date";

    @PersistenceContext
    private EntityManager entityManager;

    public List<UserNotes> getUserNotesByUserId(int userId) {
        TypedQuery<UserNotes> typedQuery = entityManager.createQuery(getByUserIdSql, UserNotes.class);
        typedQuery.setParameter("userId", userId);
        List<UserNotes> userNotesList = typedQuery.getResultList();
        return userNotesList;
    }

    public List<UserNotes> getSingleNoteByDate(int userId, Date date) {
        TypedQuery<UserNotes> typedQuery = entityManager.createQuery(getSingleNoteSql, UserNotes.class);
        typedQuery.setParameter("userId", userId);
        typedQuery.setParameter("date", date);
        List<UserNotes> userNotes = typedQuery.getResultList();
        return userNotes;
    }
}