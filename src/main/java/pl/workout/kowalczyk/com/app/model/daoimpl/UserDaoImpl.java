package pl.workout.kowalczyk.com.app.model.daoimpl;

import org.springframework.stereotype.Repository;
import pl.workout.kowalczyk.com.app.model.dao.UserDao;
import pl.workout.kowalczyk.com.app.model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Created by JK on 2016-09-07.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    private static final String selectUserByLogin = "SELECT o FROM User AS o where o.login = :login";

    public User getByLogin(String login) {
        if(login == null || login.length()==0) throw new IllegalArgumentException("The name argument is required");
        try{
            TypedQuery<User> query = entityManager.createQuery(selectUserByLogin, User.class);
            query.setParameter("login", login);
            User user = query.getSingleResult();
            return user;
        }catch (NoResultException no){
            return null;
        }
    }
}
