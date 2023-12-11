package com.tobeto.spring.b.controller;

import com.tobeto.spring.b.services.concretes.CustomerManager;
import com.tobeto.spring.b.services.dtos.request.customer.AddCustomerRequest;
import com.tobeto.spring.b.services.dtos.request.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.services.dtos.response.customer.GetCustomerListResponse;
import com.tobeto.spring.b.services.dtos.response.customer.GetCustomerResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customer")
public class CustomerController
{
    private final CustomerManager customerManager;

    public CustomerController(CustomerManager customerManager)
    {
        this.customerManager = customerManager;

    }

    @GetMapping
    public GetCustomerListResponse getByAll()
    {
        return customerManager.getByAll();
    }

    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id)
    {
        return customerManager.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddCustomerRequest addCustomerRequest)
    {
        customerManager.add(addCustomerRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateCustomerRequest customerRequest)
    {
        customerManager.update(customerRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        customerManager.delete(id);
    }
}
