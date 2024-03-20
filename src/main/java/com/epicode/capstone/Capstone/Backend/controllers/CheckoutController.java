package com.epicode.capstone.Capstone.Backend.controllers;

import com.epicode.capstone.Capstone.Backend.dto.PurchaseDTO;
import com.epicode.capstone.Capstone.Backend.dto.PurchaseResponseDTO;
import com.epicode.capstone.Capstone.Backend.entities.Customer;
import com.epicode.capstone.Capstone.Backend.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return this.checkoutService.getAllOrders();
    }

    @PostMapping("/purchase")
    @ResponseStatus(HttpStatus.CREATED)
    public PurchaseResponseDTO placeOrder(@RequestBody PurchaseDTO purchase){
        return this.checkoutService.placeOrder(purchase);
    }
}
