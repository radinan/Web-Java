package com.fmi.merchandise.controller;

import com.fmi.merchandise.dto.UserDto;
import com.fmi.merchandise.mapper.UserDtoMapper;
import com.fmi.merchandise.model.User;
import com.fmi.merchandise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

//    @PostMapping("/{userId}") //or PUT?
//    public void updateUserById(@PathVariable Long userId, @RequestBody UserDto userDto) {
//    }
//
//    @DeleteMapping("/{userId}")
//    public void deleteUserById(@PathVariable Long userId) {
//
//    }
}
