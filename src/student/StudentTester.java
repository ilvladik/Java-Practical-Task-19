package student;

import java.util.Comparator;

public class StudentTester {

    public static void main(String[] args) {
        StudentGroup studentGroup = new StudentGroup("ИКБО-99-99");
        StudentUI studentUI = new StudentUI();
        studentUI.fillStudentGroup(studentGroup, 10);
        studentUI.sortStudent(studentGroup, Comparator.comparingDouble(Student::getGPA));
        studentUI.printStudentGroup(studentGroup);
        try {
            studentUI.findStudent(studentGroup, "Алексей", "Тереньтьев", "Викторович");
        } catch (StudentNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
