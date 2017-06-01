package com.kowalczyk.workouter.model.BO.user;

import com.kowalczyk.workouter.model.BO.ModelObject;
import com.kowalczyk.workouter.model.BO.exercise.Workout;
import com.kowalczyk.workouter.model.BO.security.Role;
import com.kowalczyk.workouter.model.BO.user.impl.UserInfo;
import com.kowalczyk.workouter.model.BO.user.impl.UserNotes;
import com.kowalczyk.workouter.model.BO.user.impl.UserWeight;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.*;

/**
 * Created by JK on 2016-12-12.
 */
@Entity
public class UserDetails extends ModelObject {
    private String login;
    private String hashedPassword;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean accountNonLocked;
    private Set<Role> roles = new HashSet<>();
    private String firstName;
    private String lastName;
    private Date birthDay;
    private String email;
    private List<UserWeight> userWeightList = new ArrayList<>();
    private List<UserNotes> userNotes = new ArrayList<>();
    private List<UserInfo> userInfoList = new ArrayList<>();
    private List<Workout> workouts = new ArrayList<>();

    public UserDetails() {
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

    public void setHashedPassword(String password) {
        this.hashedPassword = password;
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

    @ManyToMany
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = javax.persistence.CascadeType.REMOVE)
    public List<UserWeight> getUserWeightList() {
        return userWeightList;
    }

    public void setUserWeightList(List<UserWeight> userWeightList) {
        this.userWeightList = userWeightList;
    }

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    public List<UserNotes> getUserNotes() {
        return userNotes;
    }

    public void setUserNotes(List<UserNotes> userNotes) {
        this.userNotes = userNotes;
    }

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }
}
