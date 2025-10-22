package com.Fan4.Collectiviews.demo.dto;

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
}
