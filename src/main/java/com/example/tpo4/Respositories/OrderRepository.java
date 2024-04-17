package com.example.tpo4.Respositories;

import com.example.tpo4.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
