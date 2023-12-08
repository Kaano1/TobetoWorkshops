package com.tobeto.spring.b.controller;

import com.tobeto.spring.b.entities.Customer;
import com.tobeto.spring.b.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController
{
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getByAll()
    {
        return this.customerRepository.findAll();
    }

    @GetMapping("{id}")
    public Customer getById(@PathVariable int id)
    {
        return this.customerRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Customer customer)
    {
        this.customerRepository.save(customer);
    }

    @PutMapping
    public void update(@RequestBody Customer customer)
    {
        customer.setId(1);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        this.customerRepository.deleteById(id);
    }
}
