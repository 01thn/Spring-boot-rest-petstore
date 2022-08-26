package com.thn.restpetstore.service;

import com.thn.restpetstore.entity.Pet;
import com.thn.restpetstore.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PetService {
    private final PetRepository petRepository;
    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet saveNewPet(Pet newPet) {
        return petRepository.save(newPet);
    }

    public Optional<Pet> findPetById(long id) {
        return petRepository.findPetById(id);
    }

    @Transactional
    public void deletePetById(long id) {
        petRepository.deletePetById(id);
    }
}
