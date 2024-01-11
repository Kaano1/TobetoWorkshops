package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.services.concretes.AddressManager;
import com.tobeto.spring.b.services.dtos.request.address.AddAddressRequest;
import com.tobeto.spring.b.services.dtos.request.address.UpdateAddressRequest;
import com.tobeto.spring.b.services.dtos.response.address.GetAddressListResponse;
import com.tobeto.spring.b.services.dtos.response.address.GetAddressResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/addresss")
public class AddressController {

    private final AddressManager addressManager;

    @Autowired
    public AddressController(AddressManager address)
    {
        this.addressManager = address;
    }


    @GetMapping
    public List<GetAddressListResponse> getAll()
    {
        return addressManager.getAll();
    }

    @GetMapping("{id}")
    public GetAddressResponse getById(@PathVariable int id)
    {
        return addressManager.getById(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddAddressRequest addressRequest)
    {
        addressManager.add(addressRequest);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateAddressRequest othAddress)
    {
        addressManager.update(othAddress);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        addressManager.delete(id);
    }
}
