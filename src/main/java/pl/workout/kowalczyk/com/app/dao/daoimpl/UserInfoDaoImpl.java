package pl.workout.kowalczyk.com.app.dao.daoimpl;

import org.springframework.stereotype.Repository;
import pl.workout.kowalczyk.com.app.dao.UserInfoDao;
import pl.workout.kowalczyk.com.app.model.BO.Exercise;
import pl.workout.kowalczyk.com.app.model.BO.UserInfo;
import pl.workout.kowalczyk.com.app.model.BO.UserWeight;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Created by JK on 2016-10-10.
 */
@Repository
public class UserInfoDaoImpl extends BaseDaoImpl<UserInfo> implements UserInfoDao {

    private static final String getByUserIdSql = "SELECT o FROM UserInfo o " +
            "inner join o.user_id as user " +
            "where user.id = :userId";
    private static final String getActualWeightSql = "select o FROM UserWeight o inner join o.userInfo_id as ui " +
            "inner join ui.user_id as user " +
            "where user.userId = :userId";
    private static final String getFavouriteExerciseSql = "select o FROM Exercise o inner join o.userInfo_id as userInfo " +
            "inner join userInfo.user_id as user " +
            "where user.userId = :userId";

    @PersistenceContext
    private EntityManager entityManager;

    public UserInfo getUserInfoByUserId(int userId) {
        TypedQuery<UserInfo> typedQuery = entityManager.createQuery(getByUserIdSql, UserInfo.class);
        typedQuery.setParameter("userId", userId);
        return typedQuery.getSingleResult();
    }

    public UserWeight getActualWeight(int userId) {
        TypedQuery<UserWeight> typedQuery = entityManager.createQuery(getActualWeightSql, UserWeight.class);
        typedQuery.setParameter("userId", userId);
        return typedQuery.getSingleResult();
    }

    public Exercise getFavouriteExercise(int userId) {
        TypedQuery<Exercise> typedQuery = entityManager.createQuery(getFavouriteExerciseSql, Exercise.class);
        typedQuery.setParameter("userId", userId);
        return typedQuery.getSingleResult();
    }
}
