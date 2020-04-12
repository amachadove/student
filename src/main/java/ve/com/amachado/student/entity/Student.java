package ve.com.amachado.student.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String lastName;

  private String email;

  @Column(name = "create_at")
  private Date createAt;

  @PrePersist
  public void preStudent() {
      this.createAt = new Date();
  }

}
