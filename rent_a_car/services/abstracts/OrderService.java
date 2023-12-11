package com.tobeto.spring.b.services.abstracts;


import com.tobeto.spring.b.services.dtos.request.order.AddOrderRequest;
import com.tobeto.spring.b.services.dtos.request.order.UpdateOrderRequest;
import com.tobeto.spring.b.services.dtos.response.order.GetOrderListResponse;
import com.tobeto.spring.b.services.dtos.response.order.GetOrderResponse;

public interface OrderService {
    GetOrderListResponse getByAll();
    GetOrderResponse getById(int id);
    void add(AddOrderRequest orderRequest);
    void update(UpdateOrderRequest orderRequest);
    void delete(int id);
}
