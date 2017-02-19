package pl.workout.kowalczyk.com.app.model.DTO.user;

import pl.workout.kowalczyk.com.app.model.DTO.ObjectDTO;

import java.sql.Date;

/**
 * Created by JK on 2016-11-18.
 */
public class UserWeightDTO extends ObjectDTO {

    private Long userId;

    private Integer weightKg;

    private Date date;

    public UserWeightDTO() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(Integer weightKg) {
        this.weightKg = weightKg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
