package Sprint4Tasca2Nivell1Ex1FargasMarcal.Sprint4Tasca2Nivell1Ex1FargasMarcal.controllers;


import Sprint4Tasca2Nivell1Ex1FargasMarcal.Sprint4Tasca2Nivell1Ex1FargasMarcal.model.domain.Fruit;
import Sprint4Tasca2Nivell1Ex1FargasMarcal.Sprint4Tasca2Nivell1Ex1FargasMarcal.model.repository.IFruitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FruitController {

    @Autowired
    IFruitRepo myIFruitRepo;

    @GetMapping("/fruits")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        List<Fruit> fruits = new ArrayList<>();

        try {

            fruits.addAll(myIFruitRepo.findAll());

            if (fruits.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(fruits, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fruits/{id}")
    public ResponseEntity<Fruit> getOneById(@PathVariable("id") int id){
        Optional<Fruit> myFruit = myIFruitRepo.findById(id);

        if (myFruit.isPresent()){
            return new ResponseEntity<>(myFruit.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("fruits/{id}")
    public ResponseEntity<Fruit> updateFruit(@PathVariable("id") int id, @RequestBody Fruit fruit){
        Optional<Fruit> myFruit = myIFruitRepo.findById(id);

        if (myFruit.isPresent()){

            Fruit updatedFruit = myFruit.get();
            updatedFruit.setId(fruit.getId());
            updatedFruit.setName(fruit.getName());
            updatedFruit.setKgsQty(fruit.getKgsQty());

            return new ResponseEntity<>(myIFruitRepo.save(updatedFruit), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("fruits/{id}")
    public ResponseEntity<Fruit> deleteFruit(@PathVariable("id") int id){
        try{
            myIFruitRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/fruits")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit){
        try{
            Fruit myFruit = myIFruitRepo.save(new Fruit(fruit.getId(),fruit.getName(),fruit.getKgsQty()));

            return new ResponseEntity<>(myFruit,HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
