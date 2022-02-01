package practical.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import practical.project.domain.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
