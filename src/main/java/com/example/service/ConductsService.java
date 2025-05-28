package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Conducts;
import com.example.repository.ConductsRepository;

@Service
public class ConductsService {
    
    @Autowired
    private ConductsRepository conductsRepository;

    public List<Conducts> getAllConductss() {
        return conductsRepository.findAll();
    }

    public Optional<Conducts> getConducts(Long conductsId) {
        return conductsRepository.findById(conductsId);
    }

    public Conducts saveConducts(Conducts conducts) {
        return conductsRepository.save(conducts);
    }

    public void deleteConducts(Long conductsId) {
        conductsRepository.deleteById(conductsId);
    }
}
