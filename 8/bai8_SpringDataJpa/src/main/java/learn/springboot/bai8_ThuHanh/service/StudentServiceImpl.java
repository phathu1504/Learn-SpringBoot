package learn.springboot.bai8_ThuHanh.service;

import jakarta.transaction.Transactional;
import learn.springboot.bai8_ThuHanh.dao.StudentReponsitory;
import learn.springboot.bai8_ThuHanh.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentReponsitory studentReponsitory;

    @Autowired
    public StudentServiceImpl(StudentReponsitory studentReponsitory) {
        this.studentReponsitory = studentReponsitory;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentReponsitory.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentReponsitory.getReferenceById(id);
    }

    @Override
    @Transactional
    public Student addStuden(Student student) {
        return studentReponsitory.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return studentReponsitory.saveAndFlush(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        studentReponsitory.deleteById(id);
    }
}
