package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.config.UserExistsException;
import com.thoughtworks.capacity.gtb.mvc.config.UsernamePasswordMismatchException;
import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.repo.UserRepo;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void userRegister(User user) {
        if (userRepo.getUserByName(user.getUsername()).isPresent()) {
            throw new UserExistsException("the username is taken");
        } else {
            userRepo.addNewUser(user);
        }
    }

    public User userLogin(String username, String password) {
        Optional<User> user = userRepo.getUserByName(username);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        } else {
            throw new UsernamePasswordMismatchException("username and password does not match");
        }
    }

}
