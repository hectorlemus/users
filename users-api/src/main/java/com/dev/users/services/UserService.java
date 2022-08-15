package com.dev.users.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.users.converters.UserConverter;
import com.dev.users.dto.CreateUserDto;
import com.dev.users.models.User;
import com.dev.users.models.UserStatus;
import com.dev.users.repositories.UserRepository;
import com.dev.users.repositories.UserStatusRepository;

@Service
public class UserService {

  private final UserStatusRepository userStatusRepository;
  private final UserRepository userRepository;

  public UserService(
    final UserStatusRepository userStatusRepository,
    final UserRepository userRepository
  ) {
    this.userStatusRepository = userStatusRepository;
    this.userRepository = userRepository;
  }

  public List<User> allUsers() {
    return userRepository.findAll();
  }

  public User createUser(final CreateUserDto userDto) {
    final UserStatus status = this.userStatusRepository.findById(1l).get();
    final UserConverter converter = new UserConverter();
    final User user = converter.toModel(userDto, status);
    return this.userRepository.save(user);
  }

  public User updateUser(final User user) {
    return this.userRepository.save(user);
  }

  public void deleteUser(final Long userId) {
    this.userRepository.deleteById(userId);
  }

}
