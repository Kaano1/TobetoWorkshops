package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.request.address.AddAddressRequest;
import com.tobeto.spring.b.services.dtos.request.address.UpdateAddressRequest;
import com.tobeto.spring.b.services.dtos.response.address.GetAddressListResponse;
import com.tobeto.spring.b.services.dtos.response.address.GetAddressResponse;

import java.util.List;

public interface AddressService {
    void add(AddAddressRequest addressRequest);
    void update(UpdateAddressRequest othAddress);
    void delete(int id);
    GetAddressResponse getById(int id);
    List<GetAddressListResponse> getAll();
    boolean findSameAddress(AddAddressRequest addressRequest);
}
