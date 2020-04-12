package ve.com.amachado.student.controller;

import java.util.Optional;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ve.com.amachado.student.entity.Student;
import ve.com.amachado.student.service.StudentService;

@RestController
public class StudentController {

  @Autowired
  private StudentService service;

  @GetMapping
  public ResponseEntity<?> listAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> listById(@PathVariable Long id) {

    Optional<Student> response = service.findById(id);

    if (response.isPresent()) {
      return ResponseEntity.notFound().build();
    }

    return (ResponseEntity.ok().body(response.get()));
  }

  @PostMapping
  public ResponseEntity<?> save(@RequestBody Student student) {
    Student response = service.save(student);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @PutMapping("/{id]")
  public ResponseEntity<?> update(@RequestBody Student student,
      @PathVariable Long id) {

    Optional<Student> response = service.findById(id);

    if (response.isPresent()) {
      return ResponseEntity.notFound().build();
    }

    Student searchStudent = response.get();
    searchStudent.setName(student.getName());
    searchStudent.setLastName(student.getLastName());
    searchStudent.setEmail(student.getEmail());

    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(searchStudent));

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
