package practical.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The Entity class defined for Customer 
 *
 * <ul>
 * <li>id: Auto generated Long</li>
 * <li>name: a string contains the name of this customer</li>
 * <li>email: a string contains the email address of this customer</li>
 * </ul>
 *
 * @author jacksmchan
 * @see javax.persistence.Entity
 */
@Entity
public class Customer {
  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String email;

  /**
   * Constructor with params
   * 
   * @param name    customer name.
   * @param email   customer email.
   */
  public Customer(String name, String email) {
    this.name = name;
    this.email = email;
  }

  /**
   * Default constructor without param
   */
  Customer() {
  }

  /**
   * Getter for customer record id
   * 
   * @return customer record id
   */
  public Long getId() {
    return id;
  }

  /**
   * Setter for customer record id
   * 
   * @param customer record id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Getter for customer's name
   * 
   * @return customer's name
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for customer's name
   * 
   * @param name   customer's name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for customer's email
   * 
   * @return customer's email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Setter for customer email
   * 
   * @param email   customer's email
   */
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
