package com.tobeto.spring.b.controller;

import com.tobeto.spring.b.dtos.request.customer.AddCustomerRequest;
import com.tobeto.spring.b.dtos.request.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.dtos.response.customer.GetCustomerListResponse;
import com.tobeto.spring.b.dtos.response.customer.GetCustomerResponse;
import com.tobeto.spring.b.entities.Customer;
import com.tobeto.spring.b.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

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
    public GetCustomerListResponse getByAll()
    {
        GetCustomerListResponse getCustomerListResponse = new GetCustomerListResponse();
        getCustomerListResponse.setCustomers(this.customerRepository.findAll());
        return getCustomerListResponse;
    }

    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id)
    {
        GetCustomerResponse getCustomerResponse = new GetCustomerResponse();
        Customer customer = this.customerRepository.findById(id).orElseThrow();
        getCustomerResponse.setGmail(customer.getGmail());
        getCustomerResponse.setName(customer.getName());
        getCustomerResponse.setSurname(customer.getSurname());
        getCustomerResponse.setPhoneNumber(customer.getPhoneNumber());
        return getCustomerResponse;
    }

    @PostMapping
    public void add(@RequestBody AddCustomerRequest addCustomerRequest)
    {
        Customer add = new Customer();
        add.setName(addCustomerRequest.getName());
        add.setGmail(addCustomerRequest.getGmail());
        add.setSurname(addCustomerRequest.getSurname());
        add.setPhoneNumber(addCustomerRequest.getPhoneNumber());
        add.setAddresss(addCustomerRequest.getAddresss());
        this.customerRepository.save(add);
    }

    @PutMapping
    public void update(@RequestBody UpdateCustomerRequest customerRequest)
    {
        Customer customerToUpdate = customerRepository.findById(customerRequest.getId()).orElseThrow();
        customerToUpdate.setId(customerRequest.getId());
        customerToUpdate.setName(customerRequest.getName());
        customerToUpdate.setGmail(customerRequest.getGmail());
        customerToUpdate.setSurname(customerRequest.getSurname());
        customerToUpdate.setPhoneNumber(customerRequest.getPhoneNumber());
        customerToUpdate.setAddresss(customerRequest.getAddresss());
        customerRepository.save(customerToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        this.customerRepository.deleteById(id);
    }
}
