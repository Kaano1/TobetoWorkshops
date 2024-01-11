package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Address;
import com.tobeto.spring.b.entities.Customers;
import com.tobeto.spring.b.repositories.AddressRepository;
import com.tobeto.spring.b.repositories.CustomersRepository;
import com.tobeto.spring.b.services.abstracts.AddressService;
import com.tobeto.spring.b.services.dtos.request.address.AddAddressRequest;
import com.tobeto.spring.b.services.dtos.request.address.UpdateAddressRequest;
import com.tobeto.spring.b.services.dtos.response.address.GetAddressListResponse;
import com.tobeto.spring.b.services.dtos.response.address.GetAddressResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class AddressManager implements AddressService {

    private final AddressRepository addressRepository;
    private final CustomersRepository customersRepository;

    @Override
    public void update(UpdateAddressRequest othAddress) {
        Address address = addressRepository.findById(othAddress.getId()).orElseThrow();
        List<Customers> customers = new ArrayList<>();

        address.setId(othAddress.getId());
        address.setCity(othAddress.getCity());
        address.setTown(othAddress.getCity());
        address.setCountry(othAddress.getCountry());
        othAddress
                .getCustomerId()
                .forEach(id -> customers.add(customersRepository.getById(id)));

        address.setCustomers(customers);

        addressRepository.save(address);
    }

    @Override
    public List<GetAddressListResponse> getAll() {
        List<Address> tmp = addressRepository.findAll();
        List<GetAddressListResponse> send = new ArrayList<>();

        for (Address data : tmp) {
            GetAddressListResponse getAddressResponse = new GetAddressListResponse();

            getAddressResponse.setId(data.getId());
            getAddressResponse.setCountry(data.getCountry());
            getAddressResponse.setCity(data.getCity());
            getAddressResponse.setTown(data.getTown());

            send.add(getAddressResponse);
        }
        return send;
    }

    @Override
    public GetAddressResponse getById(int id) {
        GetAddressResponse getAddressResponse = new GetAddressResponse();
        Address address = addressRepository.findById(id).orElseThrow();

        getAddressResponse.setCountry(address.getCountry());
        getAddressResponse.setCity(address.getCity());
        getAddressResponse.setTown(address.getTown());
        return getAddressResponse;
    }

    @Override
    public void add(AddAddressRequest addressRequest) {//look at other repository for address add function
        if (findSameAddress(addressRequest))
            throw new RuntimeException("The address is registered in the system, please try a different address.");
        Address address = new Address();
        List<Integer> customersIds = addressRequest.getCustomerId();

        address.setCountry(addressRequest.getCountry());
        address.setCity(addressRequest.getCity());
        address.setTown(addressRequest.getTown());
        address.setDetail(addressRequest.getDetail());
        if (!customersIds.isEmpty()) {
            List<Customers> customers = new ArrayList<>();
            addressRequest
                    .getCustomerId().
                    forEach((id) -> customers.add(customersRepository.getById(id)));
            address.setCustomers(customers);
        }

        addressRepository.save(address);
    }

    @Override
    public void delete(int id) {
        Address address = addressRepository.findById(id).orElseThrow();
        addressRepository.delete(address);
    }

    @Override
    public boolean findSameAddress(AddAddressRequest addressRequest)
    {
        List<Address> addressList = addressRepository.findAddressByCountryAndCityAndTown
                (addressRequest.getCountry(), addressRequest.getCity(),addressRequest.getTown());
        String detailSplit = addressRequest.getDetail().trim().replace(".,", "");

        addressList.forEach((address) -> address.setDetail(address.getDetail().trim().replace(".,", "")));

        for (Address address : addressList)
            if (address.getDetail().equals(detailSplit))
                return (true);
        return (false);
    }
}
