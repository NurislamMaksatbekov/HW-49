package com.example.hw49.controller;

import com.example.hw49.dto.ExperienceDto;
import com.example.hw49.service.ExperienceService;
import com.example.hw49.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class ExperienceController {

    private final ExperienceService experienceService;
    private final ResumeService resumeService;
    @GetMapping("new/experience/{resumeId}")
    public String newExperience(@PathVariable Long resumeId, Model model){
        model.addAttribute("resume", resumeService.findResumeById(resumeId));
        return "experiences/new_experience";
    }

    @PostMapping("new/experience/{resumeId}")
    public String newExperience(@PathVariable Long resumeId, ExperienceDto experienceDto){
        experienceService.save(resumeId, experienceDto);
        return "redirect:/profile";
    }
}
