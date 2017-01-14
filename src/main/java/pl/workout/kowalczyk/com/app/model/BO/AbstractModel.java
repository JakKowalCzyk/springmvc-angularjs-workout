package pl.workout.kowalczyk.com.app.model.BO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by JK on 2017-01-14.
 */
@MappedSuperclass
public class AbstractModel {

    private Integer id;

    public AbstractModel() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
