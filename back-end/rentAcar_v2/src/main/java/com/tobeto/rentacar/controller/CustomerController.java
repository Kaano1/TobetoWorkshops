package com.tobeto.rentacar.controller;

import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.dtos.request.Customer.AddCustomerRequest;
import com.tobeto.rentacar.services.dtos.request.Customer.UpdateCustomerRequest;
import com.tobeto.rentacar.services.dtos.response.Customer.GetCustomerListResponse;
import com.tobeto.rentacar.services.dtos.response.Customer.GetCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("getAll")
    List<GetCustomerListResponse> getAll()
    {
        return customerService.getAll();
    }

    @GetMapping("getById/{id}")
    GetCustomerResponse getById(@PathVariable int id)
    {
        return customerService.getById(id);
    }

    @PostMapping
    void    add(@RequestBody @Valid AddCustomerRequest addCustomerRequest)
    {
        customerService.add(addCustomerRequest);
    }

    @PutMapping
    void    update(@RequestBody @Valid UpdateCustomerRequest updateCustomerRequest) { customerService.update(updateCustomerRequest); }

    @DeleteMapping("delete/{id}")
    void    delete(@PathVariable int id)
    {
        customerService.delete(id);
    }
}
