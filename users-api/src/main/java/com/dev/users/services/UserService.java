package com.dev.users.services;

import java.util.List;

import org.springframework.stereotype.Service;

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

  public User createUser(final User user) {
    final UserStatus status = this.userStatusRepository.findById(1l).get();
    user.setStatus(status);
    return this.userRepository.save(user);
  }

  public void deleteUser(final Long userId) {
    this.userRepository.deleteById(userId);
  }

}
