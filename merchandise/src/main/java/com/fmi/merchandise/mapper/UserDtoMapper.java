package com.fmi.merchandise.mapper;

import com.fmi.merchandise.dto.UserDto;
import com.fmi.merchandise.model.User;

public class UserDtoMapper {
    public static UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getUserName(), user.getFirstName(), user.getLastName(),
                user.getPhoneNumber(), user.getLastName());
    }

    public static User toEntity(UserDto userDto) {
//        return new User(userDto.getUserName(), userDto.getEmail());
//        return new User(userDto.getUserName(), userDto.getFirstName(), userDto.getLastName(),
//                userDto.getEmail(), userDto.getPhoneNumber())
        return null;
    }
}
