package com.tobeto.spring.b.controller;

import com.tobeto.spring.b.entities.Orders;
import com.tobeto.spring.b.repositories.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Orders> getByAll()
    {
        return this.orderRepository.findAll();
    }

    @GetMapping("{id}")
    public Orders getById(@PathVariable int id)
    {
        return this.orderRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Orders order)
    {
        this.orderRepository.save(order);
    }

    @PutMapping
    public void update(@RequestBody Orders order)
    {
        order.setId(1);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        this.orderRepository.deleteById(id);
    }
}
