package learn.springboot.bai8_ThuHanh.dao;

import learn.springboot.bai8_ThuHanh.entity.Student;

import java.util.List;

public interface StudentDAO {

    public List<Student> findAll();

    public Student findById(int id);

    public Student save(Student student);

    // Update
    public Student saveAndFlush(Student student);

    public void deleteById(int id);
}
