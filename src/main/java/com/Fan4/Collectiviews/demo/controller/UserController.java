package com.Fan4.Collectiviews.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.Fan4.Collectiviews.demo.model.User;
import com.Fan4.Collectiviews.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(
    path = "user",  // Base URL might use in bruno?
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE) 
public class UserController {
    
    // Interface between controller and repository
    private UserService userService;
    
    // TODO: implement findAll controller method
    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    // TODO: implement findById

    // TODO: implement findByString


}
