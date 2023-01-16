package com.findpet.Controller;


import com.findpet.Dto.PetDto;
import com.findpet.Entity.Pet;
import com.findpet.Request.PetRequest;
import com.findpet.Services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pet")
public class PetController {

    @Autowired
    PetService petService;

    @PostMapping
    public ResponseEntity<String> addPet(@RequestBody PetRequest petRequest){

        if(petService.savePet(petRequest)!=null){
            return ResponseEntity.ok("pet added successfully");
        }else {
            return ResponseEntity.ok("pet error");
        }
    }

    @GetMapping
    public PetDto getPets(){
        return null;
    }

    @GetMapping("/user/{userId}")
    public List<PetDto> getPetsForUser(@PathVariable Integer userId){
        List<PetDto> petDtoList = petService.getAllPetsForOneUser(userId);
        return petDtoList;
    }
}
