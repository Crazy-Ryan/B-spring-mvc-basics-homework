package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/login")
    public User userLogin(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password){
        return userService.userLogin(username, password);
    }

    @PostMapping(path = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void userRegister(@RequestBody @Valid User user) {
        userService.userRegister(user);
    }
}
