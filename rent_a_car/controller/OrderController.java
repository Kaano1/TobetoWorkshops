package com.tobeto.spring.b.controller;

import com.tobeto.spring.b.services.concretes.OrderManager;
import com.tobeto.spring.b.services.dtos.request.order.AddOrderRequest;
import com.tobeto.spring.b.services.dtos.request.order.UpdateOrderRequest;
import com.tobeto.spring.b.services.dtos.response.order.GetOrderListResponse;
import com.tobeto.spring.b.services.dtos.response.order.GetOrderResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    private final OrderManager orderManager;

    public OrderController(OrderManager orderManager)
    {
        this.orderManager = orderManager;
    }

    @GetMapping
    public GetOrderListResponse getByAll()
    {
        return orderManager.getByAll();
    }

    @GetMapping("{id}")
    public GetOrderResponse getById(@PathVariable int id)
    {
        return orderManager.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddOrderRequest orderRequest)
    {
        orderManager.add(orderRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateOrderRequest orderRequest)
    {
        orderManager.update(orderRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        orderManager.delete(id);
    }
}
