package com.fmi.merchandise.mapper;

import com.fmi.merchandise.dto.UserDto;
import com.fmi.merchandise.model.User;

public class UserDtoMapper {
    public static UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getUsername(), null, user.getFirstName(), user.getLastName(),
                user.getPhoneNumber(), user.getLastName());
    }

    public static User toEntity(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setEmail(userDto.getEmail());

        return user;
    }
}
