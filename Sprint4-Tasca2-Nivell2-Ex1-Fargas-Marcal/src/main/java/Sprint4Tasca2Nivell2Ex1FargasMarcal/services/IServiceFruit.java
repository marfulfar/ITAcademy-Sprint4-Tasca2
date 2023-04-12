package Sprint4Tasca2Nivell2Ex1FargasMarcal.services;

import Sprint4Tasca2Nivell2Ex1FargasMarcal.entities.Fruit;

import java.util.List;

public interface IServiceFruit {


    public Fruit updateFruitService(int id, Fruit newFruit);


    public Fruit addFruit(Fruit newFruit);


    public Boolean deleteFruitById(int id);


    public Fruit getOneById(int id);


    public List<Fruit> getAllFruits();




}
