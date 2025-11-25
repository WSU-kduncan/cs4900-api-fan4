package com.Fan4.Collectiviews.demo.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.Fan4.Collectiviews.demo.dto.UserDto;
import com.Fan4.Collectiviews.demo.mapper.UserDtoMapper;
import com.Fan4.Collectiviews.demo.model.User;
import com.Fan4.Collectiviews.demo.repository.UserRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

  // Interface to repository
  private final UserRepository userRepository;

  private final UserDtoMapper userDtoMapper;

  /* Business Logic Methods */
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(String username) {
    return userRepository
        .findById(username)
        .orElseThrow(() -> new EntityNotFoundException("User (" + username + ") not found"));
  }

  // Get user by exact name match
  public User getUserByExactName(String name) {
    return userRepository
        .findByName(name)
        .orElseThrow(() -> new EntityNotFoundException("User with name(" + name + ") not found"));
  }

  public List<User> getUsersByString(String name) {
    List<User> users = userRepository.findByNameContainingIgnoreCase(name);

    if (users.isEmpty()) {
      throw new EntityNotFoundException("No users found with name containing (" + name + ")");
    }

    return users;
  }

  /**
   * Creates a new User in the database
   *
   * @param user
   * @return The User entity
   * @throws EntityExistsException
   */
  @Transactional
  public User createUser(User user) throws EntityExistsException {
    // Input validation
    validateUserInput(user);

    // Try saving new user and let database handle uniqueness
    try {
      return userRepository.saveAndFlush(user);
    } catch (DataIntegrityViolationException e) {
      throw new EntityExistsException(
          "User with that username (" + user.getUsername() + ") already exists");
    }
  }

  /**
   * Validates a new User before saving to the database
   *
   * @param user
   *
   */
  private void validateUserInput(User user) {
    // Null check the entity
    if (user == null) {
      throw new IllegalArgumentException("User cannot be null");
    }

    // Null check the input
    if (user.getUsername() == null) {
      throw new IllegalArgumentException("Username can't be null or empty");
    }

    // Set a default password if null
    if (user.getPassword_hash() == null) {
      user.setPassword_hash("default_password");
    }

    // Add anymore rules below
    // eg (username must be between 3-30 characters)
  }

  @Transactional
  public User saveUser(String username, UserDto requestBody) throws EntityNotFoundException {
    // Find the existing user
    User existingUser = getUserById(username);

    // Update just a few fields for now
    existingUser.setName(requestBody.getName());
    existingUser.setBirthDate(requestBody.getBirthDate());

    return userRepository.save(existingUser);
  }

  public void deleteUser(String username) throws EntityNotFoundException {
    try {
      // Checks for existance before deletion
      userRepository
        .findById(username)
        .orElseThrow(() -> new EntityNotFoundException("User (" + username + ") not found"));
      userRepository.deleteById(username);
    } catch (Error e) {
      throw new EntityNotFoundException("Provided User does not exist");
    }
  }
}
