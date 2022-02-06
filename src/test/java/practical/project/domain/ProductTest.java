package practical.project.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ProductTest {
  @Test
  public void testToString() {
    Product product = new Product();
    product.setName("Product001");
    product.setQuantity(100);
    product.setPrice(100.01);
    product.setId(1234L);
    assertTrue("ProductEntry(Id: 1234,Name: Product001,Description: null,Quantity: 100,Price: £100.01)".equals(product.toString()));
  }              
  @Test
  public void testGetterSetterName() {
    Product product = new Product();
    product.setName("Product001");
    assertTrue("Product001".equals(product.getName()));
  }

  @Test
  public void testGetterSetterQuantity() {
    Product product = new Product();
    product.setQuantity(100);
    assertTrue(100 == product.getQuantity());
  }

  @Test
  public void testGetterSetterPrice() {
    Product product = new Product();
    product.setPrice(100.01);
    assertTrue(100.01 == product.getPrice());
  }

  @Test
  public void testGetterSetterEmail() {
    Product product = new Product();
    product.setDescription("What a good product!");
    assertTrue("What a good product!".equals(product.getDescription()));
  }

  @Test
  public void testGetterSetterId() {
    Product product = new Product();
    product.setId(1234L);
    assertTrue(1234L == product.getId());
  }
}
