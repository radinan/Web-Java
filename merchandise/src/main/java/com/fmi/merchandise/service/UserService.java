package com.fmi.merchandise.service;

import com.fmi.merchandise.dto.LoginDto;
import com.fmi.merchandise.dto.UserDto;

public interface UserService {
    UserDto getUserByUsername(String username);
    LoginDto login(UserDto userDto);
}
