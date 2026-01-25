package ro.scoala_informala;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor

public class Person {
    String firstName;
    String lastName;
    LocalDate birthDate;
}
