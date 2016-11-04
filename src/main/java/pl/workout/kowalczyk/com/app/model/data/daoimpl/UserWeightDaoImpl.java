package pl.workout.kowalczyk.com.app.model.data.daoimpl;

import org.springframework.stereotype.Repository;
import pl.workout.kowalczyk.com.app.model.data.dao.UserWeightDao;
import pl.workout.kowalczyk.com.app.model.data.entity.UserWeight;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-09-23.
 */
@Repository
public class UserWeightDaoImpl extends BaseDaoImpl<UserWeight> implements UserWeightDao {

    private static final String getByUserIdSql = "SELECT o FROM UserWeight o WHERE o.user_id = :userId";
    private static final String getByUserIdAndDateSql = "SELECT o FROM UserWeight o WHERE o.user_id = :userId and o.data = :date";
    private static final String getLastWeight = "SELECT o FROM UserWeight o where o.userId = :userId order by o.date  ";
    @PersistenceContext
    private EntityManager entityManager;

    public List<UserWeight> getWeightByUserId(int userId) {
        TypedQuery<UserWeight> typedQuery = entityManager.createQuery(getByUserIdSql, UserWeight.class);
        typedQuery.setParameter("userId", userId);
        List<UserWeight> userWeightsList = typedQuery.getResultList();
        return userWeightsList;
    }

    public UserWeight getByUserIdAndDate(int userId, Date date) {
        TypedQuery<UserWeight> typedQuery = entityManager.createQuery(getByUserIdAndDateSql, UserWeight.class);
        typedQuery.setParameter("userId", userId);
        typedQuery.setParameter("date", date);
        UserWeight userWeight = typedQuery.getSingleResult();
        return userWeight;
    }

    @Override
    public UserWeight getLastUserWeight(int userId) {
        Query query = entityManager.createQuery(getLastWeight, UserWeight.class);
        query.setParameter("userId", userId);
        query.setMaxResults(1);
        UserWeight userWeight = (UserWeight) query.getSingleResult();
        return userWeight;
    }
}
