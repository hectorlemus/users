package com.dev.users.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
  
}
