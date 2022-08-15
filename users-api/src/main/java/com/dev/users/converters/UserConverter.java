package com.dev.users.converters;

import com.dev.users.dto.CreateUserDto;
import com.dev.users.dto.EditUserDto;
import com.dev.users.models.User;
import com.dev.users.models.UserStatus;

public class UserConverter {

  public User toModel(final CreateUserDto dto, final UserStatus status) {
    final User user = new User();
    user.setGender(dto.getGender());
    user.setEmail(dto.getEmail());
    user.setName(dto.getName());
    user.setStatus(status);
    return user;
  }

  public User editToModel(final EditUserDto dto, final UserStatus status) {
    final User user = this.toModel(dto, status);
    user.setId(dto.getId());
    return user;
  }

}
