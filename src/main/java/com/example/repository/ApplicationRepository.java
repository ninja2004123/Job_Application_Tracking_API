package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByCandidateCandidateId(Long candidateId);
}