package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.services.concretes.OrdersManager;
import com.tobeto.spring.b.services.dtos.request.orders.AddOrdersRequest;
import com.tobeto.spring.b.services.dtos.request.orders.UpdateOrdersRequest;
import com.tobeto.spring.b.services.dtos.response.orders.GetOrdersListResponse;
import com.tobeto.spring.b.services.dtos.response.orders.GetOrdersResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
public class OrdersController {

    private final OrdersManager ordersManager;

    @GetMapping
    public List<GetOrdersListResponse> getByAll()
    {
        return ordersManager.getByAll();
    }

    @GetMapping("{id}")
    public GetOrdersResponse getById(@PathVariable int id)
    {
        return ordersManager.getById(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddOrdersRequest orderRequest)
    {
        ordersManager.add(orderRequest);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateOrdersRequest othOrder)
    {
        ordersManager.update(othOrder);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        ordersManager.delete(id);
    }
}
