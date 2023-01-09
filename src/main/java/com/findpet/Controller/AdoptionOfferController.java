package com.findpet.Controller;


import com.findpet.Entity.AdoptionOffer;
import com.findpet.Request.AdoptionOfferRequest;
import com.findpet.Services.AdoptionOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offer")
public class AdoptionOfferController {

    @Autowired
    AdoptionOfferService adoptionOfferService;

    /**
     * creat new adoption offer
     *
     * @param adoptionOfferRequest object containing all information needed for creat new offer
     * @return msg added or not
     */
    @PostMapping
    public ResponseEntity<String> addAdoptionOffer(@RequestBody AdoptionOfferRequest adoptionOfferRequest){


        if(adoptionOfferService.saveAdoptionOffer(adoptionOfferRequest)!=null){
            return ResponseEntity.ok("adopption offer added successfully");
        }else {
            return ResponseEntity.ok("adopption offer error");
        }
    }


    @GetMapping
    public List<AdoptionOffer> getAll(){
        return adoptionOfferService.getAllAdoptionOffers();
    }
}
