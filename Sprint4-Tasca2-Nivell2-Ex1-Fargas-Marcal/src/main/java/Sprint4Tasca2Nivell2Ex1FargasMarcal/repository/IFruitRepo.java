package Sprint4Tasca2Nivell2Ex1FargasMarcal.repository;

import Sprint4Tasca2Nivell2Ex1FargasMarcal.entities.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFruitRepo extends JpaRepository<Fruit, Integer> {
}
