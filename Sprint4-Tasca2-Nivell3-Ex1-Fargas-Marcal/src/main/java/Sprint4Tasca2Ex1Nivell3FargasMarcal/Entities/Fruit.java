package Sprint4Tasca2Ex1Nivell3FargasMarcal.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Data
@Document(collection = "fruits")
@NoArgsConstructor
@AllArgsConstructor
public class Fruit {


    @Id
    private ObjectId id;

    private String name;

    private int kgsQty;


}
