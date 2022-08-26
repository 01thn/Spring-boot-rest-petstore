package com.thn.restpetstore.repository;

import com.thn.restpetstore.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    Optional<Pet> findPetById(long id);

    void deletePetById(long id);

}
