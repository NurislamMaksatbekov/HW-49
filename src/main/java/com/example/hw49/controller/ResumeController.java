package com.example.hw49.controller;

import com.example.hw49.dto.ResumeDto;
import com.example.hw49.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/resumes")
public class ResumeController {

    private final ResumeService resumeService;

    @GetMapping
    public List<ResumeDto> findAllResumes() {
        return resumeService.findAllResumes();
    }

    @GetMapping("/title")
    public List<ResumeDto> findResumeByTitle(@RequestParam String title) {
        return resumeService.findResumeByTitle(title);
    }

    @DeleteMapping("/delete")
    public void deleteResume(@RequestParam Long resumeId) {
        resumeService.deleteResume(resumeId);
    }

    @PostMapping("/change")
    public void changeResume(@RequestBody ResumeDto resume) {
        resumeService.changeResume(resume);
    }

    @PostMapping("/create")
    public void createResume(@RequestBody ResumeDto resumeDto, Authentication auth) {
        resumeService.saveResume(resumeDto, auth);
    }

    @GetMapping("/id")
    public ResumeDto findResumeById(@RequestParam Long resumeId) {
        return resumeService.findResumeById(resumeId);
    }

    @GetMapping("/email")
    public List<ResumeDto> selectResumeByUser(@RequestParam String authorEmail) {
        return resumeService.selectResumeByUser(authorEmail);
    }

    @GetMapping("my-resumes")
    public List<ResumeDto> myResumes(Authentication auth){
        return resumeService.myResumes(auth);
    }
}
