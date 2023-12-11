package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Orders;
import com.tobeto.spring.b.repositories.OrderRepository;
import com.tobeto.spring.b.services.abstracts.OrderService;
import com.tobeto.spring.b.services.dtos.request.order.AddOrderRequest;
import com.tobeto.spring.b.services.dtos.request.order.UpdateOrderRequest;
import com.tobeto.spring.b.services.dtos.response.order.GetOrderListResponse;
import com.tobeto.spring.b.services.dtos.response.order.GetOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Service
public class OrderManager implements OrderService
{
    private final OrderRepository orderRepository;

    public GetOrderListResponse getByAll()
    {
        GetOrderListResponse getOrderListResponse = new GetOrderListResponse();
        getOrderListResponse.setOrders(this.orderRepository.findAll());
        return getOrderListResponse;
    }

    public GetOrderResponse getById(int id)
    {
        GetOrderResponse getOrderResponse = new GetOrderResponse();
        Orders orders = this.orderRepository.findById(id).orElseThrow();
        getOrderResponse.setAmount(orders.getAmount());
        return getOrderResponse;
    }

    public void add(AddOrderRequest orderRequest)
    {
        Orders order = new Orders();
        order.setAmount(orderRequest.getAmount());
        order.setCustomers(orderRequest.getCustomers());
        order.setCars(orderRequest.getCars());
        order.setOrderDate(orderRequest.getOrderDate());
        this.orderRepository.save(order);
    }

    public void update(UpdateOrderRequest orderRequest)
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

    public void delete(int id)
    {
        this.orderRepository.deleteById(id);
    }
}
