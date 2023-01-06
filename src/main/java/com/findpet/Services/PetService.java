package com.findpet.Services;


import com.findpet.Dto.PetDao;
import com.findpet.Entity.Pet;
import com.findpet.Repository.PetRepository;
import com.findpet.Request.PetRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;
    public PetDao savePet(PetRequest petRequest) {
        Pet pet = new Pet();
        Pet newPet = petRepository.save(pet);
        PetDao petDao = new PetDao();
        BeanUtils.copyProperties(newPet, pet);
        return petDao;
    }
}
