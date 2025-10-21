package com.Fan4.Collectiviews.demo.mapper;

import org.mapstruct.Mapper;

import com.Fan4.Collectiviews.demo.service.UserService;

@Mapper(
    componentModel = "spring",
    uses = {UserService.class}
)
public interface UserDtoMapper {

        // TODO: toEntity(UserDto userDto)
        
        // TODO: toDto(User user)

        // TODO: toDtoList(List<User> userList)
}
