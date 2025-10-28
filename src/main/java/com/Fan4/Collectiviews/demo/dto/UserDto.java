package com.Fan4.Collectiviews.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder // Handles generating constructors
@Data // Generates getters, toString, hashcode and equals
@Value
public class UserDto {

  String username;

  String name;

  LocalDate birthDate;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Only allow input access
  String password;

  // Override to keep password safe from logs
  @Override
  public String toString() {
    return "UserDto{username='" + username + "', name='" + name + "', birthDate=" + birthDate + "}";
  }
}
