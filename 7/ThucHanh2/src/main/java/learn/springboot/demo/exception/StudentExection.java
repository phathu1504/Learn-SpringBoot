package learn.springboot.demo.exception;

public class StudentExection extends RuntimeException {
    public StudentExection(String message) {
        super(message);
    }
}
