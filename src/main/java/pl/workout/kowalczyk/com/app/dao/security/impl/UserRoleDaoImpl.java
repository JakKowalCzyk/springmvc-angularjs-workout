package pl.workout.kowalczyk.com.app.dao.security.impl;

import org.springframework.stereotype.Repository;
import pl.workout.kowalczyk.com.app.dao.impl.BaseDaoImpl;
import pl.workout.kowalczyk.com.app.dao.security.UserRoleDao;
import pl.workout.kowalczyk.com.app.model.BO.security.UserRole;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by JK on 2016-12-18.
 */
@Repository
public class UserRoleDaoImpl extends BaseDaoImpl<UserRole> implements UserRoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserRole> getUserRolesByLogin(String userLogin) {
        String sql = "select role from UserRole role inner join role.userDetails as user where user.login = :login";
        TypedQuery typedQuery = entityManager.createQuery(sql, UserRole.class);
        typedQuery.setParameter("login", userLogin);
        return typedQuery.getResultList();
    }
}
