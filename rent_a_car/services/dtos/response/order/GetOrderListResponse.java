package com.tobeto.spring.b.services.dtos.response.order;

import com.tobeto.spring.b.entities.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderListResponse {
    private List<Orders> orders;
}
