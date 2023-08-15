package com.example.hw49.controller;

import com.example.hw49.dto.ResumeDto;
import com.example.hw49.service.ResumeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class ResumeController {

    private final ResumeService resumeService;

    @GetMapping("/resumes")
    public String findAllResumes(Model model) {
        model.addAttribute("resumes", resumeService.findAllResumes());
        return "resumes/resumes";
    }

    @DeleteMapping("resume/delete")
    public ResponseEntity<String> deleteResume(@RequestParam Long resumeId, Authentication auth) {
        resumeService.deleteResume(resumeId, auth);
        return ResponseEntity.ok("Вы успешно удалили резюме");
    }

    @PostMapping("resume/change")
    public ResponseEntity<String> changeResume(@Valid @RequestBody ResumeDto resume, Authentication auth) {
        resumeService.changeResume(resume, auth);
        return ResponseEntity.ok("Вы успешно изменили резюме");
    }

    @GetMapping("resume/create")
    public String createResume(){
        return "resumes/add_resume";
    }

    @PostMapping("resume/create")
    public ResponseEntity<String> createResume(@Valid @RequestBody ResumeDto resumeDto, Authentication auth) {
        resumeService.saveResume(resumeDto, auth);
        return ResponseEntity.ok("Вы успешно добавили новое резюме");
    }

    @GetMapping("resume/my-resumes")
    public List<ResumeDto> myResumes(Authentication auth){
        return resumeService.myResumes(auth);
    }

    @GetMapping("summary/title")
    public List<ResumeDto> findResumeByTitle(@RequestParam String title) {
        return resumeService.findResumeByTitle(title);
    }

    @GetMapping("summary/id")
    public ResumeDto findResumeById(@RequestParam Long resumeId) {
        return resumeService.findResumeById(resumeId);
    }

    @GetMapping("summary/email")
    public List<ResumeDto> selectResumeByUser(@RequestParam String authorEmail) {
        return resumeService.selectResumeByUser(authorEmail);
    }


    @GetMapping("summary/category")
    public List<ResumeDto> getResumeByCategory(Long id){
        return resumeService.getResumeByCategory(id);
    }
}
