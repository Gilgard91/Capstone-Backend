package com.epicode.capstone.Capstone.Backend.dto;

import com.epicode.capstone.Capstone.Backend.entities.Address;
import com.epicode.capstone.Capstone.Backend.entities.Customer;
import com.epicode.capstone.Capstone.Backend.entities.Order;
import com.epicode.capstone.Capstone.Backend.entities.OrderItem;

import java.util.List;

public record PurchaseDTO(Customer customer, Address shippingAddress, Address billingAddress,
                          Order order, List<OrderItem> orderItems) {
}
