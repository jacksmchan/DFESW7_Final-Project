package practical.project.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import practical.project.domain.Invoice;
import practical.project.repository.InvoiceRepository;

@SpringBootTest
public class InvoiceControllerTests {
  @MockBean
  private InvoiceRepository repository;

  @Autowired
  private InvoiceController controller;

  private final Date TODAY = Calendar.getInstance().getTime();
  private final Invoice VALID_INVOICE = new Invoice(1L, 1L, 500, TODAY, TODAY);
  private final Invoice INVALID_INVOICE = new Invoice(-1L, -1L, 500, null, null);

  @BeforeEach
  public void setUp() throws Exception {
    VALID_INVOICE.setId(5L);
    List<Invoice> invoices = new LinkedList<Invoice>();
    invoices.add(new Invoice(1L, 2L, 500, TODAY, TODAY));
    invoices.add(new Invoice(2L, 1L, 500, TODAY, TODAY));
    invoices.add(new Invoice(1L, 3L, 500, TODAY, TODAY));
    invoices.add(new Invoice(4L, 2L, 500, TODAY, TODAY));
    when(repository.findAll()).thenReturn(invoices);
    when(repository.save(VALID_INVOICE)).thenReturn(VALID_INVOICE);
    when(repository.save(INVALID_INVOICE)).thenReturn(null);
    when(repository.findById(VALID_INVOICE.getId())).thenReturn(Optional.of(VALID_INVOICE));
    when(repository.findById(INVALID_INVOICE.getId())).thenReturn(Optional.empty());
  }

  @Test
  @DisplayName("Test deleting a valid invoice successfully")
  public void deleteValidInvoiceById() throws Exception {
    assertEquals(controller.deleteById(VALID_INVOICE.getId()), VALID_INVOICE);
  }

  @Test
  @DisplayName("Test updating an invalid invoice successfully")
  public void updateInvalidInvoice() throws Exception {
    assertEquals(controller.update(INVALID_INVOICE), null);
  }

  @Test
  @DisplayName("Test updating a invoice successfully")
  public void updateInvoice() throws Exception {
    assertEquals(controller.update(VALID_INVOICE), VALID_INVOICE);
  }

  @Test
  @DisplayName("Test adding a invoice unsuccessfully")
  public void addInvalidInvoice() throws Exception {
    assertEquals(controller.add(INVALID_INVOICE), null);
  }

  @Test
  @DisplayName("Test adding a invoice successfully")
  public void addInvoice() throws Exception {
    assertEquals(controller.add(VALID_INVOICE), VALID_INVOICE);
  }

  @Test
  @DisplayName("Test retrieve all invoices")
  public void getInvoices() throws Exception {
    assertEquals(controller.getInvoices().size(), 4);
  }
}
