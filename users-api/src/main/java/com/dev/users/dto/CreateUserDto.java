package com.dev.users.dto;

public class CreateUserDto {

  private String name;
  private String email;
  private String gender;

  public CreateUserDto(
    final String name,
    final String email,
    final String gender
  ) {
    this.name = name;
    this.email = email;
    this.gender = gender;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getGender() {
    return gender;
  }

}
