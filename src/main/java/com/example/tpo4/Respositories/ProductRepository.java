package com.example.tpo4.Respositories;

import com.example.tpo4.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
