package com.example.hw49.controller;

import com.example.hw49.dto.ImageDto;
import com.example.hw49.dto.UserDto;
import com.example.hw49.entity.Image;
import com.example.hw49.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public void addNewUser(@RequestBody UserDto user) {
        System.out.println(user.getPhoto());
        userService.saveUser(user);
    }

    @PostMapping("/upload")
    public HttpStatus uploadImage(ImageDto imageDto, Authentication auth) {
        userService.uploadImage(imageDto, auth);
        return HttpStatus.OK;
    }
}
