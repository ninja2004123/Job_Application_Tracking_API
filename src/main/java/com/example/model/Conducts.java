package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Conducts {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conductsId;

    @ManyToOne()
    @JoinColumn(name = "interviewId")
    private Interview interview;

    @ManyToOne
    @JoinColumn(name = "interviewerId")
    private Employee interviewer;


    // Consturctors, Getters and Setters
    public Conducts() {}
    public Conducts(Interview interview, Employee interveiwer) {
        this.interview = interview;
        this.interviewer = interveiwer;
    }

    public Long getConductsId() { return conductsId; }
    public void setConductsId(Long conductsId) { this.conductsId = conductsId; }

    public Interview getInterview() { return interview; }
    public void setInterview(Interview interview) { this.interview = interview; }

    public Employee getInterviewer() { return interviewer; }
    public void setInterviewer(Employee interviewer) { this.interviewer = interviewer; }
}
