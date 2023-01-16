package com.findpet.Services;


import com.findpet.Dto.AdoptionOfferDto;
import com.findpet.Dto.PetDto;
import com.findpet.Entity.AdoptionOffer;
import com.findpet.Entity.Pet;
import com.findpet.Entity.User;
import com.findpet.Repository.PetRepository;
import com.findpet.Request.PetRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;
    @Autowired
    UserService userService;


    public Pet savePet(PetRequest petRequest) {


        Pet pet = new Pet();
        BeanUtils.copyProperties(petRequest, pet);

        User user = userService.getUser(petRequest.getOwner());
        pet.setUser(user);

        Pet newPet = petRepository.save(pet);

        return newPet;
    }


    public Pet findPet(int petId) {
        return petRepository.findById(petId).get();
    }

    public List<PetDto> getAllPetsForOneUser(Integer userId) {
        User user = userService.getUser(userId);
        List<Pet> petList = petRepository.findByUser(user);
        List<PetDto> petDtoList = new ArrayList<>();

        for (Pet pet : petList) {
            PetDto petDto= new PetDto();
            BeanUtils.copyProperties(pet, petDto);
            petDtoList.add(petDto);
        }
        return petDtoList;
    }
}
