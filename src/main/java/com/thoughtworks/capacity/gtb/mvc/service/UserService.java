package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void userRegister(User user) {
        userRepo.addNewUser(user);
    }

    public User userLogin(String username, String password) {
        User user = userRepo.getUserByName(username);
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            return new User();
        }
    }

}
