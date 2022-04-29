package com.Multi.testapp.controller;

import com.Multi.testapp.entity.Animal;
import com.Multi.testapp.service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/animals")
public class AnimalRestController {
    private AnimalService animalService;

    public AnimalRestController(AnimalService animalService){this.animalService = animalService;}

    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal){return animalService.insertAnimal(animal);}
    @GetMapping
    public List<Animal> getAnimals(){return animalService.selectAllAnimal();}
    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable Long id){
        return animalService.selectAnimal(id);
    }
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Long id, @RequestBody Animal animaldetail){
        return animalService.updateAnimal(id,animaldetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnimal(@PathVariable Long id){return animalService.deleteAnimal(id);}


}
