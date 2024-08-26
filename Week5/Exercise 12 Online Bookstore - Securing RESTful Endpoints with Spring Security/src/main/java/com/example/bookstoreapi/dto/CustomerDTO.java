package com.example.bookstoreapi.dto;

import org.springframework.hateoas.RepresentationModel;

public class CustomerDTO extends RepresentationModel<CustomerDTO> {
    private Long id;
    private String name;
    private String email;
    private String address;
    // Getters and Setters
}
