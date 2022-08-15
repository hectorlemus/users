package com.dev.users.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.users.converters.UserStateConverter;
import com.dev.users.dto.CreateUserStatusDto;
import com.dev.users.models.UserStatus;
import com.dev.users.repositories.UserStatusRepository;

@Service
public class UserStatusService {

  private final UserStatusRepository userStatusRepository;

  public UserStatusService(UserStatusRepository userStatusRepository) {
    this.userStatusRepository = userStatusRepository;
  }

  public List<UserStatus> allStatus() {
    return userStatusRepository.findAll();
  }

  public UserStatus createStatus(final CreateUserStatusDto statusDto) {
    final UserStateConverter converter = new UserStateConverter();
    final UserStatus status = converter.toModel(statusDto);
    return this.userStatusRepository.save(status);
  }

}
