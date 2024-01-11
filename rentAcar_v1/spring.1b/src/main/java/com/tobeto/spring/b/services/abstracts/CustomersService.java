package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.request.customers.AddCustomersRequest;
import com.tobeto.spring.b.services.dtos.request.customers.UpdateCustomersRequest;
import com.tobeto.spring.b.services.dtos.response.customers.GetCustomersListResponse;
import com.tobeto.spring.b.services.dtos.response.customers.GetCustomersResponse;

import java.util.List;

public interface CustomersService {
    List<GetCustomersListResponse> getByAll();
    GetCustomersResponse getById(int id);
    void add(AddCustomersRequest addCustomerRequest);
    void update( UpdateCustomersRequest customerRequest);
    void delete( int id);
}
