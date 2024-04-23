package learn.springboot.bai8_ThuHanh.service;

import jakarta.transaction.Transactional;
import learn.springboot.bai8_ThuHanh.dao.StudentDAO;
import learn.springboot.bai8_ThuHanh.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDAO.findById(id);
    }

    @Override
    @Transactional
    public Student addStuden(Student student) {
        return studentDAO.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return studentDAO.saveAndFlush(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        studentDAO.deleteById(id);
    }
}
