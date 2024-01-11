package com.tobeto.spring.b.services.dtos.response.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrdersListResponse {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private int amount;
}
