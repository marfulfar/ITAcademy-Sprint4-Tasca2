package Sprint4Tasca2Nivell2Ex1FargasMarcal.services;

import Sprint4Tasca2Nivell2Ex1FargasMarcal.entities.Fruit;
import Sprint4Tasca2Nivell2Ex1FargasMarcal.repository.IFruitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceFruitImpl implements IServiceFruit {

    @Autowired
    IFruitRepo myRepo;


    public Fruit updateFruitService(int id, Fruit newFruit){
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


    public Fruit addFruit(Fruit newFruit){

        Fruit myFruit = myRepo.save(new Fruit(newFruit.getId(), newFruit.getName(), newFruit.getKgsQty()));

    return myFruit;
    }


    public Boolean deleteFruitById(int id){
        boolean eliminated;

        try {
            myRepo.deleteById(id);
            eliminated = true;

        }catch (Exception e){
            eliminated = false;
        }
        return eliminated;
    }


    public Fruit getOneById(int id){
        Optional<Fruit> tempFruit = myRepo.findById(id);
        Fruit myFruit;

        myFruit = tempFruit.orElse(null);

        return myFruit;
    }


    public List<Fruit> getAllFruits(){

        List<Fruit> fruits = myRepo.findAll();

        return fruits;
    }

}
