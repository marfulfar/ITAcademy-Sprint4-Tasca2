package Sprint4Tasca2Nivell1Ex1FargasMarcal.Sprint4Tasca2Nivell1Ex1FargasMarcal.model.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Fruits")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;


    @Column
    private int kgsQty;



}
