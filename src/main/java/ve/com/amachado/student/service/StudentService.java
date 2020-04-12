package ve.com.amachado.student.service;

import java.util.Optional;
import ve.com.amachado.student.entity.Student;

public interface StudentService {

  public Iterable<Student> findAll();

  public Optional<Student> findById(Long id);

  public Student save(Student student);

  public void delete(Long id);

}
