package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.services.concretes.CustomersManager;
import com.tobeto.spring.b.services.dtos.request.customers.AddCustomersRequest;
import com.tobeto.spring.b.services.dtos.request.customers.UpdateCustomersRequest;
import com.tobeto.spring.b.services.dtos.response.customers.GetCustomersListResponse;
import com.tobeto.spring.b.services.dtos.response.customers.GetCustomersResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
@AllArgsConstructor
public class CustomersController
{
    private final CustomersManager customersManager;


    @GetMapping
    public List<GetCustomersListResponse> getByAll()
    {
        return customersManager.getByAll();
    }

    @GetMapping("{id}")
    public GetCustomersResponse getById(@PathVariable int id)
    {
        return customersManager.getById(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddCustomersRequest addCustomerRequest)
    {
        customersManager.add(addCustomerRequest);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateCustomersRequest customerRequest)
    {
        customersManager.update(customerRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        customersManager.delete(id);
    }
}