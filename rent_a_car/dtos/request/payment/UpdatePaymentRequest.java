package com.tobeto.spring.b.dtos.request.payment;

import com.tobeto.spring.b.entities.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatePaymentRequest {
    private int id;
    private String payMethod;
    private int amount;
    private int cardNumber;
    private Orders agreement;
}
