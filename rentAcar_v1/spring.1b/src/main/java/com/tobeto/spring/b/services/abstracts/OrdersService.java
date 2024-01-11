package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.request.orders.AddOrdersRequest;
import com.tobeto.spring.b.services.dtos.request.orders.UpdateOrdersRequest;
import com.tobeto.spring.b.services.dtos.response.orders.GetOrdersListResponse;
import com.tobeto.spring.b.services.dtos.response.orders.GetOrdersResponse;

import java.util.List;

public interface OrdersService {
    List<GetOrdersListResponse> getByAll();
    GetOrdersResponse getById(int id);
    void add(AddOrdersRequest orderRequest);
    void update(UpdateOrdersRequest othOrder);
    void delete( int id);
}
