package com.thn.restpetstore.controller;

import com.thn.restpetstore.entity.Pet;
import com.thn.restpetstore.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<Pet> save(@RequestBody Pet newPet) {
        return new ResponseEntity<>(petService.saveNewPet(newPet), HttpStatus.CREATED);
    }

    @GetMapping("/{petId}")
    public ResponseEntity<Pet> find(@PathVariable long petId) {
        Optional<Pet> pet = petService.findPetById(petId);
        if (pet.isPresent()) {
            return new ResponseEntity<>(pet.get(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{petId}")
    public ResponseEntity<?> delete(@PathVariable long petId) {
        petService.deletePetById(petId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}