package com.example.hw49.controller;

import com.example.hw49.dto.ImageDto;
import com.example.hw49.dto.UserDto;
import com.example.hw49.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody UserDto user) {
        userService.saveUser(user);
        return ResponseEntity.ok("Вы успешно зарегистрировлись");
    }

    @GetMapping("/employer")
    public UserDto findEmployer(@RequestParam String email) {
        return userService.findEmployer(email);
    }

    @GetMapping("/respond")
    public List<UserDto> findUserByRespond(@RequestParam Long vacancyId) {
        return userService.getUserByResponds(vacancyId);
    }

    @GetMapping("/applicant")
    public UserDto findApplicant(@RequestParam String email) {
        return userService.findApplicant(email);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(ImageDto imageDto, Authentication auth) {
        userService.uploadImage(imageDto, auth);
        return ResponseEntity.ok("Фото профиля загружено");
    }
}
