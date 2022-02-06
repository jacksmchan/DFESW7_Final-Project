package practical.project.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CustomerTest {
  @Test
  public void testToString() {
    Customer customer = new Customer("Jerry", "jerry@gmail.com");
    customer.setId(1234L);
    assertTrue("CustomerEntry(Id: 1234,Name: Jerry,Email: jerry@gmail.com)".equals(customer.toString()));
  }              
  @Test
  public void testConstructor() {
    Customer customer = new Customer();
    assertFalse(null == customer);
  }
  @Test
  public void testConstructorWithParams() {
    Customer customer = new Customer("Jerry", "jerry@gmail.com");
    assertTrue("Jerry".equals(customer.getName()));
    assertTrue("jerry@gmail.com".equals(customer.getEmail()));
  }
  @Test
  public void testGetterSetterName() {
    Customer customer = new Customer();
    customer.setName("Jerry");
    assertTrue("Jerry".equals(customer.getName()));
  }

  @Test
  public void testGetterSetterEmail() {
    Customer customer = new Customer();
    customer.setEmail("jerry@gmail.com");
    assertTrue("jerry@gmail.com".equals(customer.getEmail()));
  }

  @Test
  public void testGetterSetterId() {
    Customer customer = new Customer();
    customer.setId(1234L);
    assertTrue(1234L == customer.getId());
  }
}
