package com.example.hw49.controller;

import com.example.hw49.entity.User;
import com.example.hw49.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;


    @GetMapping("/{name}")
    public Optional<User> findUserByName(@PathVariable String name){
        return userService.findUserByName(name);
    }
}
