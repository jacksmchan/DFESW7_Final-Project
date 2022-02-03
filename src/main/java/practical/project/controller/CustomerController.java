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

import practical.project.domain.Customer;
import practical.project.repository.CustomerRepository;

/**
 * The web controller used to expose RESTful APIs related with customers 
 *
 * <ul>
 * <li>GET /customers: used to list all registered customers</li>
 * <li>GET /customer/id/{id}: used to find an existing customer record by its id</li>
 * <li>GET /customer/name/{name}: used to list all customer records if customer's name contains the given string</li>
 * <li>POST /customer: used to add a new customer</li>
 * <li>PUT /customer: used to update an existing customer</li>
 * <li>DELETE /customer/id/{id}: used to delete an existing customer record by its id</li>
 * <li>DELETE /customer/name/{name}: used to delete customer records if customer's name contains the given string</li>
 * </ul>
 *
 * @author jacksmchan
 * @see org.springframework.stereotype.Controller
 * @see practical.project.domain.Customer
 * @see practical.project.repository.CustomerRepository
 */
@Controller
public class CustomerController {
  @Autowired
  private CustomerRepository repo;

  /**
   * List all registered customers
   * 
   * @return a list all customers available
   */
  @RequestMapping (value = "/customers", produces = {
      MediaType.APPLICATION_JSON_VALUE
  })
  public @ResponseBody List<Customer> getCustomers() {
    return repo.findAll();
  }

  /**
   * Add a new customer
   * 
   * @param entry   the Customer object to be added and must not be {@literal null}.
   * @return the added Customer object; will never be {@literal null}.
   */
  @RequestMapping (value = "/customer", method = RequestMethod.POST, produces = {
      MediaType.APPLICATION_JSON_VALUE
  })
  public @ResponseBody Customer add(@RequestBody Customer entry) {
    return repo.save(entry);
  }

  /**
   * Update an existing customer
   * 
   * @param entry   the Customer object to be updated and must not be {@literal null}.
   * @return the updated Customer object if valid; {@literal null}, otherwise.
   */
  @RequestMapping (value = "/customer", method = RequestMethod.PUT)
  public @ResponseBody Customer update(@RequestBody Customer entry) {
    Optional<Customer> customer = repo.findById(entry.getId());
    if (customer.isPresent()) {
      return repo.save(entry);
    }
    return null;
  }

  /**
   * Delete an existing customer record by its id
   * 
   * @param id   the id of an existing Customer 
   * @return the deleted Customer object if valid; {@literal null}, otherwise.
   */
  @RequestMapping (value = "/customer/id/{id}", method = RequestMethod.DELETE)
  public @ResponseBody Customer deleteById(@PathVariable Long id) {
    Optional<Customer> customer = repo.findById(id);
    if (customer.isPresent()) {
      repo.deleteById(id);
      return customer.get();
    }
    return null;
  }

  /**
   * Delete customer records if customer's name contains the given string
   * 
   * @param name   the part of an existing Customer's name 
   * @return the deleted Customer objects if any; empty list, otherwise.
   */
  @RequestMapping (value = "/customer/name/{name}", method = RequestMethod.DELETE)
  public @ResponseBody List<Customer> deleteByNameContains(@PathVariable String name) {
    List<Customer> products = repo.findAll()
        .stream()
        .filter(entry -> entry.getName().toLowerCase().contains(name.toLowerCase()))
        .collect(Collectors.toList());
    repo.deleteAllInBatch(products);
    return products;
  }

  /**
   * List customer records if customer's name contains the given string
   * 
   * @param name   the part of an existing Customer's name 
   * @return the found Customer objects if any; empty list, otherwise.
   */
  @RequestMapping ("/customer/findBy/name/{name}")
  public @ResponseBody List<Customer> findByNameContains(@PathVariable String name) {
    return repo.findAll()
        .stream()
        .filter(entry -> entry.getName().toLowerCase().contains(name.toLowerCase()))
        .collect(Collectors.toList());
  }
}
