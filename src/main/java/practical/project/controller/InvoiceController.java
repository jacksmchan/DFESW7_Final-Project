package practical.project.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import practical.project.domain.Invoice;
import practical.project.repository.InvoiceRepository;

/**
 * The web controller used to expose RESTful APIs related with invoices 
 *
 * <ul>
 * <li>GET /invoices: used to list all registered invoices</li>
 * <li>GET /invoice/id/{id}: used to find an existing invoice record by its id</li>
 * <li>POST /invoice: used to add a new invoice</li>
 * <li>PUT /invoice: used to update an existing invoice</li>
 * <li>DELETE /invoice/id/{id}: used to delete an existing invoice record by its id</li>
 * </ul>
 *
 * @author jacksmchan
 * @see org.springframework.stereotype.Controller
 * @see practical.project.domain.Invoice
 * @see practical.project.repository.InvoiceRepository
 */
@Controller
public class InvoiceController {
  @Autowired
  private InvoiceRepository repo;

  /**
   * List all registered invoices
   * 
   * @return a list all invoices available
   */
  @RequestMapping (value = "/invoices", produces = {
      MediaType.APPLICATION_JSON_VALUE
  })
  public @ResponseBody List<Invoice> getInvoices() {
    return repo.findAll();
  }

  /**
   * Add a new invoice
   * 
   * @param entry   the Invoice object to be added and must not be {@literal null}.
   * @return the added Invoice object; will never be {@literal null}.
   */
  @RequestMapping (value = "/invoice", method = RequestMethod.POST, produces = {
      MediaType.APPLICATION_JSON_VALUE
  })
  public @ResponseBody Invoice add(@RequestBody Invoice entry) {
    Date time = Calendar.getInstance().getTime();
    entry.setCreated(time);
    entry.setUpdated(time);
    return repo.save(entry);
  }

  /**
   * Update an existing invoice
   * 
   * @param entry   the Invoice object to be updated and must not be {@literal null}.
   * @return the updated Invoice object if valid; {@literal null}, otherwise.
   */
  @RequestMapping (value = "/invoice", method = RequestMethod.PUT)
  public @ResponseBody Invoice update(@RequestBody Invoice entry) {
    Optional<Invoice> invoice = repo.findById(entry.getId());
    if (invoice.isPresent()) {
      entry.setCreated(invoice.get().getCreated());
      Date time = Calendar.getInstance().getTime();
      entry.setUpdated(time);
      return repo.save(entry);
    }
    return null;
  }

  /**
   * Delete an existing invoice record by its id
   * 
   * @param id   the id of an existing Invoice 
   * @return the deleted Invoice object if valid; {@literal null}, otherwise.
   */
  @RequestMapping (value = "/invoice/id/{id}", method = RequestMethod.DELETE)
  public @ResponseBody Invoice deleteById(@PathVariable Long id) {
    Optional<Invoice> invoice = repo.findById(id);
    if (invoice.isPresent()) {
      repo.deleteById(id);
      return invoice.get();
    }
    return null;
  }

  /**
   * Find an existing invoice record by its id
   * 
   * @param id   the id of an existing Invoice 
   * @return the deleted Invoice object if valid; {@literal null}, otherwise.
   */
  @RequestMapping ("/invoice/findBy/id/{id}")
  public @ResponseBody Invoice findById(@PathVariable Long id) {
    Optional<Invoice> invoice = repo.findById(id);
    if (invoice.isPresent()) {
      return invoice.get();
    }
    return null;
  }
}
