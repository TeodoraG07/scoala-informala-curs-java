
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.scoala_informala.Student;
import ro.scoala_informala.StudentRepository;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AddStudentTest {
    private StudentRepository repository;

    @BeforeEach
    void setUp() {
        repository = new StudentRepository();
    }

    @Test
    public void addStudent_happyFlow_studentIsAddedSuccessfully() {
        Student student = new Student();
        student.firstName = "Ioana";
        student.lastName = "Matei";
        student.gender = "f";
        student.idCNP = "2970505123456";
        student.dateOfBirth = 1997;
        repository.addStudent(student);
        assertDoesNotThrow(() -> repository.addStudent(student));
    }

    @Test
    public void addStudent_unhappyFlow_first_name_missing_studentIsNotAddedSuccessfully() {
//expected to fail
        Student student = new Student();
        student.firstName = "";
        student.lastName = "Agapi";
        student.gender = "f";
        student.idCNP = "2970505123456";
        student.dateOfBirth = 1997;
        assertThrows(
                IllegalArgumentException.class,
                () -> repository.addStudent(student)
        );
    }

    @Test
    public void addStudent_unhappyFlow_last_name_missing_studentIsNotAddedSuccessfully() {
//expected to fail
        Student student = new Student();
        student.firstName = "Oana";
        student.lastName = "";
        student.gender = "f";
        student.idCNP = "2970505123456";
        student.dateOfBirth = 1997;
        assertThrows(IllegalArgumentException.class,
                () -> repository.addStudent(student)
        );

    }

    @Test
    public void addStudent_unhappyFlow_idCNP_missing_studentIsNotAddedSuccessfully() {
//expected to fail
        Student student = new Student();
        student.firstName = "Oana";
        student.lastName = "Marion";
        student.gender = "f";
        student.idCNP = "";
        student.dateOfBirth = 1997;
        assertThrows(IllegalArgumentException.class,
                () -> repository.addStudent(student)
        );

    }

    @Test
    public void addStudent_unhappyFlow_ageNotExpected_studentIsNotAddedSuccessfully() {
//expected to fail
        Student student = new Student();
        student.firstName = "Oana";
        student.lastName = "Capitanescu";
        student.gender = "f";
        student.idCNP = "2970505123456";
        student.dateOfBirth = 0;
        assertThrows(IllegalArgumentException.class,
                () -> repository.addStudent(student)
        );

    }

}

