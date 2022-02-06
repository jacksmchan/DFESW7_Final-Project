package practical.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import practical.project.domain.Invoice;

/**
 * The interface of JPA repository defined for Invoice 
 *
 * @author jacksmchan
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
