package practical.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import practical.project.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
