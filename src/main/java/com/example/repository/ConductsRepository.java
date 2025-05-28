package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Conducts;

public interface ConductsRepository extends JpaRepository<Conducts, Long> {}