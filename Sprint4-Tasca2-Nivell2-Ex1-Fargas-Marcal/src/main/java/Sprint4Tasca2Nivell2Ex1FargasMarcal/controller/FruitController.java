package Sprint4Tasca2Nivell2Ex1FargasMarcal.controller;

import Sprint4Tasca2Nivell2Ex1FargasMarcal.entities.Fruit;
import Sprint4Tasca2Nivell2Ex1FargasMarcal.repository.IFruitRepo;
import Sprint4Tasca2Nivell2Ex1FargasMarcal.services.IServiceFruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FruitController {

    ResponseEntity<Fruit> myResponseEntity;
    ResponseEntity<List<Fruit>> myResponseListEntity;

    @Autowired
    IServiceFruit myService;

    @GetMapping("/fruits")
    public ResponseEntity<List<Fruit>> getAllFruits(){
        List<Fruit> fruits = myService.getAllFruits();

        try{
            if (!fruits.isEmpty()){
                myResponseListEntity = new ResponseEntity<>(fruits,HttpStatus.OK);
            }else{
                myResponseListEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch(Exception e){
            myResponseListEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return myResponseListEntity;
    }

    @GetMapping("/fruits/{id}")
    public ResponseEntity<Fruit> getOneFruitById(@PathVariable("id") int id){
        Fruit myFruit = myService.getOneById(id);

        if (myFruit !=null){
            myResponseEntity = new ResponseEntity<>(myFruit,HttpStatus.OK);
        }else{
            myResponseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return  myResponseEntity;
    }


    @DeleteMapping("/fruits/{id}")
    public ResponseEntity<Fruit> deleteFruitById(@PathVariable("id") int id){
        Boolean eliminated;

        eliminated = myService.deleteFruitById(id);

        if(eliminated){
            myResponseEntity = new ResponseEntity<>(HttpStatus.OK);
        }else{
            myResponseEntity =  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return myResponseEntity;
    }


    @PutMapping("/fruits/{id}")
    public ResponseEntity<Fruit> updateById(@PathVariable("id") int id, @RequestBody Fruit newFruit){

        Fruit updatedFruit = myService.updateFruitService(id, newFruit);

        if (updatedFruit !=null){
            myResponseEntity = new ResponseEntity<>(updatedFruit, HttpStatus.OK);
        }else{
            myResponseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return myResponseEntity;
    }


    @PostMapping("/fruits")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit){
        try{
            Fruit myFruit = myService.addFruit(fruit);

            myResponseEntity = new ResponseEntity<>(myFruit,HttpStatus.OK);
        }catch(Exception e){
            myResponseEntity = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return myResponseEntity;
    }



}//closes class
