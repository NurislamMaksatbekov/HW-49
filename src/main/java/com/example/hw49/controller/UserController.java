package com.example.hw49.controller;

import com.example.hw49.dto.ImageDto;
import com.example.hw49.dto.UserDto;
import com.example.hw49.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.URL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/register")
    public String register() {
        return "users/register";
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.SEE_OTHER)
    public String register(@Valid UserDto user) {
        userService.saveUser(user);
        return "redirect:/";
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
