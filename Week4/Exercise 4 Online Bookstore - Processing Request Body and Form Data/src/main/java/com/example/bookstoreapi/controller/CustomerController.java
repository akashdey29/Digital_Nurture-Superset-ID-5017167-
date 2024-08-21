package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customer;
    }

    @PostMapping("/register")
    public String registerCustomer(@RequestParam String name, @RequestParam String email) {
        return "Customer registered with Name: " + name + " and Email: " + email;
    }

}
