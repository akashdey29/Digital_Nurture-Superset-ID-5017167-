
package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.dto.CustomerDTO;
import com.example.bookstoreapi.exception.ResourceNotFoundException;
import com.example.bookstoreapi.mapper.DTOMapper;
import com.example.bookstoreapi.model.Customer;
import com.example.bookstoreapi.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final DTOMapper dtoMapper;

    public CustomerController(CustomerRepository customerRepository, DTOMapper dtoMapper) {
        this.customerRepository = customerRepository;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(dtoMapper::toCustomerDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with ID " + id + " not found"));
        return dtoMapper.toCustomerDTO(customer);
    }

    @PostMapping
    public CustomerDTO addCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        Customer customer = dtoMapper.toCustomerEntity(customerDTO);
        customer = customerRepository.save(customer);
        return dtoMapper.toCustomerDTO(customer);
    }

    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerDTO customerDTO) {
        if (!customerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Customer with ID " + id + " not found");
        }
        Customer customer = dtoMapper.toCustomerEntity(customerDTO);
        customer.setId(id);
        customer = customerRepository.save(customer);
        return dtoMapper.toCustomerDTO(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        if (!customerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Customer with ID " + id + " not found");
        }
        customerRepository.deleteById(id);
    }
}
