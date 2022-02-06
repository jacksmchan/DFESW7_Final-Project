package practical.project.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import practical.project.domain.Product;
import practical.project.repository.ProductRepository;


/**
 * The web controller used to expose RESTful APIs related with products 
 *
 * <ul>
 * <li>GET /products: used to list all registered products</li>
 * <li>GET /product/id/{id}: used to find an existing product record by its id</li>
 * <li>GET /product/name/{name}: used to list all product records if product's name contains the given string</li>
 * <li>POST /product: used to add a new product</li>
 * <li>PUT /product: used to update an existing product</li>
 * <li>DELETE /product/id/{id}: used to delete an existing product record by its id</li>
 * <li>DELETE /product/name/{name}: used to delete product records if product's name contains the given string</li>
 * </ul>
 *
 * @author jacksmchan
 * @see org.springframework.stereotype.Controller
 * @see practical.project.domain.Product
 * @see practical.project.repository.ProductRepository
 */
@Controller
public class ProductController {
  @Autowired
  private ProductRepository repo;

  /**
   * List all registered products
   * 
   * @return a list all products available
   */
  @RequestMapping (value = "/products", produces = {
      MediaType.APPLICATION_JSON_VALUE
  })
  public @ResponseBody List<Product> getProducts() {
    return repo.findAll();
  }

  /**
   * Add a new product
   * 
   * @param entry   the Product object to be added and must not be {@literal null}.
   * @return the added Product object; will never be {@literal null}.
   */
  @RequestMapping (value = "/product", method = RequestMethod.POST, produces = {
      MediaType.APPLICATION_JSON_VALUE
  })
  public @ResponseBody Product add(@RequestBody Product entry) {
    return repo.save(entry);
  }

  /**
   * Update an existing product
   * 
   * @param entry   the Product object to be updated and must not be {@literal null}.
   * @return the updated Product object if valid; {@literal null}, otherwise.
   */
  @RequestMapping (value = "/product", method = RequestMethod.PUT)
  public @ResponseBody Product update(@RequestBody Product entry) {
    Optional<Product> product = repo.findById(entry.getId());
    return product.isPresent() ? repo.save(entry) : null;
  }

  /**
   * Delete an existing product record by its id
   * 
   * @param id   the id of an existing Product 
   * @return the deleted Product object if valid; {@literal null}, otherwise.
   */
  @RequestMapping (value = "/product/id/{id}", method = RequestMethod.DELETE)
  public @ResponseBody Product deleteById(@PathVariable Long id) {
    Optional<Product> product = repo.findById(id);
    if (product.isPresent()) {
      repo.deleteById(id);
      return product.get();
    }
    return null;
  }

  /**
   * Delete product records if product's name contains the given string
   * 
   * @param name   the part of an existing Product's name 
   * @return the deleted Product objects if any; empty list, otherwise.
   */
  @RequestMapping (value = "/product/name/{name}", method = RequestMethod.DELETE)
  public @ResponseBody List<Product> deleteByNameContains(@PathVariable String name) {
    List<Product> products = repo.findAll()
        .stream()
        .filter(entry -> entry.getName().toLowerCase().contains(name.toLowerCase()))
        .collect(Collectors.toList());
    repo.deleteAllInBatch(products);
    return products;
  }

  /**
   * List product records if product's name contains the given string
   * 
   * @param name   the part of an existing Product's name 
   * @return the found Product objects if any; empty list, otherwise.
   */
  @RequestMapping ("/product/findBy/name/{name}")
  public @ResponseBody List<Product> findByNameContains(@PathVariable String name) {
    return repo.findAll()
        .stream()
        .filter(entry -> entry.getName().toLowerCase().contains(name.toLowerCase()))
        .collect(Collectors.toList());
  }
}
