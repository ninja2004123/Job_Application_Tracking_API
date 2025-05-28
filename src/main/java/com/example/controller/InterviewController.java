package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Interview;
import com.example.service.InterviewService;

@RestController
@RequestMapping("/interviews")
public class InterviewController {
    @Autowired
    private InterviewService interviewService;
    
    @GetMapping
    public List<Interview> getAllInterviews() {
        return interviewService.getAllInterviews();
    }

    @GetMapping("/{interviewId}")
    public Optional<Interview> getInterview(@PathVariable Long interviewId) {
        return interviewService.getInterview(interviewId);
    }

    @PostMapping
    public Interview createInterview(@RequestBody Interview interview) {
        return interviewService.saveInterview(interview);
    }

    @PutMapping("/{interviewId}")
    public Interview updateInterview(@PathVariable Long interviewId, @RequestBody Interview interview) {
        interview.setInterviewId(interviewId);
        return interviewService.saveInterview(interview);
    }

    @DeleteMapping("/{interviewId}")
    public void deleteInterview(@PathVariable Long interviewId) {
        interviewService.deleteInterview(interviewId);
    }
}
