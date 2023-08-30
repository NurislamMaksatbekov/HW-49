package com.example.hw49.controller;

import com.example.hw49.dto.EducationDto;
import com.example.hw49.entity.Education;
import com.example.hw49.service.EducationService;
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
public class EducationController {
    private final EducationService educationService;
    private final ResumeService resumeService;

    @GetMapping("new/education/{resumeId}")
    public String newEducation(@PathVariable Long resumeId, Model model){
        model.addAttribute("resume", resumeService.findResumeById(resumeId));
        return "educations/new_education";
    }

    @PostMapping("new/education/{resumeId}")
    public String newEducation(@PathVariable Long resumeId, EducationDto educationDto){
        educationService.save(resumeId, educationDto);
        return "redirect:/profile";
    }
}
