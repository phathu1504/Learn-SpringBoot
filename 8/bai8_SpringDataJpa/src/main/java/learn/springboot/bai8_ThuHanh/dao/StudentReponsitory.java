package learn.springboot.bai8_ThuHanh.dao;

import learn.springboot.bai8_ThuHanh.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentReponsitory extends JpaRepository<Student, Integer> {
}
