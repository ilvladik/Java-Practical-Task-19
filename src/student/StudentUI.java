package student;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class StudentUI {

    private void merge(ArrayList<Student> arrayList, int start, int end, int middle, Comparator<Student> comparator) {
        ArrayList<Student> merged = new ArrayList<>(end-start+1);
        int i = start;
        int j = middle + 1;
        while (i <= middle && j <= end) {
            if (comparator.compare(arrayList.get(i), arrayList.get(j)) > 0) {
                merged.add(arrayList.get(i));
                i++;
            } else {
                merged.add(arrayList.get(j));
                j++;
            }
        }
        while (i <= middle) {
            merged.add(arrayList.get(i));
            i++;
        }
        while (j <= middle) {
            merged.add(arrayList.get(j));
            j++;
        }
        for (int k = 0; k < merged.size(); k++) {
            arrayList.set(k+start, merged.get(k));
        }

    }

    private void mergeSortInner(ArrayList<Student> students, int start, int end, Comparator<Student> comparator) {
        int middle = (start + end) / 2;
        if (start < end) {
            mergeSortInner(students, start, middle, comparator);
            mergeSortInner(students, middle+1, end, comparator);
            merge(students, start, end, middle, comparator);
        }
    }

    public void sortStudent(StudentGroup studentGroup) {
        Comparator<Student> comparator = Comparator.comparing(Student::getLastName);
        sortStudent(studentGroup, comparator);
    }

    public void sortStudent(StudentGroup studentGroup, Comparator<Student> comparator) {
        ArrayList<Student> arrayList = studentGroup.getStudents();
        int length = arrayList.size();
        mergeSortInner(arrayList, 0, length-1, comparator);
    }

    public Student findStudent(StudentGroup studentGroup, String firstName, String lastName, String patronymic) {
        return studentGroup.findStudent(firstName, lastName, patronymic);
    }

    public void fillStudentGroup(StudentGroup studentGroup, int count) {
        for (int i = 0; i < count; i++) {
            String firstName = "Алексей" + i;
            String lastName = "Тереньтьев" + i;
            String patronymic = "Викторович" + i;
            String specialization = "Программная инженерия";
            Random random = new Random();
            double GPA = random.nextFloat(1F, 5F);

            studentGroup.addStudent(new Student(firstName, lastName, patronymic,
                    specialization, GPA));
        }
    }

    public void printStudentGroup(StudentGroup studentGroup) {
        ArrayList<Student> students = studentGroup.getStudents();
        if (!students.isEmpty()) {
            System.out.println("Группа: " + studentGroup.getName());
            for (Student student : students) {
                System.out.println(student.getLastName() + " " +
                        student.getFirstName() + " " +
                        student.getPatronymic() + " " +
                        student.getGPA());
            }
        } else {
            System.out.println("В группе " + studentGroup.getName() + " никого нет");
        }
    }
}
