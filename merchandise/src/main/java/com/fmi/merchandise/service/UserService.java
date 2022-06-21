package com.fmi.merchandise.service;

import com.fmi.merchandise.dto.UserDto;

public interface UserService {
    UserDto getUserById(Long userId);
}
