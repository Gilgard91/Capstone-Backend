package com.epicode.capstone.Capstone.Backend.services;

import com.epicode.capstone.Capstone.Backend.dao.CustomerRepository;
import com.epicode.capstone.Capstone.Backend.dao.OrderRepository;
import com.epicode.capstone.Capstone.Backend.dto.PurchaseDTO;
import com.epicode.capstone.Capstone.Backend.dto.PurchaseResponseDTO;
import com.epicode.capstone.Capstone.Backend.entities.Customer;
import com.epicode.capstone.Capstone.Backend.entities.Order;
import com.epicode.capstone.Capstone.Backend.entities.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CheckoutService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;

    public PurchaseResponseDTO placeOrder(PurchaseDTO purchase){
        Order order = purchase.order();

        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        List<OrderItem> orderItems = purchase.orderItems();
        order.addItems(orderItems);

        order.setBillingAddress(purchase.billingAddress());
        order.setShippingAddress(purchase.shippingAddress());

        Customer customer = purchase.customer();

        String email = customer.getEmail();
        Customer dbCustomer = customerRepository.findByEmail(email);
        if(dbCustomer != null){
            customer = dbCustomer;
        }

        customer.add(order);

        customerRepository.save(customer);

        return new PurchaseResponseDTO(orderTrackingNumber);
    }
    public List<Customer> getAllOrders(){
        return this.customerRepository.findAll();
    }
    private String generateOrderTrackingNumber(){
        return UUID.randomUUID().toString();
    }


}
