package com.dev.users.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.users.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  public List<User> findAllByOrderByIdAsc();

}
