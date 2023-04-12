package Sprint4Tasca2Ex1Nivell3FargasMarcal.Controller;


import Sprint4Tasca2Ex1Nivell3FargasMarcal.Entities.Fruit;
import Sprint4Tasca2Ex1Nivell3FargasMarcal.Repository.IFruitRepoMongo;
import Sprint4Tasca2Ex1Nivell3FargasMarcal.Service.IFruitService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FruitController {

    HttpStatus ok = HttpStatus.OK;
    HttpStatus error = HttpStatus.INTERNAL_SERVER_ERROR;

    ResponseEntity<Fruit> myResponseEntity;

    ResponseEntity<List<Fruit>> myResponseListEntity;

    @Autowired
    IFruitService myService;


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


    @DeleteMapping("/fruits/{id}")
    public ResponseEntity<Fruit> deleteOneById(@PathVariable("id") ObjectId id){

        Boolean eliminated = myService.deleteOneById(id);

        if (eliminated){
            myResponseEntity = new ResponseEntity<>(ok);
        }else{
            myResponseEntity = new ResponseEntity<>(error);
        }

        return myResponseEntity;
    }


    @GetMapping("/fruits")
    public ResponseEntity<List<Fruit>> getAllFruits(){

        List<Fruit> fruits = myService.getAllFruits();

        if (!fruits.isEmpty()){
            myResponseListEntity = new ResponseEntity<>(fruits, ok);
        }else{
            myResponseListEntity = new ResponseEntity<>(error);
        }

        return myResponseListEntity;
    }


    @GetMapping("/fruits/{id}")
    public ResponseEntity<Fruit> getOneById(@PathVariable("id") ObjectId id){

        Fruit myFruit = myService.getOneById(id);

        if (myFruit !=null){
            myResponseEntity = new ResponseEntity<>(myFruit,ok);
        }else{
            myResponseEntity = new ResponseEntity<>(null,error);
        }

        return myResponseEntity;
    }


    @PutMapping("/fruits/{id}")
    public ResponseEntity<Fruit> updateOneById(@PathVariable("id") ObjectId id, @RequestBody Fruit newFruit){

        Fruit myFruit = myService.updateFruit(id,newFruit);

        if (myFruit !=null){
            myResponseEntity = new ResponseEntity<>(myFruit,ok);
        }else{
            myResponseEntity = new ResponseEntity<>(error);
        }

        return myResponseEntity;
    }

}
