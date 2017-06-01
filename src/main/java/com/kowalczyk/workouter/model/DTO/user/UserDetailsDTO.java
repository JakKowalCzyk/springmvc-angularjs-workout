package com.kowalczyk.workouter.model.DTO.user;

import com.kowalczyk.workouter.model.DTO.ObjectDTO;

import java.util.*;

/**
 * Created by JK on 2017-04-04.
 */
public class UserDetailsDTO extends ObjectDTO {

    private String login;
    private String hashedPassword;
    private Set<Long> roles = new HashSet<Long>();
    private String firstName;
    private String lastName;
    private Date birthDay;
    private String email;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean accountNonLocked;
    private List<Long> userWeightList = new ArrayList<>();
    private List<Long> userNotes = new ArrayList<>();
    private List<Long> userInfoList = new ArrayList<>();
    private List<Long> workouts = new ArrayList<>();

    public UserDetailsDTO() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public Set<Long> getRoles() {
        return roles;
    }

    public void setRoles(Set<Long> roles) {
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public List<Long> getUserWeightList() {
        return userWeightList;
    }

    public void setUserWeightList(List<Long> userWeightList) {
        this.userWeightList = userWeightList;
    }

    public List<Long> getUserNotes() {
        return userNotes;
    }

    public void setUserNotes(List<Long> userNotes) {
        this.userNotes = userNotes;
    }

    public List<Long> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<Long> userInfoList) {
        this.userInfoList = userInfoList;
    }

    public List<Long> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Long> workouts) {
        this.workouts = workouts;
    }
}
