package com.dev.users.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.users.dto.CreateUserStatusDto;
import com.dev.users.models.UserStatus;
import com.dev.users.services.UserStatusService;

@RestController
public class UserStatusController {

  final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  private final UserStatusService userStatusService;

  public UserStatusController(final UserStatusService userStatusService) {
    this.userStatusService = userStatusService;
  }

  @GetMapping("/status")
  public ResponseEntity<List<UserStatus>> allStatus() {
    try {
      final List<UserStatus> statusList = this.userStatusService.allStatus();
      return new ResponseEntity<>(statusList, HttpStatus.OK);
    } catch (Exception e) {
      LOGGER.info(e.getMessage());
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/status")
  public ResponseEntity<UserStatus> createStatus(@RequestBody final CreateUserStatusDto statusDto) {
    try {
      final UserStatus status = this.userStatusService.createStatus(statusDto);
      return new ResponseEntity<>(status, HttpStatus.CREATED);
    } catch (Exception e) {
      LOGGER.info(e.getMessage());
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
