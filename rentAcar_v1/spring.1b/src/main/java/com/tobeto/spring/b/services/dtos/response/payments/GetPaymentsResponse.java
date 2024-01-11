package com.tobeto.spring.b.services.dtos.response.payments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPaymentsResponse {
    private String paymentMethod;
    private int limit;
    private String cardNumber;
}
