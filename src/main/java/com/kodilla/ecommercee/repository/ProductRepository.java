package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    List<Product> findAll();
    @Override
    Product save(Product product);
    Optional<Product> findById(Long id);
    Optional<Product> findByDescription(String description);

}
