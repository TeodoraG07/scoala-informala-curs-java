package ro.scoala_informala;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonManagement {

    public List<Person> parse(List<String> lines) {

        return lines.stream()
                .skip(1)
                .filter(line -> !line.isBlank())
                .map(line -> {
                    String[] parts = line.split(",");

                    return new Person(
                            parts[0].trim(),
                            parts[1].trim(),
                            LocalDate.parse(parts[2].trim())
                    );
                })
                .collect(Collectors.toList());
    }

    public List<Person> bornInMonth(List<Person> people, int month) {

        return people.stream()
                .filter(p -> p.getBirthDate().getMonthValue() == month)
                .collect(Collectors.toList());
    }

    public List<Person> sortAlphabetically(List<Person> people) {

        return people.stream()
                .sorted(
                        Comparator.comparing(Person::getLastName)
                                .thenComparing(Person::getFirstName)
                )
                .collect(Collectors.toList());
    }

    public List<String> toOutputLines(List<Person> people) {

        return people.stream()
                .map(p -> p.getFirstName() + " " + p.getLastName())
                .collect(Collectors.toList());
    }


    public List<String> process(List<String> lines, int month) {

        List<Person> people = parse(lines);
        List<Person> filtered = bornInMonth(people, month);
        List<Person> sorted = sortAlphabetically(filtered);

        return toOutputLines(sorted);
    }
}

