package practical.project.web;

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

@Controller
public class InvoiceController {
  @Autowired
  InvoiceRepository repo;

  @RequestMapping (value = "/invoices", produces = {
      MediaType.APPLICATION_JSON_VALUE
  })
  public @ResponseBody List<Invoice> getCustomers() {
    return repo.findAll();
  }

  @RequestMapping (value = "/invoice", method = RequestMethod.POST, produces = {
      MediaType.APPLICATION_JSON_VALUE
  })
  public @ResponseBody Invoice add(@RequestBody Invoice entry) {
    Date time = Calendar.getInstance().getTime();
    entry.setCreated(time);
    entry.setUpdated(time);
    repo.save(entry);
    return entry;
  }

  @RequestMapping (value = "/invoice", method = RequestMethod.PUT)
  public @ResponseBody Invoice update(@RequestBody Invoice entry) {
    Optional<Invoice> invoice = repo.findById(entry.getId());
    if (invoice.isPresent()) {
      entry.setCreated(invoice.get().getCreated());
      Date time = Calendar.getInstance().getTime();
      entry.setUpdated(time);
      repo.save(entry);
      return entry;
    }
    return null;
  }

  @RequestMapping (value = "/invoice/id/{id}", method = RequestMethod.DELETE)
  public @ResponseBody Invoice deleteById(@PathVariable Long id) {
    Optional<Invoice> invoice = repo.findById(id);
    if (invoice.isPresent()) {
      repo.deleteById(id);
      return invoice.get();
    }
    return null;
  }

  @RequestMapping ("/invoice/findBy/id/{id}")
  public @ResponseBody Invoice findById(@PathVariable Long id) {
    Optional<Invoice> invoice = repo.findById(id);
    if (invoice.isPresent()) {
      return invoice.get();
    }
    return null;
  }
}
