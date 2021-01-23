package com.thoughtworks.capacity.gtb.mvc.model;

public class User {
    private int id;
    private String username;
    private String password;
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
