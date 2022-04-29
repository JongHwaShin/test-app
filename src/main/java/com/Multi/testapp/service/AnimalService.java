package com.Multi.testapp.service;

import com.Multi.testapp.entity.Animal;
import com.Multi.testapp.exception.ResourceNotFoundException;
import com.Multi.testapp.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Animal insertAnimal(Animal animal){
        return animalRepository.save(animal);
    }

    @Transactional(readOnly = true)
    public List<Animal> selectAllAnimal(){ return animalRepository.findAll();}

    @Transactional(readOnly = true)
    public Animal selectAnimal(Long id){
        Optional<Animal>optionalAnimal = animalRepository.findById(id);
        Animal existAnimal = optionalAnimal.orElseThrow(() -> new ResourceNotFoundException("Animal", "id", id));
        return existAnimal;

    }

    public Animal updateAnimal(Long id,Animal animaldetail){
        Animal existAnimal = animalRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Animal","id",id));
        existAnimal.setAnimalname(animaldetail.getAnimalname());

        existAnimal.setAnimaltype(animaldetail.getAnimaltype());

        return existAnimal;
    }

    public ResponseEntity<?> deleteAnimal(Long id){
        Optional<Animal> optionalAnimal = animalRepository.findById(id);

        if(!optionalAnimal.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id+"Animal Not Found");
        }

        Animal existAnimal = optionalAnimal.get();
        animalRepository.delete(existAnimal);
        return ResponseEntity.ok("Animal delete success");


    }

}
