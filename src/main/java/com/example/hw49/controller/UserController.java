package com.example.hw49.controller;

import com.example.hw49.dto.UserDto;
import com.example.hw49.entity.User;
import com.example.hw49.service.CategoryService;
import com.example.hw49.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final CategoryService categoryService;

    @PostMapping("/register")
    public void addNewUser(@RequestBody UserDto user){
        userService.addNewUser(user);
    }

}
