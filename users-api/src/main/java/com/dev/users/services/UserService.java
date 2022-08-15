package com.dev.users.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.users.models.User;
import com.dev.users.repositories.UserRepository;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> allUsers() {
    return userRepository.findAll();
  }

  public User createUser(final User user) {
    return this.userRepository.save(user);
  }

  public void deleteUser(final Long userId) {
    this.userRepository.deleteById(userId);
  }

}
