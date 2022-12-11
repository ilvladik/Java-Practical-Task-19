package student;

import java.util.ArrayList;

public class StudentGroup {

    private String name;
    private ArrayList<Student> students;

    public StudentGroup(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void clear() {
        students.clear();
    }

    public void addStudent(Student student) {
        if (student.getGroup() == null) {
            students.add(student);
            student.setGroup(this);
        } else {
            student.getGroup().removeStudent(student);
            student.setGroup(this);
        }
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public Student findStudent(String firstName, String lastName, String patronymic) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) &&  student.getLastName().equals(lastName) &&
                    student.getPatronymic().equals(patronymic)) {
                return student;
            }
        }
        throw new StudentNotFoundException("There is no student in this group");
    }
}
