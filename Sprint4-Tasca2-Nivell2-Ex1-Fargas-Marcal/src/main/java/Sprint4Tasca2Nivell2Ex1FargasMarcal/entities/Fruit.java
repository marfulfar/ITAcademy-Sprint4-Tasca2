package Sprint4Tasca2Nivell2Ex1FargasMarcal.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fruits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int kgsQty;



}
