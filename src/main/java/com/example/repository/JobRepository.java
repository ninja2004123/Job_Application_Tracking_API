package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Job;
import com.example.model.Job.EmploymentType;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByemploymentTypes(EmploymentType employmentTypes);
}
