package com.tobeto.spring.b.services.dtos.request.customer;

import com.tobeto.spring.b.entities.Address;
import com.tobeto.spring.b.entities.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCustomerRequest {
    private int id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String gmail;
    private Address addresss;
    private List<Orders> orders;
}
