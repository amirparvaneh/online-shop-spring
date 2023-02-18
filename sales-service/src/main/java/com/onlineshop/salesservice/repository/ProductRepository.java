package com.onlineshop.salesservice.repository;

import com.onlineshop.salesservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
