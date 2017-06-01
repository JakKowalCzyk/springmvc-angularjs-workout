package com.kowalczyk.workouter.mapper.user;

import com.kowalczyk.workouter.mapper.AbstractMapperTest;
import com.kowalczyk.workouter.mapper.user.impl.UserWeightMapper;
import com.kowalczyk.workouter.model.BO.user.impl.UserWeight;
import com.kowalczyk.workouter.model.DTO.user.impl.UserWeightDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
        UserWeightDTO userWeightDTO = buildUserWeightDTOTest();
        userWeightDTO.setId(2L);
        UserWeight userWeight = userWeightMapper.mapToBO(userWeightDTO);
        Assert.assertEquals(userWeightDTO.getId(), userWeight.getId());
        assertEquals(userWeightDTO.getDate(), userWeight.getDate());
        assertTrue(userWeightDTO.getWeightKg() == userWeight.getWeightKg());
        Assert.assertEquals(userWeightDTO.getUserId(), userWeight.getUser().getId());
    }

    @Test
    public void mapToDTO() throws Exception {
        UserWeight userWeight = getUserWeightTest();
        UserWeightDTO userWeightDTO = userWeightMapper.mapToDTO(userWeight);
        Assert.assertEquals(userWeight.getId(), userWeightDTO.getId());
        assertEquals(userWeight.getDate(), userWeightDTO.getDate());
        assertTrue(userWeight.getWeightKg() == userWeightDTO.getWeightKg());
        Assert.assertEquals(userWeight.getUser().getId(), userWeightDTO.getUserId());
    }

}