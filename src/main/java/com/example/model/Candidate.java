package com.example.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long candidateId;

    @OneToOne
    @JsonIgnore
    private Employee user;

    private String name;
    private String surname;
    private String email;
    private String resumeURL;
    private String linkedinURL;

    @Column(length = 5000)
    private String skills;

    private LocalDateTime createdAt;


    // Constructors, Getters and Setters
    public Candidate() { createdAt = LocalDateTime.now(); }
    public Candidate(String name, String surname, String email, String resumeUrl, String linkedinUrl, String skills) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.resumeURL = resumeUrl;
        this.linkedinURL = linkedinUrl;
        this.skills = skills;
        this.createdAt = LocalDateTime.now();
    }

    public Long getCandidateId() { return candidateId; }
    public void setCandidateId(Long candidateId) { this.candidateId = candidateId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getResumeURL() { return resumeURL; }
    public void setResumeURL(String resumeURL) { this.resumeURL = resumeURL; }

    public String getLinkedinURL() { return linkedinURL; }
    public void setLinkedinURL(String linkedinURL) { this.linkedinURL = linkedinURL; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
