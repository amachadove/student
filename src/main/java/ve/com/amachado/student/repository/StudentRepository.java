package ve.com.amachado.student.repository;

import org.springframework.data.repository.CrudRepository;
import ve.com.amachado.student.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
