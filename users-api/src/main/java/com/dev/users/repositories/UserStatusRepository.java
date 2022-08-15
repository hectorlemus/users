package com.dev.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.users.models.UserStatus;

public interface UserStatusRepository extends JpaRepository<UserStatus, Long> {
  
}
