package practical.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import practical.project.domain.Product;

/**
 * The interface of JPA repository defined for Product 
 *
 * @author jacksmchan
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
