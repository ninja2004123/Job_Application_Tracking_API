package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Interview;
import com.example.repository.InterviewRepository;

@Service
public class InterviewService {
    
    @Autowired
    private InterviewRepository interviewgRepository;

    public List<Interview> getAllInterviews() {
        return interviewgRepository.findAll();
    }

    public Optional<Interview> getInterview(Long interviewgId) {
        return interviewgRepository.findById(interviewgId);
    }

    public Interview saveInterview(Interview interviewg) {
        return interviewgRepository.save(interviewg);
    }

    public void deleteInterview(Long interviewgId) {
        interviewgRepository.deleteById(interviewgId);
    }
}
