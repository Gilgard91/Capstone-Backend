package com.epicode.capstone.Capstone.Backend.services;

import com.epicode.capstone.Capstone.Backend.dao.OrderRepository;
import com.epicode.capstone.Capstone.Backend.entities.Order;
import com.epicode.capstone.Capstone.Backend.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order findById(Long id){
        return this.orderRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }
    public List<Order> findByEmail(String email){
        return orderRepository.findByCustomerEmail(email);
    }
    public List<Order> getOrders(){
        return this.orderRepository.findAll();
    }
    public Order findByIdAndUpdate(Long id, Order updatedOrder){
        Order order = findById(id);
        order.setStatus(updatedOrder.getStatus());
        return this.orderRepository.save(order);
    }
}
