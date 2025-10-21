package com.Fan4.Collectiviews.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.Fan4.Collectiviews.demo.dto.UserDto;
import com.Fan4.Collectiviews.demo.mapper.UserDtoMapper;
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
    private final UserService userService;
    
    private final UserDtoMapper userDtoMapper;

    // TODO: implement findAll controller method
    @GetMapping
    ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(
            userDtoMapper.toDtoList(userService.getAllUsers()), HttpStatus.OK
        );
    }

    // TODO: implement findById
    @GetMapping(path = "{username}")
    ResponseEntity<UserDto> getUserById(@PathVariable String username) {
        return new ResponseEntity<UserDto>(
            userDtoMapper.toDto(userService.getUserById(username)), HttpStatus.OK
        );
    }
    // TODO: implement findByString


}
