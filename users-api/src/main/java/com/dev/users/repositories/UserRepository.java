package com.dev.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.users.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  
}
