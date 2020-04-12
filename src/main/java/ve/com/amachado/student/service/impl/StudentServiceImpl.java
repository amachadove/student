package ve.com.amachado.student.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ve.com.amachado.student.entity.Student;
import ve.com.amachado.student.repository.StudentRepository;
import ve.com.amachado.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentRepository repository;

  @Override
  @Transactional(readOnly = true)
  public Iterable<Student> findAll() {
    return repository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Student> findById(Long id) {
    return repository.findById(id);
  }

  @Override
  @Transactional
  public Student save(Student student) {
    return repository.save(student);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    repository.deleteById(id);
  }
}
