package com.tobeto.spring.b.services.dtos.response.order;

import com.tobeto.spring.b.entities.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderResponse {
    private int amount;
}
