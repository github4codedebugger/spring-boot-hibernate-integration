package com.orm.controller;

import com.orm.model.User;
import com.orm.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        return userRepo.saveUser(user);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAll() {
        return userRepo.findAll();
    }


}
