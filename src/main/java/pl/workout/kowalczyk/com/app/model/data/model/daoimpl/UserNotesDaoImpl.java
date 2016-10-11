package pl.workout.kowalczyk.com.app.model.data.model.daoimpl;

import org.springframework.stereotype.Repository;
import pl.workout.kowalczyk.com.app.model.data.model.dao.UserNotesDao;
import pl.workout.kowalczyk.com.app.model.data.model.entity.UserNotes;

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

    private static final String getByUserIdSql = "SELECT o FROM UserNotes o where o.user_id = :userId";
    private static final String getSingleNoteSql = "SELECT o FROM UserNotes o where o.user_id = :userId and o.date = :date";

    @PersistenceContext
    private EntityManager entityManager;

    public List<UserNotes> getUserNotesByUserId(int userId) {
        TypedQuery<UserNotes> typedQuery = entityManager.createQuery(getByUserIdSql, UserNotes.class);
        typedQuery.setParameter("userId", userId);
        List<UserNotes> userNotesList = typedQuery.getResultList();
        return userNotesList;
    }

    public UserNotes getSingeNoteByDate(int userId, Date date) {
        TypedQuery<UserNotes> typedQuery = entityManager.createQuery(getSingleNoteSql, UserNotes.class);
        typedQuery.setParameter("userId", userId);
        typedQuery.setParameter("date", date);
        UserNotes userNotes = typedQuery.getSingleResult();
        return userNotes;
    }
}
