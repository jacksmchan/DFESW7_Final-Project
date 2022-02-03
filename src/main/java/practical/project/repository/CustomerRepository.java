package practical.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import practical.project.domain.Customer;

/**
 * The interface of JPA repository defined for Customer 
 *
 * @author jacksmchan
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
