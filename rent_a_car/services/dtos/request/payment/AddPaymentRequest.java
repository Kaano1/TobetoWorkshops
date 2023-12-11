package com.tobeto.spring.b.services.dtos.request.payment;

import com.tobeto.spring.b.entities.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPaymentRequest {
    private String payMethod;
    private int amount;
    public int cardNumber;
    private Orders agreement;
}
