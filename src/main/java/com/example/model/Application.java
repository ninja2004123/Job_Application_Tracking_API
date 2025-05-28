package com.example.model;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @ManyToOne
    @JsonIgnore
    private Candidate candidate;

    @ManyToOne
    @JsonIgnore
    private Job job;

    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Interview> interviews;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime appliedAt;
    private LocalDateTime updatedAt;

    public enum Status {
        SUBMITTED, UNDER_REVIEW, INTERVIEW_SCHEDULED, OFFERED, REJECTED, WITHDRAWN
    }


    // Constructors, Getters and Setters 
    public Application() {
        this.appliedAt = LocalDateTime.now(); 
        this.updatedAt = LocalDateTime.now();
    }
    public Application(Candidate candidate, Job job) {
        this.candidate = candidate; 
        this.job = job;
        this.status = Status.SUBMITTED; 
        this.appliedAt = LocalDateTime.now(); 
        this.updatedAt = LocalDateTime.now();
    }
    public Application(Candidate candidate, Job job, Status status) {
        this.candidate = candidate;
        this.job = job;
        this.status = status;
        this.appliedAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Long getApplicationId() { return applicationId; }
    public void setApplicationId(Long applicationId) { this.applicationId = applicationId; }

    public Candidate getCandidate() { return candidate; }
    public void setCandidate(Candidate candidate) { this.candidate = candidate; }
   
    public Job getJob() { return job; }
    public void setJob(Job job) { this.job = job; }

    public Set<Interview> getInterviews() { return interviews; }
    public void setInterviews(Set<Interview> interviews) { this.interviews = interviews; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public LocalDateTime getAppliedAt() { return appliedAt; }
    public void setAppliuedAt(LocalDateTime appliedAt) { this.appliedAt = appliedAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}