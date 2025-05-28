package com.example.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interviewId;

    @ManyToOne
    @JsonIgnore
    private Application application;

    private LocalDateTime scheduledAt;

    @OneToMany(mappedBy = "interview", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Conducts> interviewers;

    private String location;

    private Status status;

    private String notesURL;

    public enum Status {
        SCHEDULED, COMPLETED, CANCELLED
    }

    
    // Constructors, Getters and Setters
    public Interview() {}
    public Interview(Application application, LocalDateTime scheduledAt, String location, Status status, String notesURL) {
        this.application = application;
        this.scheduledAt = scheduledAt;
        this.location = location;
        this.status = status;
        this.notesURL = notesURL;
    }

    public Long getInterviewId() { return interviewId; }
    public void setInterviewId(Long interviewId) { this.interviewId = interviewId; }

    public Application getApplication() { return application; }
    public void setApplication(Application application) { this.application = application; }

    public LocalDateTime getScheduledAt() { return scheduledAt; }
    public void setScheduledAt(LocalDateTime scheduledAt) { this.scheduledAt = scheduledAt; }

    public List<Conducts> getInterviewers() { return interviewers; }
    public void setInterviewers(List<Conducts> interviewers) { this.interviewers = interviewers; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public String getNotesURL() { return notesURL; }
    public void setNotesURL(String notesURL) { this.notesURL = notesURL; }
}
