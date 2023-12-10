package com.tobeto.spring.b.controller;

import com.tobeto.spring.b.dtos.request.address.AddAddressRequest;
import com.tobeto.spring.b.dtos.request.address.UpdateAddressRequest;
import com.tobeto.spring.b.dtos.response.address.GetAddressListResponse;
import com.tobeto.spring.b.dtos.response.address.GetAddressResponse;
import com.tobeto.spring.b.entities.Address;
import com.tobeto.spring.b.repositories.AddressRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/address")
public class AddressController
{
    private final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository)
    {
        this.addressRepository = addressRepository;
    }

    @GetMapping("{id}")
    public GetAddressResponse getById(@PathVariable int id)
    {
        GetAddressResponse dto = new GetAddressResponse();
        Address address = this.addressRepository.findById(id).orElseThrow();
        dto.setCity(address.getCity());
        dto.setTown(address.getTown());
        dto.setCountry(address.getCountry());
        return dto;
    }

    @GetMapping
    public GetAddressListResponse getByAll()
    {
        GetAddressListResponse dto = new GetAddressListResponse();
        dto.setAddresses(addressRepository.findAll());
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddAddressRequest addressRequest)
    {
        Address address = new Address();

        address.setCity(addressRequest.getCity());
        address.setCountry(addressRequest.getCountry());
        address.setTown(addressRequest.getTown());
        this.addressRepository.save(address);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        Address address = addressRepository.findById(id).orElseThrow();
        this.addressRepository.delete(address);
    }

    @PutMapping
    public void update(@RequestBody UpdateAddressRequest addressRequest)
    {
        Address addressToUpdate = addressRepository.findById(addressRequest.getId()).orElseThrow();
        addressToUpdate.setId(addressRequest.getId());
        addressToUpdate.setCity(addressRequest.getCity());
        addressToUpdate.setTown(addressRequest.getTown());
        addressToUpdate.setCountry(addressRequest.getCountry());
        addressToUpdate.setCustomer(addressRequest.getCustomer());
        addressRepository.save(addressToUpdate);
    }
}
