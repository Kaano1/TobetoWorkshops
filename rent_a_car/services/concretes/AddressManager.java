package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Address;
import com.tobeto.spring.b.repositories.AddressRepository;
import com.tobeto.spring.b.services.abstracts.AddressService;
import com.tobeto.spring.b.services.dtos.request.address.AddAddressRequest;
import com.tobeto.spring.b.services.dtos.request.address.UpdateAddressRequest;
import com.tobeto.spring.b.services.dtos.response.address.GetAddressListResponse;
import com.tobeto.spring.b.services.dtos.response.address.GetAddressResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class AddressManager implements AddressService {
    private final AddressRepository addressRepository;
    public GetAddressResponse getById( int id)
    {
        GetAddressResponse dto = new GetAddressResponse();
        Address address = this.addressRepository.findById(id).orElseThrow();
        dto.setCity(address.getCity());
        dto.setTown(address.getTown());
        dto.setCountry(address.getCountry());
        return dto;
    }

    public GetAddressListResponse getByAll()
    {
        GetAddressListResponse dto = new GetAddressListResponse();
        dto.setAddresses(addressRepository.findAll());
        return dto;
    }

    public void add(AddAddressRequest addressRequest)
    {
        Address address = new Address();

        address.setCity(addressRequest.getCity());
        address.setCountry(addressRequest.getCountry());
        address.setTown(addressRequest.getTown());
        this.addressRepository.save(address);
    }

    public void delete(int id)
    {
        Address address = addressRepository.findById(id).orElseThrow();
        this.addressRepository.delete(address);
    }

    public void update(UpdateAddressRequest addressRequest)
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
