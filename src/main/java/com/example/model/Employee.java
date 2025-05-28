package com.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String name;
    private String surname;

    @Column(unique = true)
    private String email;

    private String position;

    @OneToMany(mappedBy = "interviewer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Conducts> conductedInterviews;


    // Constructors, Getters and Setters
    public Employee() {}
    public Employee(String name, String surname, String email) {
        this.name = name; this.surname = surname; this.email = email;
    }
    public Employee(String name, String surname, String email, String position) {
        this.name = name; this.surname = surname; this.email = email; this.position = position;
    }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPosition() { return position; }
    public void setPossition(String position) { this.position = position; }

    public List<Conducts> getConductedInterviews() { return conductedInterviews; }
    public void setConductedInterviews(List<Conducts> conductedinterviews) { this.conductedInterviews = conductedinterviews; }
}
