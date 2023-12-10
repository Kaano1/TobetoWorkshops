package com.tobeto.spring.b.dtos.response.payment;

import com.tobeto.spring.b.entities.Payments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPaymentListResponse {
    private List<Payments> payments;
}
