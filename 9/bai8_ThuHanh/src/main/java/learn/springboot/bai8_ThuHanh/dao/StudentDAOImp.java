package learn.springboot.bai8_ThuHanh.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import learn.springboot.bai8_ThuHanh.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // phuc vu truy suat du lieu
public class StudentDAOImp implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        String jpql = "SELECT s FROM Student s";
        return entityManager.createQuery(jpql, Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    public Student saveAndFlush(Student student) {
        student = entityManager.merge(student);
        // Day du lieu xuong va xuat hien ngay trong table thay vi luu o bo nho tam
        entityManager.flush();
        return student;
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(findById(id));
    }
}
