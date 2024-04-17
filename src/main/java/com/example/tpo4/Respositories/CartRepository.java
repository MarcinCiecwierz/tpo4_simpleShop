package com.example.tpo4.Respositories;

import com.example.tpo4.Models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem, Long> {
}
