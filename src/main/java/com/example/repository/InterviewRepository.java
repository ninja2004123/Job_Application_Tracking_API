package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Long> {}
