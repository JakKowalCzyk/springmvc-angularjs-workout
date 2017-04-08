package pl.workout.kowalczyk.com.app.mapper.user;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.workout.kowalczyk.com.app.mapper.AbstractMapperTest;
import pl.workout.kowalczyk.com.app.mapper.user.impl.UserWeightMapper;
import pl.workout.kowalczyk.com.app.model.BO.user.impl.UserWeight;
import pl.workout.kowalczyk.com.app.model.DTO.user.impl.UserWeightDTO;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by JK on 2017-04-06.
 */
public class UserWeightMapperTest extends AbstractMapperTest {

    @Autowired
    private UserWeightMapper userWeightMapper;

    @Test
    public void mapToBO() throws Exception {
        UserWeightDTO userWeightDTO = new UserWeightDTO();
        userWeightDTO.setDate(new GregorianCalendar(2012, 12, 2).getTime());
        userWeightDTO.setId(2L);
        userWeightDTO.setWeightKg(56);
        userWeightDTO.setUserId(getUserDetailsTest().getId());
        UserWeight userWeight = userWeightMapper.mapToBO(userWeightDTO);
        assertEquals(userWeightDTO.getId(), userWeight.getId());
        assertEquals(userWeightDTO.getDate(), userWeight.getDate());
        assertTrue(userWeightDTO.getWeightKg() == userWeight.getWeightKg());
        assertEquals(userWeightDTO.getUserId(), userWeight.getUser().getId());
    }

    @Test
    public void mapToDTO() throws Exception {
        UserWeight userWeight = getUserWeightTest();
        UserWeightDTO userWeightDTO = userWeightMapper.mapToDTO(userWeight);
        assertEquals(userWeight.getId(), userWeightDTO.getId());
        assertEquals(userWeight.getDate(), userWeightDTO.getDate());
        assertTrue(userWeight.getWeightKg() == userWeightDTO.getWeightKg());
        assertEquals(userWeight.getUser().getId(), userWeightDTO.getUserId());
    }

}