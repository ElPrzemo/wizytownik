package pl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Adress {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO )

    Long id:
    UUID adressUUID;
    String city;
    String street;
    Integer streetNumber;
    Integer homeNumber;
}
