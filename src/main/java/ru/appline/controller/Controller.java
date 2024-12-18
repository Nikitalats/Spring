package ru.appline.controller;
import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/pet")
public class Controller {
    private static final PetModel petModel=PetModel.getInstance();
    private static final AtomicInteger newId=new AtomicInteger(1);

    @PostMapping(value = "/createPet", consumes = "application/json")
    public String createPet(@RequestBody Pet pet){
        petModel.add(pet,newId.getAndIncrement());
        return "Создан новый питомец";
    }

    @GetMapping(value = "/getAll", produces = "application/json" )
    public Map<Integer, Pet> getAll(){
        return  petModel.getAll();
    }

    @GetMapping(value = "/getPet", produces = "application/json"  )
    public Pet getPet(@RequestParam int id){
        return  petModel.getFromList(id);
    }

    @DeleteMapping(value = "/delPet", consumes = "application/json")
    public void delPet(@RequestBody Map<String, Integer> id){
        petModel.del(id.get("id"));
    }

    @PutMapping(value = "/putPet/{id}",consumes = "application/json")
    public void putPet(@RequestBody Pet pet,@PathVariable("id")int id){
        petModel.put(pet, id);
    }

}
