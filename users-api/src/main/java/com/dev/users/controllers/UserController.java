package com.dev.users.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.users.dto.CreateUserDto;
import com.dev.users.models.User;
import com.dev.users.services.UserService;

@RestController
public class UserController {

  final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users")
  public ResponseEntity<List<User>> allUsers() {
    try {
      final List<User> users = this.userService.allUsers();
      return new ResponseEntity<>(users, HttpStatus.OK);
    } catch (Exception e) {
      LOGGER.info(e.getMessage());
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/users")
  public ResponseEntity<User> createUser(@RequestBody final CreateUserDto user) {
    try {
      final User savedUser = this.userService.createUser(user);
      return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    } catch (Exception e) {
      LOGGER.info(e.getMessage());
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/users")
  public ResponseEntity<User> updateUser(@RequestBody final User user) {
    try {
      final User savedUser = this.userService.updateUser(user);
      if (savedUser != null) {
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
      }
      throw new Exception("Not found user");
    } catch (Exception e) {
      LOGGER.info(e.getMessage());
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable final Long id) {
    this.userService.deleteUser(id);
  }

}
