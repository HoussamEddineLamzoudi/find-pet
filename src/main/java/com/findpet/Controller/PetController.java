package com.findpet.Controller;


import com.findpet.Dto.PetDto;
import com.findpet.Entity.Pet;
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

        System.out.println("controller  ".repeat(10));
        PetDto petDto = petService.savePet(petRequest);
        System.out.println("controller  ".repeat(10));
        System.out.println(petDto);
        return ResponseEntity.ok(petDto.getPetName()+" added");
    }
}
