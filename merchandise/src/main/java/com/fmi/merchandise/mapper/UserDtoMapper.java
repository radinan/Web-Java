package com.fmi.merchandise.mapper;

import com.fmi.merchandise.dto.UserDto;
import com.fmi.merchandise.model.User;

public class UserDtoMapper {
    public static UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    public static User toEntity(UserDto userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }
}
