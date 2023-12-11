package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.request.address.AddAddressRequest;
import com.tobeto.spring.b.services.dtos.request.address.UpdateAddressRequest;
import com.tobeto.spring.b.services.dtos.response.address.GetAddressListResponse;
import com.tobeto.spring.b.services.dtos.response.address.GetAddressResponse;
import org.springframework.web.bind.annotation.*;

public interface AddressService {
    GetAddressResponse getById(int id);
    GetAddressListResponse getByAll();
    void add(@RequestBody AddAddressRequest addressRequest);
    void delete(@PathVariable int id);
    void update(@RequestBody UpdateAddressRequest addressRequest);
}
