package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Customer;
import com.tobeto.spring.b.repositories.CustomerRepository;
import com.tobeto.spring.b.services.dtos.request.customer.AddCustomerRequest;
import com.tobeto.spring.b.services.dtos.request.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.services.dtos.response.customer.GetCustomerListResponse;
import com.tobeto.spring.b.services.dtos.response.customer.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerManager {
    private final CustomerRepository customerRepository;

    public GetCustomerListResponse getByAll()
    {
        GetCustomerListResponse getCustomerListResponse = new GetCustomerListResponse();
        getCustomerListResponse.setCustomers(this.customerRepository.findAll());
        return getCustomerListResponse;
    }

    public GetCustomerResponse getById(int id)
    {
        GetCustomerResponse getCustomerResponse = new GetCustomerResponse();
        Customer customer = this.customerRepository.findById(id).orElseThrow();
        getCustomerResponse.setGmail(customer.getGmail());
        getCustomerResponse.setName(customer.getName());
        getCustomerResponse.setSurname(customer.getSurname());
        getCustomerResponse.setPhoneNumber(customer.getPhoneNumber());
        return getCustomerResponse;
    }

    public void add(AddCustomerRequest addCustomerRequest)
    {
        Customer add = new Customer();
        add.setName(addCustomerRequest.getName());
        add.setGmail(addCustomerRequest.getGmail());
        add.setSurname(addCustomerRequest.getSurname());
        add.setPhoneNumber(addCustomerRequest.getPhoneNumber());
        add.setAddresss(addCustomerRequest.getAddresss());
        this.customerRepository.save(add);
    }

    public void update( UpdateCustomerRequest customerRequest)
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

    public void delete(int id)
    {
        this.customerRepository.deleteById(id);
    }
}
