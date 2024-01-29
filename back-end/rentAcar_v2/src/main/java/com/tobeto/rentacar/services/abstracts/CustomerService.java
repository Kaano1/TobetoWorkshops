package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.request.Customer.AddCustomerRequest;
import com.tobeto.rentacar.services.dtos.request.Customer.UpdateCustomerRequest;
import com.tobeto.rentacar.services.dtos.response.Customer.GetCustomerListResponse;
import com.tobeto.rentacar.services.dtos.response.Customer.GetCustomerResponse;

import java.util.List;

public interface CustomerService {
     List<GetCustomerListResponse> getAll();
     GetCustomerResponse getById(int id);
     void    add(AddCustomerRequest addCustomerRequest);
     void    update(UpdateCustomerRequest updateCustomerRequest);
     void     delete(int id);
}
