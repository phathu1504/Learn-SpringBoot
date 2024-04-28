package learn.springboot.mvcdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import learn.springboot.mvcdemo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
