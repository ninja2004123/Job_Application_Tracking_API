package com.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    private String title;

    @Column(length = 5000)
    private String description;

    private String requirements;

    private String location;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Application> applications;

    @ElementCollection(targetClass = EmploymentType.class)
    @CollectionTable(name = "job_employment_type", joinColumns = @JoinColumn(name = "job_id"))
    @Enumerated(EnumType.STRING)
    private Set<EmploymentType> employmentTypes;

    public enum EmploymentType {
        FULL_TIME, PART_TIME, CONTRACT
    } 


    // Constructors, Getters and Setters
    public Job() { applications = new ArrayList<>(); }
    public Job(String title) { this.title = title; applications = new ArrayList<>(); }
    public Job(String title, String description, String requirements, String location, Set<EmploymentType> employmentTypes) { 
        this.title = title; 
        this.description = description; 
        this.requirements = requirements; 
        this.location = location; 
        this.employmentTypes = employmentTypes;
        this.applications = new ArrayList<>();
    }

    public Long getJobId() { return jobId; }
    public void setJobId(Long jobId) { this.jobId = jobId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getRequirements() { return requirements; }
    public void setRequirements(String requirements) { this.requirements = requirements; }
   
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    
    public Set<EmploymentType> getEmploymentTypes() { return employmentTypes; }
    public void setEmploymentTypes(Set<EmploymentType> employmentTypes) { this.employmentTypes = employmentTypes; }
}
