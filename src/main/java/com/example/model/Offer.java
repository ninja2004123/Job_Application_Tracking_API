package com.example.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;

    @OneToOne
    @JsonIgnore
    private Application application;

    private Integer salary;

    private LocalDateTime startingDate;

    private String PDF_URL;

    private LocalDateTime createdAt;


    // Constructors, Getters and Setters
    public Offer() { this.createdAt = LocalDateTime.now(); }
    public Offer(Application application, Integer salary, LocalDateTime startinDate, String PDF_URL) {
        this.application = application;
        this.salary = salary;
        this.startingDate = startinDate;
        this.PDF_URL = PDF_URL;
        this.createdAt = LocalDateTime.now();
    }
    public Offer(Application application, Integer salary, LocalDateTime startinDate, String PDF_URL, LocalDateTime createdAt) {
        this.application = application;
        this.salary = salary;
        this.startingDate = startinDate;
        this.PDF_URL = PDF_URL;
        this.createdAt = createdAt;
    }

    public Long getOfferId() { return offerId; }
    public void setOfferId(Long offerId) { this.offerId = offerId; }

    public Application getApplication() { return application; }
    public void setApplication(Application application) { this.application = application; }

    public Integer getSalary() { return salary; }
    public void setSalary(Integer salary) { this.salary = salary; }


    public LocalDateTime getStartingDate() { return startingDate; }
    public void setStartingDate(LocalDateTime startingDate) { this.startingDate = startingDate; }

    public String getPDF_URL() { return PDF_URL; }
    public void setPDF_URL(String PDF_URL) { this.PDF_URL = PDF_URL; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
