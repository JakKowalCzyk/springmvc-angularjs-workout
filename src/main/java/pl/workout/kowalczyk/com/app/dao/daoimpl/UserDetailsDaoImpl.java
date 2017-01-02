package pl.workout.kowalczyk.com.app.dao.daoimpl;

import org.springframework.stereotype.Repository;
import pl.workout.kowalczyk.com.app.dao.UserDetailsDao;
import pl.workout.kowalczyk.com.app.model.BO.UserDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Created by JK on 2016-12-18.
 */
@Repository
public class UserDetailsDaoImpl extends BaseDaoImpl<UserDetails> implements UserDetailsDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserDetails getByLogin(String login) {
        String sql = "select u from UserDetails as u where u.login = :login";
        TypedQuery<UserDetails> userDetailsTypedQuery = entityManager.createQuery(sql, UserDetails.class);
        userDetailsTypedQuery.setParameter("login", login);
        return userDetailsTypedQuery.getSingleResult();
    }
}
