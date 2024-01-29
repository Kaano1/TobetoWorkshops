package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilites.mappers.ModelMapperService;
import com.tobeto.rentacar.entities.Customer;
import com.tobeto.rentacar.repository.CustomerRepository;
import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.dtos.request.Customer.AddCustomerRequest;
import com.tobeto.rentacar.services.dtos.request.Customer.UpdateCustomerRequest;
import com.tobeto.rentacar.services.dtos.response.Customer.GetCustomerListResponse;
import com.tobeto.rentacar.services.dtos.response.Customer.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetCustomerListResponse> getAll()
    {
        List<Customer> customers = customerRepository.findAll();
        return (customers.stream()
                .map(customer -> this.modelMapperService.forResponse()
                        .map(customer, GetCustomerListResponse.class))
                .collect(Collectors.toList()));
    }

    @Override
    public GetCustomerResponse getById(int id)
    {
        Customer customer = customerRepository.findById(id).orElseThrow();
        return modelMapperService.
                forResponse().map(customer, GetCustomerResponse.class);
    }
    @Override
    public void    add(AddCustomerRequest addCustomerRequest)
    {
        Customer customer = modelMapperService.forRequest().map(addCustomerRequest, Customer.class);
        customerRepository.save(customer);
    }
    @Override
    public void    update(UpdateCustomerRequest updateCustomerRequest)
    {
        Customer customer = modelMapperService.forRequest().
                map(updateCustomerRequest, Customer.class);
        customerRepository.save(customer);
    }
    @Override
    public void     delete(int id)
    {
        Customer customer = customerRepository.findById(id).orElseThrow();

        customerRepository.delete(customer);
    }
}
