package com.tobeto.spring.b.controller;

import com.tobeto.spring.b.dtos.request.order.AddOrderRequest;
import com.tobeto.spring.b.dtos.request.order.UpdateOrderRequest;
import com.tobeto.spring.b.dtos.response.order.GetOrderListResponse;
import com.tobeto.spring.b.dtos.response.order.GetOrderResponse;
import com.tobeto.spring.b.entities.Orders;
import com.tobeto.spring.b.repositories.OrderRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public GetOrderListResponse getByAll()
    {
        GetOrderListResponse getOrderListResponse = new GetOrderListResponse();
        getOrderListResponse.setOrders(this.orderRepository.findAll());
        return getOrderListResponse;
    }

    @GetMapping("{id}")
    public GetOrderResponse getById(@PathVariable int id)
    {
        GetOrderResponse getOrderResponse = new GetOrderResponse();
        Orders orders = this.orderRepository.findById(id).orElseThrow();
        getOrderResponse.setAmount(orders.getAmount());
        return getOrderResponse;
    }

    @PostMapping
    public void add(@RequestBody AddOrderRequest orderRequest)
    {
        Orders order = new Orders();
        order.setAmount(orderRequest.getAmount());
        order.setCustomers(orderRequest.getCustomers());
        order.setCars(orderRequest.getCars());
        order.setOrderDate(orderRequest.getOrderDate());
        this.orderRepository.save(order);
    }

    @PutMapping
    public void update(@RequestBody UpdateOrderRequest orderRequest)
    {
        Orders ordersToUpdate = orderRepository.findById(orderRequest.getId()).orElseThrow();
        ordersToUpdate.setId(orderRequest.getId());
        ordersToUpdate.setAmount(orderRequest.getAmount());
        ordersToUpdate.setCars(orderRequest.getCars());
        ordersToUpdate.setCustomers(orderRequest.getCustomers());
        ordersToUpdate.setCustomers(orderRequest.getCustomers());
        ordersToUpdate.setCars(orderRequest.getCars());
        ordersToUpdate.setOrderDate(orderRequest.getOrderDate());
        orderRepository.save(ordersToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        this.orderRepository.deleteById(id);
    }
}
