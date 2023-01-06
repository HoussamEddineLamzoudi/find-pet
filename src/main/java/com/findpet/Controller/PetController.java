package com.findpet.Controller;


import com.findpet.Dto.PetDao;
import com.findpet.Request.PetRequest;
import com.findpet.Services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pet")
public class PetController {

    @Autowired
    PetService petService;
    @PostMapping
    public ResponseEntity<String> addPet(@RequestBody PetRequest petRequest){

        PetDao petDao = petService.savePet(petRequest);
        return ResponseEntity.ok(petDao.getPetName()+" added");
    }
}
