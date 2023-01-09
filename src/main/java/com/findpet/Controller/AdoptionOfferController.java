package com.findpet.Controller;


import com.findpet.Dto.AdoptionOfferDto;
import com.findpet.Request.AdoptionOfferRequest;
import com.findpet.Services.AdoptionOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/offer")
public class AdoptionOfferController {

    @Autowired
    AdoptionOfferService adoptionOfferService;

    @PostMapping
    public ResponseEntity<String> addAdoptionOffer(@RequestBody AdoptionOfferRequest adoptionOfferRequest){


        if(adoptionOfferService.saveAdoptionOffer(adoptionOfferRequest)!=null){
            return ResponseEntity.ok("adopption offer added successfully");
        }else {
            return ResponseEntity.ok("adopption offer error");
        }
    }
}
