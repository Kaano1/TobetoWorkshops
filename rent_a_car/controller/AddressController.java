package com.tobeto.spring.b.controller;

import com.tobeto.spring.b.services.concretes.AddressManager;
import com.tobeto.spring.b.services.dtos.request.address.AddAddressRequest;
import com.tobeto.spring.b.services.dtos.request.address.UpdateAddressRequest;
import com.tobeto.spring.b.services.dtos.response.address.GetAddressListResponse;
import com.tobeto.spring.b.services.dtos.response.address.GetAddressResponse;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/address")
public class AddressController
{
    private final AddressManager addressManager;

    public AddressController(AddressManager address)
    {
        this.addressManager = address;
    }

    @GetMapping("{id}")
    public GetAddressResponse getById(@PathVariable int id)
    {
        return addressManager.getById(id);
    }

    @GetMapping
    public GetAddressListResponse getByAll()
    {
        return addressManager.getByAll();
    }

    @PostMapping
    public void add(@RequestBody AddAddressRequest addressRequest)
    {
        addressManager.add(addressRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        addressManager.delete(id);
    }

    @PutMapping
    public void update(@RequestBody UpdateAddressRequest addressRequest)
    {
        addressManager.update(addressRequest);
    }
}
