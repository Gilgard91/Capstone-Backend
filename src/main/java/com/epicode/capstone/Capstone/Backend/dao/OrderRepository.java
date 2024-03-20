package com.epicode.capstone.Capstone.Backend.dao;

import com.epicode.capstone.Capstone.Backend.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerEmail(String email);
}
