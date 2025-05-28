package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Application;
import com.example.model.Offer;
import com.example.service.ApplicationService;
import com.example.service.OfferService;

@RestController
@RequestMapping("/offers")
public class OfferController {
    @Autowired
    private OfferService offerService;
    @Autowired
    private ApplicationService applicationService;
    
    @GetMapping
    public List<Offer> getAllOffers() {
        return offerService.getAllOffers();
    }

    @GetMapping("/{offerId}")
    public Optional<Offer> getOffer(@PathVariable Long offerId) {
        return offerService.getOffer(offerId);
    }

    @GetMapping("/application/{applicationId}")
    public List<Offer> getByApplicationId(@PathVariable Long applicationId) {
        return offerService.getByApplicationId(applicationId);
    }

    
    @GetMapping("/candidate/{candidateId}")
    public List<Offer> getByCandidateId(@PathVariable Long candidateId) {
        List<Offer> offers = new ArrayList<>();
        for (Application application : applicationService.getByCandidate(candidateId))
            offers.addAll((offerService.getByApplicationId(application.getApplicationId())));
        return offers;
    }
    

    @PostMapping
    public Offer createOffer(@RequestBody Offer offer) {
        return offerService.saveOffer(offer);
    }

    @PutMapping("/{offerId}")
    public Offer updateOffer(@PathVariable Long offerId, @RequestBody Offer offer) {
        offer.setOfferId(offerId);
        return offerService.saveOffer(offer);
    }

    @DeleteMapping("/{offerId}")
    public void deleteOffer(@PathVariable Long offerId) {
        offerService.deleteOffer(offerId);
    }
}
