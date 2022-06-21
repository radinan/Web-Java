package com.fmi.merchandise.service.impl;

import com.fmi.merchandise.dto.UserDto;
import com.fmi.merchandise.mapper.UserDtoMapper;
import com.fmi.merchandise.model.User;
import com.fmi.merchandise.repository.UserRepository;
import com.fmi.merchandise.service.UserService;
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
    public UserDto getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new IllegalArgumentException();//TODO: change to custom exception
        }

        return UserDtoMapper.toDto(user.get());
    }
}
