package student;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public StudentNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
