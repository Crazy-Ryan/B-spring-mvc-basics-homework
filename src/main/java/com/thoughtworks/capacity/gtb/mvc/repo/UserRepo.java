package com.thoughtworks.capacity.gtb.mvc.repo;

import com.thoughtworks.capacity.gtb.mvc.model.User;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepo {
    private List<User> allUsers;

    public UserRepo() {
        this.allUsers = new ArrayList<>();
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public void addNewUser(User user) {
        allUsers.add(user);
    }

    public Optional<User> getUserByName(String username){
        return allUsers.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }
}
