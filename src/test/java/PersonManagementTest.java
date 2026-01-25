import org.junit.jupiter.api.Test;
import ro.scoala_informala.Person;
import ro.scoala_informala.PersonManagement;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonManagementTest {

    private final PersonManagement personManagement = new PersonManagement();

    @Test
    void createPersonsFromInputLines() {

        List<String> lines = List.of(
                "firstName,lastName,birthDate",
                "Maria,Popovici,1997-05-10",
                "Ioana,State,1986-07-20"
        );

        List<Person> people = personManagement.parse(lines);

        assertEquals(2, people.size());
        assertEquals("Maria", people.get(0).getFirstName());
        assertEquals("Popovici", people.get(0).getLastName());
        assertEquals(LocalDate.of(1997, 5, 10), people.get(0).getBirthDate());
    }

    @Test
    void bornInSameMonth() {

        List<Person> people = List.of(
                new Person("Vasile", "Ion", LocalDate.of(2000, 7, 9)),
                new Person("Mila", "Arena", LocalDate.of(2001, 7, 23)),
                new Person("Alexandrina", "Vasile", LocalDate.of(2000, 12, 9))
        );

        List<Person> result = personManagement.bornInMonth(people, 7);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(p -> p.getBirthDate().getMonthValue() == 7));
    }

    @Test
    void sortReturnSameMonthFile() {

        List<String> lines = List.of(
                "firstName,lastName,birthDate",
                "Vasile,Bade,1985-10-10",
                "Ion,Popescu,2001-10-12",
                "Valerica,Stamate,2005-11-20"
        );

        List<String> output = personManagement.process(lines, 10);

        assertEquals(List.of(
                "Vasile Bade",
                "Ion Popescu"
        ), output);
    }
}