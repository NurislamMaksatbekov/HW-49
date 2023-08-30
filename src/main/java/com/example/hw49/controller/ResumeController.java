package com.example.hw49.controller;

import com.example.hw49.dto.ResumeDto;
import com.example.hw49.service.CategoryService;
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
    private final CategoryService categoryService;

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

    @GetMapping("resume/change/{resumeId}")
    public String changeResume(Model model, @PathVariable Long resumeId){
        model.addAttribute("resume", resumeService.findResumeById(resumeId));
        model.addAttribute("categories", categoryService.getAllCategories());
        return "resumes/change_resume";
    }

    @PostMapping("resume/change/{resumeId}")
    public String changeResume(@Valid ResumeDto resume, Authentication auth, @PathVariable Long resumeId) {
        resumeService.changeResume(resumeId,resume, auth);
        return "redirect:/profile";
    }


    @PostMapping("resume/update/{resumeId}")
    public String updateResume(@PathVariable Long resumeId){
        resumeService.updateResume(resumeId);
        return "redirect:/profile";
    }

    @GetMapping("resume/create")
    public String createResume(Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        return "resumes/add_resume";
    }

    @PostMapping("resume/create")
    public String createResume(@Valid ResumeDto resumeDto, Authentication auth) {
        resumeService.saveResume(resumeDto, auth);
        return "redirect:/profile";
    }

    @GetMapping("resume/my-resumes")
    public List<ResumeDto> myResumes(Authentication auth){
        return resumeService.myResumes(auth);
    }

    @GetMapping("summary/title")
    public List<ResumeDto> findResumeByTitle(@RequestParam String title) {
        return resumeService.findResumeByTitle(title);
    }

    @GetMapping("summary/{resumeId}")
    public String findResumeById(@PathVariable Long resumeId, Model model) {
        model.addAttribute("resume", resumeService.findResumeById(resumeId));
        return "resumes/resume_info";
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
