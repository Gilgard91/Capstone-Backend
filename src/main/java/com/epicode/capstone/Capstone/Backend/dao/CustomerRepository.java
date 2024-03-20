package com.epicode.capstone.Capstone.Backend.dao;

import com.epicode.capstone.Capstone.Backend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Customer findByEmail(String email);
}
