package ru.netology.RestHomework2_my.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class User {
    @NotBlank(message = "User is needed")
    private String user;
    @NotBlank(message = "Password is needed")
    @Size(min = 3, message = "Password's length must be more then 3")
    private String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public User() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
