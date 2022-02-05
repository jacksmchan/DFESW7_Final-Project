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

import practical.project.domain.Product;
import practical.project.repository.ProductRepository;

@SpringBootTest
public class ProductControllerTests {
  @MockBean
  private ProductRepository repository;

  @Autowired
  private ProductController controller;

  private final Product VALID_PRODUCT = new Product("Product005", "This is a very good product5", 500, 199.05);
  private final Product INVALID_PRODUCT = new Product("InvalidProduct", "This is an invalid product", 500, -199.05);

  @BeforeEach
  public void setUp() throws Exception {
    VALID_PRODUCT.setId(5L);
    List<Product> products = new LinkedList<Product>();
    products.add(new Product("Product001", "This is a very good product1", 100, 199.01));
    products.add(new Product("Product002", "This is a very good product2", 200, 199.02));
    products.add(new Product("Product003", "This is a very good product3", 300, 199.03));
    products.add(new Product("Product004", "This is a very good product4", 400, 199.04));
    when(repository.findAll()).thenReturn(products);
    when(repository.save(VALID_PRODUCT)).thenReturn(VALID_PRODUCT);
    when(repository.save(INVALID_PRODUCT)).thenReturn(null);
    when(repository.findById(VALID_PRODUCT.getId())).thenReturn(Optional.of(VALID_PRODUCT));
    when(repository.findById(INVALID_PRODUCT.getId())).thenReturn(Optional.empty());
  }

  @Test
  @DisplayName("Test deleting a valid product successfully")
  public void deleteValidProductById() throws Exception {
    assertEquals(controller.deleteById(VALID_PRODUCT.getId()), VALID_PRODUCT);
  }

  @Test
  @DisplayName("Test updating an invalid product successfully")
  public void updateInvalidProduct() throws Exception {
    assertEquals(controller.update(INVALID_PRODUCT), null);
  }

  @Test
  @DisplayName("Test updating a product successfully")
  public void updateProduct() throws Exception {
    assertEquals(controller.update(VALID_PRODUCT), VALID_PRODUCT);
  }

  @Test
  @DisplayName("Test adding a product unsuccessfully")
  public void addInvalidProduct() throws Exception {
    assertEquals(controller.add(INVALID_PRODUCT), null);
  }

  @Test
  @DisplayName("Test adding a product successfully")
  public void addProduct() throws Exception {
    assertEquals(controller.add(VALID_PRODUCT), VALID_PRODUCT);
  }

  @Test
  @DisplayName("Test retrieve all products")
  public void getProducts() throws Exception {
    assertEquals(controller.getProducts().size(), 4);
  }
}
