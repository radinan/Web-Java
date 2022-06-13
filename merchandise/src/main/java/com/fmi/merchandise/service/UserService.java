package com.fmi.merchandise.service;

import com.fmi.merchandise.dto.UserDto;
import com.fmi.merchandise.mapper.UserDtoMapper;
import com.fmi.merchandise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getUserById(Long userId) {
        return UserDtoMapper.toDto(userRepository.findById(userId));
    }
}
