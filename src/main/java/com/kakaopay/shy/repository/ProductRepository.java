package com.kakaopay.shy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kakaopay.shy.model.Product;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByStartedAtLessThanAndFinishedAtGreaterThan(LocalDateTime now1, LocalDateTime now2);
    Product save(Product p);
}
