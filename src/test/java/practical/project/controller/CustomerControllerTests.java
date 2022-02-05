package practical.project.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import practical.project.domain.Customer;
import practical.project.repository.CustomerRepository;

@SpringBootTest
public class CustomerControllerTests {
  @MockBean
  private CustomerRepository repository;

  @Autowired
  private CustomerController controller;

  private final Customer VALID_CUSTOMER = new Customer("Customer005", "Customer005@gmail.com");
  private final Customer INVALID_CUSTOMER = new Customer("InvalidCustomer", "invalidCustomer#gmail.com");

  @BeforeEach
  public void setUp() throws Exception {
    VALID_CUSTOMER.setId(5L);
    List<Customer> customers = new LinkedList<Customer>();
    customers.add(new Customer("Customer001", "Customer001@gmail.com"));
    customers.add(new Customer("Customer002", "Customer002@gmail.com"));
    customers.add(new Customer("Customer003", "Customer003@gmail.com"));
    customers.add(new Customer("Customer004", "Customer004@gmail.com"));
    when(repository.findAll()).thenReturn(customers);
    when(repository.save(VALID_CUSTOMER)).thenReturn(VALID_CUSTOMER);
    when(repository.save(INVALID_CUSTOMER)).thenReturn(null);
    when(repository.findById(VALID_CUSTOMER.getId())).thenReturn(Optional.of(VALID_CUSTOMER));
    when(repository.findById(INVALID_CUSTOMER.getId())).thenReturn(Optional.empty());
  }

  @Test
  @DisplayName("Test deleting a valid customer successfully")
  public void deleteValidCustomerById() throws Exception {
    assertEquals(controller.deleteById(VALID_CUSTOMER.getId()), VALID_CUSTOMER);
  }

  @Test
  @DisplayName("Test updating an invalid customer successfully")
  public void updateInvalidCustomer() throws Exception {
    assertEquals(controller.update(INVALID_CUSTOMER), null);
  }

  @Test
  @DisplayName("Test updating a customer successfully")
  public void updateCustomer() throws Exception {
    assertEquals(controller.update(VALID_CUSTOMER), VALID_CUSTOMER);
  }

  @Test
  @DisplayName("Test adding a customer unsuccessfully")
  public void addInvalidCustomer() throws Exception {
    assertEquals(controller.add(INVALID_CUSTOMER), null);
  }

  @Test
  @DisplayName("Test adding a customer successfully")
  public void addCustomer() throws Exception {
    assertEquals(controller.add(VALID_CUSTOMER), VALID_CUSTOMER);
  }

  @Test
  @DisplayName("Test retrieve all customers")
  public void getCustomers() throws Exception {
    assertEquals(controller.getCustomers().size(), 4);
  }
}
