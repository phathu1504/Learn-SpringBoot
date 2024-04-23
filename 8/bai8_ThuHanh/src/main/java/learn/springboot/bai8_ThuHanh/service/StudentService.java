package learn.springboot.bai8_ThuHanh.service;

import learn.springboot.bai8_ThuHanh.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();

    public Student getStudentById(int id);

    public Student addStuden(Student student);

    public Student updateStudent(Student student);

    public void deleteStudent(int id);
}
