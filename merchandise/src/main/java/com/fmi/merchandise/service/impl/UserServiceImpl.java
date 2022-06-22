package com.fmi.merchandise.service.impl;

import com.fmi.merchandise.dto.LoginDto;
import com.fmi.merchandise.dto.UserDto;
import com.fmi.merchandise.mapper.UserDtoMapper;
import com.fmi.merchandise.model.User;
import com.fmi.merchandise.repository.UserRepository;
import com.fmi.merchandise.service.UserService;
import com.fmi.merchandise.validation.validator.EntityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        EntityValidator.validateUserExists(user, username);

        return UserDtoMapper.toDto(user.get());
    }

    @Override
    public LoginDto login(UserDto userDto) {
        Optional<User> user = userRepository.findByUsername(userDto.getUsername());
        EntityValidator.validateUserExists(user, userDto.getUsername());
        EntityValidator.validatePasswordMatches(user.get().getPassword(), userDto.getPassword());

        return new LoginDto(userDto.getUsername());
    }
}
