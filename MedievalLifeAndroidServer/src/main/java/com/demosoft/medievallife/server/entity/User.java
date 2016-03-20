package com.demosoft.medievallife.server.entity;

import java.util.Calendar;

/**
 * Created by demos_000 on 20.03.2016.
 */
public class User {

    private String name;
    private String password;
    private String confirmPassword;
    private String secureToken;
    private Calendar lastActivityTime;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String password, String confirmPassword) {
        this.name = name;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isPasswordConfirmed() {
        return password.equals(confirmPassword);
    }

    public String getSecureToken() {
        return secureToken;
    }

    public void setSecureToken(String secureToken) {
        this.secureToken = secureToken;
    }

    public Calendar getLastActivityTime() {
        return lastActivityTime;
    }

    public void setLastActivityTime(Calendar lastActivityTime) {
        this.lastActivityTime = lastActivityTime;
    }
}
