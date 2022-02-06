package practical.project.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

import practical.project.Utils;

public class InvoiceTest {
  @Test
  public void testGetterSetterQuantity() {
    Invoice invoice = new Invoice();
    invoice.setQuantity(100);
    assertTrue(100 == invoice.getQuantity());
  }

  @Test
  public void testGetterSetterCreatedDate() {
    Invoice invoice = new Invoice();
    Calendar cal = Calendar.getInstance();
    cal.setTime(Utils.parseDate("02/02/2022"));
    invoice.setCreated(cal.getTime());
    assertFalse(null == invoice.getCreated());
    assertTrue(Utils.parseDate("02/03/2022").after(invoice.getCreated()));
    assertTrue(Utils.parseDate("02/01/2022").before(invoice.getCreated()));
  }

  @Test
  public void testGetterSetterUpdatedDate() {
    Invoice invoice = new Invoice();
    Calendar cal = Calendar.getInstance();
    cal.setTime(Utils.parseDate("02/02/2022"));
    invoice.setUpdated(cal.getTime());
    assertFalse(null == invoice.getUpdated());
    assertTrue(Utils.parseDate("02/03/2022").after(invoice.getUpdated()));
    assertTrue(Utils.parseDate("02/01/2022").before(invoice.getUpdated()));
  }

  @Test
  public void testGetterSetterId() {
    Invoice invoice = new Invoice();
    invoice.setId(1234L);
    assertTrue(1234L == invoice.getId());
  }

  @Test
  public void testGetterSetterpId() {
    Invoice invoice = new Invoice();
    invoice.setpId(1234L);
    assertTrue(1234L == invoice.getpId());
  }

  @Test
  public void testGetterSettercId() {
    Invoice invoice = new Invoice();
    invoice.setcId(1234L);
    assertTrue(1234L == invoice.getcId());
  }
}
