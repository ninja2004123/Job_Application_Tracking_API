package com.example.controller;

import java.time.LocalDateTime;
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

import com.example.model.Application;
import com.example.model.Job;
import com.example.service.ApplicationService;


@RestController
@RequestMapping("/applications")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;
    
    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/{applicationId}")
    public Optional<Application> getApplication(@PathVariable Long applicationId) {
        return applicationService.getApplication(applicationId);
    }

    @GetMapping("/{applicationId}/job")
    public Job getApplicationJob(@PathVariable Long applicationId) {
        return applicationService.getJobByApplicationId(applicationId);
    }

    @GetMapping("/candidate/{candidateId}")
    public List<Application> getByCandidate(@PathVariable Long candidateId ) {
        return applicationService.getByCandidate(candidateId);
    }

    @PostMapping
    public Application createApplication(@RequestBody Application application) {
        return applicationService.saveApplication(application);
    }

    @PutMapping("/{applicationId}")
    public Application updateApplication(@PathVariable Long applicationId, @RequestBody Application application) {
        application.setApplicationId(applicationId);
        application.setUpdatedAt(LocalDateTime.now());
        return applicationService.saveApplication(application);
    }

    @DeleteMapping("/{applicationId}")
    public void deleteapplication(@PathVariable Long applicationId) {
        applicationService.deleteApplication(applicationId);
    }
}
