package com.example.hw49.controller;

import com.example.hw49.dto.UserDto;
import com.example.hw49.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/findRespondedUsers{vacancyId}")
    public List<UserDto> findUserByRespond(@PathVariable Long vacancyId){
        return userService.getUserByResponds(vacancyId);
    }

    @GetMapping("/findApplicant/{email}")
    public UserDto findApplicant(@PathVariable String email){
        return userService.findApplicant(email);
    }


}
