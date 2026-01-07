import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.scoala_informala.Student;
import ro.scoala_informala.StudentRepository;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class DeleteStudentTest {
    private StudentRepository repository;

    @BeforeEach
    void setUp() {
        repository = new StudentRepository();
    }

    @Test
    void deleteStudent_happyFlow_existingStudent_isDeletedSuccessfully() {
        Student student = new Student();
        student.firstName = "Matei";
        student.lastName = "Ionas";
        student.gender = "m";
        student.idCNP = "1200505123496";
        student.dateOfBirth = 2000;

        repository.addStudent(student);
        assertDoesNotThrow(() -> repository.deleteStudent("1200505123496"));
    }

    @Test
    void deleteStudent_unhappyFlow_studentDoesNotExist_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> repository.deleteStudent("777777777777"));
    }
}