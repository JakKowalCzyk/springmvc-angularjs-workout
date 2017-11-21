package com.kowalczyk.workouter.controllers;

import com.google.gson.Gson;
import com.kowalczyk.workouter.AbstractTestHelper;
import com.kowalczyk.workouter.controllers.security.RoleController;
import com.kowalczyk.workouter.controllers.user.UserController;
import com.kowalczyk.workouter.controllers.user.UserInfoController;
import com.kowalczyk.workouter.enums.ExerciseType;
import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.model.DTO.ObjectDTO;
import com.kowalczyk.workouter.model.DTO.exercise.ExerciseDTO;
import com.kowalczyk.workouter.model.DTO.exercise.WorkoutDTO;
import com.kowalczyk.workouter.model.DTO.exercise.WorkoutExerciseDTO;
import com.kowalczyk.workouter.model.DTO.security.RoleDTO;
import com.kowalczyk.workouter.model.DTO.user.UserDTO;
import com.kowalczyk.workouter.model.DTO.user.impl.UserInfoDTO;
import com.kowalczyk.workouter.model.DTO.user.impl.UserNoteDTO;
import com.kowalczyk.workouter.model.DTO.user.impl.UserWeightDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;

/**
 * Created by JK on 2017-02-01.
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractControllerTest extends AbstractTestHelper {

    protected Long userDetailsId1;
    protected Long userDetailsId2;
    protected MockMvc mvc;

    @Autowired
    protected UserController userController;
    @Autowired
    protected UserInfoController userInfoController;
    @Autowired
    protected RoleController roleController;
    @Autowired
    private WebApplicationContext context;

    @MockBean
    private JavaMailSender javaMailSender;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
        roleController.addObject(buildRoleDTOTest(RoleType.USER));
        addUserDetailsUserInfo1();
        addUserDetailsUserInfo2();
    }

    @After
    public void tearDown() throws Exception {
        List<UserDTO> userDTOS = userController.findAll();
        new ArrayList<>(userDTOS).forEach(userDetailsDTO -> {
            userController.deleteObject(userDetailsDTO.getId());
            assertFalse(userController.isExist(userDetailsDTO.getId()));
        });
        List<RoleDTO> roleDTOS = roleController.findAll();
        new ArrayList<>(roleDTOS).forEach(roleDTO -> {
            roleController.deleteObject(roleDTO.getId());
            assertFalse(roleController.isExist(roleDTO.getId()));
        });
        userDetailsId1 = null;
        userDetailsId2 = null;
    }

    private void addUserDetailsUserInfo1() {
        UserDTO userDTO = getUserDetailsDTOTest("log1", "n1", "la1");
        userDTO.setRoles(Stream.of(roleController.findAll().stream().findAny().get().getId()).collect(Collectors.toSet()));
        userDTO = userController.addObject(userDTO);
        userDetailsId1 = userDTO.getId();
    }

    private void addUserDetailsUserInfo2() {
        UserDTO userDTO = getUserDetailsDTOTest("log2", "n2", "la2");
        userDTO.setRoles(Stream.of(roleController.findAll().stream().findAny().get().getId()).collect(Collectors.toSet()));
        userDTO = userController.addObject(userDTO);
        userDetailsId2 = userDTO.getId();
    }

    protected UserInfoDTO getUserInfoDTO(Long userId) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserId(userId);
        return userInfoDTO;
    }

    protected UserWeightDTO getUserWeightDTOTest(int weight, GregorianCalendar date) {
        UserWeightDTO userWeightDTO = new UserWeightDTO();
        userWeightDTO.setDate(date.getTime());
        userWeightDTO.setWeightKg(weight);
        userWeightDTO.setUserId(userDetailsId1);
        return userWeightDTO;
    }

    protected UserNoteDTO createUserNotesTest(Date date, String note, Long userDetailsId) {
        UserNoteDTO userNoteDTO = new UserNoteDTO();
        userNoteDTO.setDate(date);
        userNoteDTO.setNote(note);
        userNoteDTO.setUserId(userDetailsId);
        return userNoteDTO;
    }

    protected ExerciseDTO createExerciseDTOTest(String name, String description, ExerciseType exerciseType) {
        ExerciseDTO exerciseDTO = new ExerciseDTO();
        exerciseDTO.setName(name);
        exerciseDTO.setDescription(description);
        exerciseDTO.setExerciseType(exerciseType);
        return exerciseDTO;
    }

    protected WorkoutDTO createWorkoutDTOTest(Date date, Long userId) {
        WorkoutDTO workoutDTO = new WorkoutDTO();
        workoutDTO.setDate(date);
        workoutDTO.setUserId(userId);
        return workoutDTO;
    }

    protected WorkoutExerciseDTO createWorkoutExerciseDTOTest(WorkoutDTO workoutDTO, ExerciseDTO exerciseDTO, int repeat, int series) {
        WorkoutExerciseDTO workoutExerciseDTO = new WorkoutExerciseDTO();
        workoutExerciseDTO.setWorkoutId(workoutDTO.getId());
        workoutExerciseDTO.setExerciseId(exerciseDTO.getId());
        workoutExerciseDTO.setRepeat(repeat);
        workoutExerciseDTO.setSeries(series);
        return workoutExerciseDTO;
    }

    protected String getContentJson(ObjectDTO objectDTO) {
        Gson gson = new Gson();
        return gson.toJson(objectDTO);
    }
}
