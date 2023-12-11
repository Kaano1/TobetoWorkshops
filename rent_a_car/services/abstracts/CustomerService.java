package com.tobeto.spring.b.services.abstracts;


import com.tobeto.spring.b.services.dtos.request.customer.AddCustomerRequest;
import com.tobeto.spring.b.services.dtos.request.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.services.dtos.response.customer.GetCustomerListResponse;
import com.tobeto.spring.b.services.dtos.response.customer.GetCustomerResponse;
import org.springframework.web.bind.annotation.*;


public interface CustomerService {
    GetCustomerListResponse getByAll();
    GetCustomerResponse getById(@PathVariable int id);
    void add(@RequestBody AddCustomerRequest addCustomerRequest);
    void update(@RequestBody UpdateCustomerRequest customerRequest);
    void delete(@PathVariable int id);
}
