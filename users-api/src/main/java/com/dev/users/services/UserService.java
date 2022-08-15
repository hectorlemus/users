package com.dev.users.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.users.converters.UserConverter;
import com.dev.users.dto.CreateUserDto;
import com.dev.users.dto.EditUserDto;
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
    return userRepository.findAllByOrderByIdAsc();
  }

  public User getUser(final Long id) {
    return userRepository.findById(id).get();
  }

  public User createUser(final CreateUserDto userDto) {
    final UserStatus status = this.userStatusRepository.findById(userDto.getStatus()).get();
    final UserConverter converter = new UserConverter();
    final User user = converter.toModel(userDto, status);
    return this.userRepository.save(user);
  }

  public User updateUser(final EditUserDto userDto) {
    final UserStatus status = this.userStatusRepository.findById(userDto.getStatus()).get();
    return this.userRepository.findById(userDto.getId()).map((e) -> {
      final UserConverter converter = new UserConverter();
      final User user = converter.editToModel(userDto, status);
      return this.userRepository.save(user);
    }).orElseGet(() -> null);
  }

  public void deleteUser(final Long userId) {
    this.userRepository.deleteById(userId);
  }

}
