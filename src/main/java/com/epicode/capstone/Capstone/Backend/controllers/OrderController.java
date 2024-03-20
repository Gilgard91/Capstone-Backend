package com.epicode.capstone.Capstone.Backend.controllers;

import com.epicode.capstone.Capstone.Backend.entities.Order;
import com.epicode.capstone.Capstone.Backend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getOrders(){
        return this.orderService.getOrders();
    }

    @GetMapping("/findByEmail")
    public List<Order> findByCustomerEmail(@RequestParam String email){
        return this.orderService.findByEmail(email);
    }

    @PutMapping("/{id}")
    public Order updateOrderStatus(@PathVariable Long id, @RequestBody Order updatedOrder){
        return this.orderService.findByIdAndUpdate(id, updatedOrder);
    }
}
