package ro.scoala_informala;

import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Logger logger =
            Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository();
        try {
            Student student = new Student();
            student.firstName = "Ion";
            student.lastName = "Bejan";
            student.gender = "m";
            student.idCNP = "2980505123470";
            student.dateOfBirth = 2001;
            repository.addStudent(student);


            Student student2 = new Student();
            student2.firstName = "Ion";
            student2.lastName = "Colesov";
            student2.gender = "m";
            student2.idCNP = "2980505123460";
            student2.dateOfBirth = 2001;
            repository.addStudent(student2);

            System.out.println("Student added successfully!");

        } catch (IllegalArgumentException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }

//        try {
//            repository.deleteStudent("2980505123450");
//            System.out.println("Student deleted successfully");
//        } catch (IllegalArgumentException e) {
//            System.out.println("Delete error: " + e.getMessage());
//        }
        try {
            System.out.println("Students aged 25:");
            repository.retrieveStudentsByAge("25")
                    .forEach(s -> System.out.println(s.firstName + " " + s.lastName));

            System.out.println("Students ordered by last name:");
            repository.listStudentsOrderedBy("lastName")
                    .forEach(s -> System.out.println(s.lastName));

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}