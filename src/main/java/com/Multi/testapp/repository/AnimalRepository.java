package com.Multi.testapp.repository;

import com.Multi.testapp.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnimalRepository extends JpaRepository<Animal,Long> {
    Optional<Animal> findByAnimalname(String animalname);
}
