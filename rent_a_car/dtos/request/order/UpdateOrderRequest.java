package com.tobeto.spring.b.dtos.request.order;

import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateOrderRequest {
    private int id;
    private int amount;
    private Customer customers;
    private Car cars;
    private LocalDate orderDate;
}
