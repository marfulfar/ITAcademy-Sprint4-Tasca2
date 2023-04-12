package Sprint4Tasca2Ex1Nivell3FargasMarcal.Repository;

import Sprint4Tasca2Ex1Nivell3FargasMarcal.Entities.Fruit;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface IFruitRepoMongo extends MongoRepository<Fruit, ObjectId> {
}
