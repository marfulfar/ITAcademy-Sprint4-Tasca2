package Sprint4Tasca2Ex1Nivell3FargasMarcal.Service;

import Sprint4Tasca2Ex1Nivell3FargasMarcal.Entities.Fruit;
import Sprint4Tasca2Ex1Nivell3FargasMarcal.Repository.IFruitRepoMongo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements IFruitService{

    @Autowired
    IFruitRepoMongo myRepo;


    public Fruit addFruit(Fruit fruit) {

        Fruit myFruit = myRepo.save(fruit);

        return myFruit;
    }



    public Boolean deleteOneById(ObjectId id){
        boolean eliminated;

        try {
            myRepo.deleteById(id);
            eliminated = true;

        }catch (Exception e){
            eliminated = false;
        }
        return eliminated;
    }


    public Fruit getOneById(ObjectId id){
        Optional<Fruit> tempFruit = myRepo.findById(id);
        Fruit myFruit;

        myFruit = tempFruit.orElse(null);

        return myFruit;
    }


    public List<Fruit> getAllFruits(){

        List<Fruit> fruits = myRepo.findAll();

        return fruits;
    }


    public Fruit updateFruit(ObjectId id, Fruit newFruit){
        Fruit tempFruit = null;

        if (myRepo.existsById(id)){
            Optional<Fruit> oldFruit = myRepo.findById(id);
            tempFruit = oldFruit.get();
            tempFruit.setName(newFruit.getName());
            tempFruit.setKgsQty(newFruit.getKgsQty());

            myRepo.save(tempFruit);
        }

        return tempFruit;
    }




}
