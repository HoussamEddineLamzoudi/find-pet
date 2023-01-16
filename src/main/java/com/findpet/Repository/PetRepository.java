package com.findpet.Repository;

import com.findpet.Entity.AdopterPetTracker;
import com.findpet.Entity.Pet;
import com.findpet.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet , Integer> {
//    List<Pet> findByAdopters(List<AdopterPetTracker> adopters);
//    List<Pet> findByAdopters(Integer id);
    List<Pet> findByUser(User user);

}
