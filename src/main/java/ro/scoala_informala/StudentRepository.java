package ro.scoala_informala;

import java.time.Year;
import java.util.*;
import java.util.logging.Logger;

public class StudentRepository {

    private final Map<String, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        logger.info("Adding student: " + student);
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }

        if (student.firstName == null || student.firstName.isBlank()) {
            throw new IllegalArgumentException("Student first name cannot be null or empty");
        }

        if (student.lastName == null || student.lastName.isBlank()) {
            throw new IllegalArgumentException("Student last name cannot be null or empty");
        }

        if (student.gender == null || student.gender.isBlank()) {
            throw new IllegalArgumentException("Student gender cannot be null or empty");
        }

        if (student.idCNP == null || student.idCNP.isBlank()) {
            throw new IllegalArgumentException("Student id CNP cannot be null or empty");
        }

        String gender = student.gender.trim().toLowerCase();
        if (!gender.equals("male")
                && !gender.equals("female")
                && !gender.equals("m")
                && !gender.equals("f")) {
            throw new IllegalArgumentException("Student gender must be Male, Female, M or F");
        }

        int birthYear = student.dateOfBirth;   // assumed int
        int currentYear = Year.now().getValue();
        int maxAllowedYear = currentYear - 18;

        if (birthYear < 1900) {
            throw new IllegalArgumentException("Student birth year cannot be before 1900");
        }

        if (birthYear > maxAllowedYear) {
            throw new IllegalArgumentException("Student must be at least 18 years old");
        }
        students.put(student.idCNP, student);
    }

    public void deleteStudent(String idCNP) {
        logger.info("Deleting student: " + idCNP);
        if (idCNP == null || idCNP.isBlank()) {
            throw new IllegalArgumentException("Student ID cannot be null or empty");
        }
        if (!students.containsKey(idCNP)) {
            throw new IllegalArgumentException("Student does not exist with ID: " + idCNP);
        }
        students.remove(idCNP);
    }

    public List<Student> retrieveStudentsByAge(String ageInput) {
        logger.info("Retrieving students by age: " + ageInput);

        if (ageInput == null || ageInput.isBlank()) {
            throw new IllegalArgumentException("Age cannot be null or empty");
        }

        int age;
        try {
            age = Integer.parseInt(ageInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Age must be a number");
        }

        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        int currentYear = Year.now().getValue();
        int expectedBirthYear = currentYear - age;

        List<Student> result = new ArrayList<>();

        for (Student student : students.values()) {
            if (student.dateOfBirth == expectedBirthYear) {
                result.add(student);
            }
        }

        return result;
    }

    public List<Student> listStudentsOrderedBy(String orderBy) {

        if (orderBy == null || orderBy.isBlank()) {
            throw new IllegalArgumentException("Order criteria cannot be null or empty");
        }

        List<Student> result = new ArrayList<>(students.values());

        String criteria = orderBy.trim().toLowerCase();

        if (criteria.equals("lastname")) {
            result.sort(Comparator.comparing(s -> s.lastName.toLowerCase()));
        } else if (criteria.equals("birthdate")) {
            result.sort(Comparator.comparingInt(s -> s.dateOfBirth));
        } else {
            throw new IllegalArgumentException(
                    "Invalid order criteria. Use 'lastName' or 'birthDate'");
        }

        return result;
    }

    private static final Logger logger =
            Logger.getLogger(StudentRepository.class.getName());

    }



