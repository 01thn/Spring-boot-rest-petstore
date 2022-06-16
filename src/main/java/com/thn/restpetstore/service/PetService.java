package com.thn.restpetstore.service;

import com.thn.restpetstore.entity.Pet;
import com.thn.restpetstore.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public Pet saveNewPet(Pet newPet) {
        return petRepository.save(newPet);
    }

    public Optional<Pet> findPetById(long id) {
        return petRepository.findPetById(id);
    }

    public void deletePetById(long id) {
        petRepository.deletePetById(id);
    }
}
