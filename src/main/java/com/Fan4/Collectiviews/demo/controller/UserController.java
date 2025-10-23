package com.Fan4.Collectiviews.demo.controller;

import com.Fan4.Collectiviews.demo.dto.UserDto;
import com.Fan4.Collectiviews.demo.mapper.UserDtoMapper;
import com.Fan4.Collectiviews.demo.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(
    path = "user", // Base URL might use in bruno?
    produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

  // Interface between controller and repository
  private final UserService userService;

  private final UserDtoMapper userDtoMapper;

  @GetMapping
  ResponseEntity<List<UserDto>> getAllUsers() {
    return new ResponseEntity<>(userDtoMapper.toDtoList(userService.getAllUsers()), HttpStatus.OK);
  }

  @GetMapping(path = "by-username/{username}")
  ResponseEntity<UserDto> getUserById(@PathVariable String username) {
    System.out.println("=== getUserById called with username: " + username + " ===");
    return new ResponseEntity<UserDto>(
        userDtoMapper.toDto(userService.getUserById(username)), HttpStatus.OK);
  }

  // TODO: implement findByString
  @GetMapping(path = "search/{name}")
  ResponseEntity<UserDto> getUserByExactName(@PathVariable String name) {
    System.out.println("=== getUserByExactName called with username: " + name + " ===");
    return new ResponseEntity<UserDto>(
      userDtoMapper.toDto(userService.getUserByExactName(name)), HttpStatus.OK);
  }

  // Simple test endpoint
  // @GetMapping("/{username}")
  // public ResponseEntity<String> test() {
  //   return ResponseEntity.ok("UserController is working!");
  // }
}
