package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Address;
import com.tobeto.spring.b.entities.Customers;
import com.tobeto.spring.b.repositories.AddressRepository;
import com.tobeto.spring.b.repositories.CustomersRepository;
import com.tobeto.spring.b.services.abstracts.CustomersService;
import com.tobeto.spring.b.services.dtos.request.customers.AddCustomersRequest;
import com.tobeto.spring.b.services.dtos.request.customers.UpdateCustomersRequest;
import com.tobeto.spring.b.services.dtos.response.customers.GetCustomersListResponse;
import com.tobeto.spring.b.services.dtos.response.customers.GetCustomersResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomersManager implements CustomersService
{
    private final CustomersRepository customerRepository;
    private final AddressRepository addressRepository;

    public List<GetCustomersListResponse> getByAll()
    {
        List<Customers> customers = customerRepository.findAll();
        List<GetCustomersListResponse> getBrandListResponses = new ArrayList<>();

        for (Customers custom : customers)
        {
            GetCustomersListResponse customer = new GetCustomersListResponse();

            customer.setId(custom.getId());
            customer.setName(custom.getName());

            getBrandListResponses.add(customer);
        }

        return getBrandListResponses;
    }

    public GetCustomersResponse getById(int id)
    {
        GetCustomersResponse getCustomerResponse = new GetCustomersResponse();
        Customers customer = this.customerRepository.findById(id).orElseThrow();
        getCustomerResponse.setGmail(customer.getGmail());
        getCustomerResponse.setName(customer.getName());
        getCustomerResponse.setSurname(customer.getSurname());
        return getCustomerResponse;
    }

    public void add(AddCustomersRequest addCustomerRequest)
    {
        List<Customers> customersList = customerRepository.findCustomersByNameAndSurnameOrPhoneOrGmail(addCustomerRequest.getName(), addCustomerRequest.getSurname(), addCustomerRequest.getPhone(), addCustomerRequest.getGmail());

        if (!customersList.isEmpty())
            throw new RuntimeException("Customer must not same");

        Customers add = new Customers();
        add.setName(addCustomerRequest.getName());
        add.setGmail(addCustomerRequest.getGmail());
        add.setSurname(addCustomerRequest.getSurname());
        add.setPhone(addCustomerRequest.getPhone());
        if (add.getId() != -1)
        {
            Address address = addressRepository.findById(add.getId()).orElseThrow();

            add.setAddress(address);
        }
        this.customerRepository.save(add);
    }

    public void update( UpdateCustomersRequest customerRequest)
    {
        Customers customerToUpdate = customerRepository.findById(customerRequest.getId()).orElseThrow();
        customerToUpdate.setId(customerRequest.getId());
        customerToUpdate.setName(customerRequest.getName());
        customerToUpdate.setGmail(customerRequest.getGmail());
        customerToUpdate.setSurname(customerRequest.getSurname());
        customerToUpdate.setAddress
                (addressRepository.findById(customerRequest.getAddressId()).orElseThrow());
        customerRepository.save(customerToUpdate);
    }

    public void delete( int id)
    {
        this.customerRepository.deleteById(id);
    }
}
