package com.findpet.Repository;

import com.findpet.Entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet , Integer> {

}
