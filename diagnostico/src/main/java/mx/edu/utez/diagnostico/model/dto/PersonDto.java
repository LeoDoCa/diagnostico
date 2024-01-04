package mx.edu.utez.diagnostico.model.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDto {
    private int id_person;
    private String name;
    private String lastname;
    private String curp;
    private String birthdate;
}
