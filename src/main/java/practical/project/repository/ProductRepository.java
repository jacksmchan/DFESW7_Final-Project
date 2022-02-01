package practical.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import practical.project.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
