package Sprint4Tasca2Ex1Nivell3FargasMarcal.Service;

import Sprint4Tasca2Ex1Nivell3FargasMarcal.Entities.Fruit;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface IFruitService {

    public Fruit addFruit(Fruit fruit);

    public Boolean deleteOneById(ObjectId id);


    public Fruit getOneById(ObjectId id);


    public List<Fruit> getAllFruits();


    public Fruit updateFruit(ObjectId id, Fruit newFruit);



}
