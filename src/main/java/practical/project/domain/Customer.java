package practical.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String email;

  public Customer(String name, String email) {
    this.name = name;
    this.email = email;
  }

  Customer() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String toString() {
    StringBuilder value = new StringBuilder("CustomerEntry(");
    value.append("Id: ");
    value.append(id);
    value.append(",Name: ");
    value.append(name);
    value.append(",Email: ");
    value.append(email);
    value.append(")");
    return value.toString();
  }
}
