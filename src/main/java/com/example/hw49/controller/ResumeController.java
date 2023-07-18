package com.example.hw49.controller;

import com.example.hw49.dto.ResumeDto;
import com.example.hw49.entity.Resume;
import com.example.hw49.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/resumes")
public class ResumeController {
    private final ResumeService resumeService;

    @GetMapping("/findResumeByUser/{authorEmail}")
    public List<ResumeDto> selectResumeByUser(@PathVariable String authorEmail){
        return resumeService.selectResumeByUser(authorEmail);
    }

    @GetMapping("/findResumesById/{resumeId}")
    public ResumeDto findResumeById(@PathVariable Long resumeId){
        return resumeService.findResumeById(resumeId);
    }


    @PostMapping("/createResume")
    public void createResume(@RequestBody ResumeDto resume){
        resumeService.createResume(resume);
    }

    @PostMapping("/changeResume")
    public void changeResume(@RequestBody ResumeDto resume){
        resumeService.changeResume(resume);
    }

    @DeleteMapping("/deleteResume/{resumeId}")
    public void deleteResume(@PathVariable Long resumeId){
        resumeService.deleteResume(resumeId);
    }

}

