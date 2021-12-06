package pl.model;
//* dto immutable

import lombok.*;

import javax.annotation.processing.Generated;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public  class Person {

    @Id
            @GeneratedValue(strategy = GenerationType.AUTO )

    long id;
    UUID personUUID;
    String name;
    String surname;
    String email;
    String telephone;

    @OneToOne (cascade =CascadeType.All)
            @JoinColumn (name = "adress_id", referencedColumnName = "id")
    Adress adress;




}