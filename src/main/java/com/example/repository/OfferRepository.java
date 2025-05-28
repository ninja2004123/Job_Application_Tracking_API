package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findByApplicationApplicationId(Long candidateId);
}