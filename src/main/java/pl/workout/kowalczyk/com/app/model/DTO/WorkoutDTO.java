package pl.workout.kowalczyk.com.app.model.DTO;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-11-18.
 */
public class WorkoutDTO extends BaseModel{
    private Integer workout_id ;

    private Integer user_id;

    private Date date;

    public WorkoutDTO() {
    }

    public WorkoutDTO(Integer workout_id, Integer user_id, Date date) {
        this.workout_id = workout_id;
        this.user_id = user_id;
        this.date = date;

    }

    public Integer getWorkout_id() {
        return workout_id;
    }

    public void setWorkout_id(Integer workout_id) {
        this.workout_id = workout_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
