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

import practical.project.domain.Customer;
import practical.project.repository.CustomerRepository;

@Controller
public class CustomerController {
  @Autowired
  CustomerRepository repo;

  @RequestMapping (value = "/customers", produces = {
      MediaType.APPLICATION_JSON_VALUE
  })
  public @ResponseBody List<Customer> getCustomers() {
    return repo.findAll();
  }

  @RequestMapping (value = "/customer", method = RequestMethod.POST, produces = {
      MediaType.APPLICATION_JSON_VALUE
  })
  public @ResponseBody Customer add(@RequestBody Customer entry) {
    repo.save(entry);
    return entry;
  }

  @RequestMapping (value = "/customer", method = RequestMethod.PUT)
  public @ResponseBody Customer update(@RequestBody Customer entry) {
    Optional<Customer> customer = repo.findById(entry.getId());
    if (customer.isPresent()) {
      repo.save(entry);
      return entry;
    }
    return null;
  }

  @RequestMapping (value = "/customer/id/{id}", method = RequestMethod.DELETE)
  public @ResponseBody Customer deleteById(@PathVariable Long id) {
    Optional<Customer> customer = repo.findById(id);
    if (customer.isPresent()) {
      repo.deleteById(id);
      return customer.get();
    }
    return null;
  }

  @RequestMapping (value = "/customer/name/{name}", method = RequestMethod.DELETE)
  public @ResponseBody List<Customer> deleteByNameContains(@PathVariable String name) {
    List<Customer> products = repo.findAll()
        .stream()
        .filter(entry -> entry.getName().toLowerCase().contains(name.toLowerCase()))
        .collect(Collectors.toList());
    repo.deleteInBatch(products);
    return products;
  }

  @RequestMapping ("/customer/findBy/name/{name}")
  public @ResponseBody List<Customer> findByNameContains(@PathVariable String name) {
    return repo.findAll()
        .stream()
        .filter(entry -> entry.getName().toLowerCase().contains(name.toLowerCase()))
        .collect(Collectors.toList());
  }
}
