package com.Multi.testapp.repository;

import com.Multi.testapp.entity.Animal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AnimalRepositoryTest {

    @Autowired
    AnimalRepository animalRepository;

    @Test
    public void save(){
        Animal animal = new Animal();
        animal.setAnimalname("멍멍이");
        animal.setAnimaltype("강아지");

        Animal savedAnimal = animalRepository.save(animal);

        System.out.println("이름 = "+savedAnimal.getAnimalname());
        System.out.println("종류 ="+savedAnimal.getAnimaltype());

    }
}