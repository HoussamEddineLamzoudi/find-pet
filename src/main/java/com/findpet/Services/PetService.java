package com.findpet.Services;


import com.findpet.Dto.PetDto;
import com.findpet.Entity.Pet;
import com.findpet.Entity.User;
import com.findpet.Repository.PetRepository;
import com.findpet.Request.PetRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;
    @Autowired
    UserService userService;


    public PetDto savePet(PetRequest petRequest) {
        System.out.println("service    ".repeat(10));
        System.out.println(petRequest);
        Pet pet = new Pet();
        BeanUtils.copyProperties(petRequest, pet);
        User user = userService.getUser(petRequest.getOwner());
        List<User> users = new ArrayList<>();
        users.add(user);
        pet.setUsers(users);
        Pet newPet = petRepository.save(pet);
        PetDto petDto = new PetDto();
        BeanUtils.copyProperties(newPet, pet);
        return petDto;
    }

    public Pet findPet(int petId) {
        return petRepository.findById(petId).get();
    }
}
