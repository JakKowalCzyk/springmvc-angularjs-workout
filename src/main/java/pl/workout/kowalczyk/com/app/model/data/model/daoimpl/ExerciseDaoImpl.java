package pl.workout.kowalczyk.com.app.model.data.model.daoimpl;

import org.springframework.stereotype.Repository;
import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.model.data.model.dao.ExerciseDao;
import pl.workout.kowalczyk.com.app.model.data.model.entity.Exercise;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by JK on 2016-09-23.
 */
@Repository
public class ExerciseDaoImpl extends BaseDaoImpl<Exercise> implements ExerciseDao {

    private static final String getByNameSql = "SELECT o FROM Exercise o where o.name = :name";
    private static final String getForBodyPart = "SELECT o FROM Exercise o where o.exerciseType = :exerciseType";

    @PersistenceContext
    private EntityManager entityManager;

    public Exercise getExerciseByName(String name) {
        TypedQuery<Exercise> typedQuery = entityManager.createQuery(getByNameSql, Exercise.class);
        typedQuery.setParameter("name", name);
        Exercise exercise = typedQuery.getSingleResult();
        return exercise;
    }

    public List<Exercise> getExercisesForBodyPart(ExerciseType exerciseType) {
        TypedQuery<Exercise> typedQuery = entityManager.createQuery(getForBodyPart, Exercise.class);
        typedQuery.setParameter("exerciseType", exerciseType);
        List<Exercise> exerciseList = typedQuery.getResultList();
        return exerciseList;
    }
}
