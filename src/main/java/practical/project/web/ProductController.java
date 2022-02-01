package practical.project.web;

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

@Controller
public class ProductController {
  @Autowired
  ProductRepository repo;

  @RequestMapping (value = "/products", produces = {
      MediaType.APPLICATION_JSON_VALUE
  })
  public @ResponseBody List<Product> getProducts() {
    return repo.findAll();
  }

  @RequestMapping (value = "/product", method = RequestMethod.POST, produces = {
      MediaType.APPLICATION_JSON_VALUE
  })
  public @ResponseBody Product add(@RequestBody Product entry) {
    repo.save(entry);
    return entry;
  }

  @RequestMapping (value = "/product", method = RequestMethod.PUT)
  public @ResponseBody Product update(@RequestBody Product entry) {
    Optional<Product> product = repo.findById(entry.getId());
    if (product.isPresent()) {
      repo.save(entry);
      return entry;
    }
    return null;
  }

  @RequestMapping (value = "/product/id/{id}", method = RequestMethod.DELETE)
  public @ResponseBody Product deleteById(@PathVariable Long id) {
    Optional<Product> product = repo.findById(id);
    if (product.isPresent()) {
      repo.deleteById(id);
      return product.get();
    }
    return null;
  }

  @RequestMapping (value = "/product/name/{name}", method = RequestMethod.DELETE)
  public @ResponseBody List<Product> deleteByNameContains(@PathVariable String name) {
    List<Product> products = repo.findAll()
        .stream()
        .filter(entry -> entry.getName().toLowerCase().contains(name.toLowerCase()))
        .collect(Collectors.toList());
    repo.deleteInBatch(products);
    return products;
  }

  @RequestMapping ("/product/findBy/name/{name}")
  public @ResponseBody List<Product> findByNameContains(@PathVariable String name) {
    return repo.findAll()
        .stream()
        .filter(entry -> entry.getName().toLowerCase().contains(name.toLowerCase()))
        .collect(Collectors.toList());
  }
}
