package com.tobeto.spring.b.dtos.request.order;

import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {
    private int amount;
    private Customer customers;
    private Car cars;
    private LocalDate orderDate;
}
