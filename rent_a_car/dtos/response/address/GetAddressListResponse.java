package com.tobeto.spring.b.dtos.response.address;

import com.tobeto.spring.b.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAddressListResponse {
    private List<Address> addresses;
}
