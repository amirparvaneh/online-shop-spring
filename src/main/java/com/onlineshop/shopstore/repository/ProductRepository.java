package com.onlineshop.shopstore.repository;

import com.onlineshop.shopstore.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
