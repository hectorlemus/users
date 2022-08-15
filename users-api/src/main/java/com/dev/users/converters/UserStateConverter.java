package com.dev.users.converters;

import com.dev.users.dto.CreateUserStatusDto;
import com.dev.users.models.UserStatus;

public class UserStateConverter {

  public UserStatus toModel(final CreateUserStatusDto dto) {
    final UserStatus status = new UserStatus();
    status.setName(dto.getName());
    return status;
  }
  
}
