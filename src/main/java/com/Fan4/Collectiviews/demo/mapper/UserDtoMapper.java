package com.Fan4.Collectiviews.demo.mapper;

import com.Fan4.Collectiviews.demo.dto.UserDto;
import com.Fan4.Collectiviews.demo.model.User;
import com.Fan4.Collectiviews.demo.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring",
    uses = {UserService.class})
public interface UserDtoMapper {

  @Mapping(target = "password_hash", source = "password")
  User toEntity(UserDto userDto) throws EntityNotFoundException;

  @Mapping(target = "password", ignore = true) // Don't include password in responses
  UserDto toDto(User user) throws EntityNotFoundException;

  List<UserDto> toDtoList(List<User> userList) throws EntityNotFoundException;
}
