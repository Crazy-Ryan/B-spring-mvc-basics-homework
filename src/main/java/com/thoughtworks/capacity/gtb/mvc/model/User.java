package com.thoughtworks.capacity.gtb.mvc.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User {
    private int id;
    @NotBlank(message = "empty username")
    @Pattern(regexp = "^([A-Z]|[a-z]|[0-9]|_){3,10}$", message = "illegal username")
    private String username;
    @NotBlank(message = "empty password")
    @Pattern(regexp = "^.{5,12}$", message = "the length of password should be between 5 and 12")
    private String password;
    @Email(message = "invalid email address")
    private String email;
    private static int idCounter = 0;

    public User() {
        this.id = idCounter;
        idCounter+=1;
    }

    public User(final String username, final String password, final String email) {
        idCounter+=1;
        this.id = idCounter++;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
