package com.example.hw49.controller;

import com.example.hw49.dto.ImageDto;
import com.example.hw49.dto.UserDto;
import com.example.hw49.service.ResumeService;
import com.example.hw49.service.UserService;
import com.example.hw49.service.VacancyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping
public class UserController {
    private final UserService userService;
    private final ResumeService resumeService;
    private final VacancyService vacancyService;

    @GetMapping("auth/register")
    public String register() {
        return "users/register";
    }

    @PostMapping("auth/register")
    @ResponseStatus(HttpStatus.SEE_OTHER)
    public String register(@Valid UserDto user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/users/change")
    public String change() {
        return "users/change_user_info";
    }

    @PostMapping("users/change")
    public String change(UserDto user, Authentication auth) {
        userService.changeUser(user, auth);
        return "redirect:/profile";
    }


    @GetMapping("/profile")
    public String profile(Model model, Authentication auth, Long resumeId) {
        model.addAttribute("user", userService.profile(auth));
        model.addAttribute("resumes", resumeService.lastResumes(auth));
        model.addAttribute("vacancies", vacancyService.lastVacancies(auth));
        return "users/profile";
    }

    @GetMapping("users/employer")
    public UserDto findEmployer(@RequestParam String email) {
        return userService.findEmployer(email);
    }

    @GetMapping("users/respond")
    public List<UserDto> findUserByRespond(@RequestParam Long vacancyId) {
        return userService.getUserByResponds(vacancyId);
    }

    @GetMapping("users/applicant")
    public UserDto findApplicant(@RequestParam String email) {
        return userService.findApplicant(email);
    }

    @PostMapping("users/upload")
    public ResponseEntity<String> uploadImage(ImageDto imageDto, Authentication auth) {
        userService.uploadImage(imageDto, auth);
        return ResponseEntity.ok("Фото профиля загружено");
    }
}
