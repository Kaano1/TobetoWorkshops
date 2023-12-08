package com.tobeto.spring.b.controller;

import com.tobeto.spring.b.entities.Address;
import com.tobeto.spring.b.repositories.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Address getById(@PathVariable int id)
    {
        return ( this.addressRepository.findById(id).orElseThrow() );
    }

    @GetMapping
    public List<Address> getByAll()
    {
        return ( this.addressRepository.findAll() );
    }

    @PostMapping
    public void add(@RequestBody Address address)
    {
        this.addressRepository.save(address);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        Address address = addressRepository.findById(id).orElseThrow();
        this.addressRepository.delete(address);
    }

    @PutMapping
    public void update(@RequestBody Address address)
    {
        address.setId(1);
    }
}
