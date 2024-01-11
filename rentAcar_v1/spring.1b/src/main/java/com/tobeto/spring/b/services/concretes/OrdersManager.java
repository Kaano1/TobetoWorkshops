package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Cars;
import com.tobeto.spring.b.entities.Customers;
import com.tobeto.spring.b.entities.Orders;
import com.tobeto.spring.b.repositories.CarsRepository;
import com.tobeto.spring.b.repositories.CustomersRepository;
import com.tobeto.spring.b.repositories.OrdersRepository;
import com.tobeto.spring.b.services.abstracts.OrdersService;
import com.tobeto.spring.b.services.dtos.request.orders.AddOrdersRequest;
import com.tobeto.spring.b.services.dtos.request.orders.UpdateOrdersRequest;
import com.tobeto.spring.b.services.dtos.response.orders.GetOrdersListResponse;
import com.tobeto.spring.b.services.dtos.response.orders.GetOrdersResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrdersManager implements OrdersService
{
    private final OrdersRepository orderRepository;
    private final CustomersRepository customersRepository;
    private final CarsRepository carsRepository;
    public List<GetOrdersListResponse> getByAll()
    {
        List<Orders> orders = orderRepository.findAll();
        List<GetOrdersListResponse> getBrandListResponses = new ArrayList<>();

        for (Orders order : orders)
        {
            GetOrdersListResponse ors = new GetOrdersListResponse();

            ors.setId(order.getId());
            ors.setAmount(order.getAmount());
            ors.setEndDate(order.getEndDate());
            ors.setStartDate(order.getStartDate());

            getBrandListResponses.add(ors);
        }

        return getBrandListResponses;
    }

    public GetOrdersResponse getById(int id)
    {
        GetOrdersResponse getOrderResponse = new GetOrdersResponse();

        Orders orders = this.orderRepository.findById(id).orElseThrow();
        getOrderResponse.setAmount(orders.getAmount());
        getOrderResponse.setEndDate(orders.getEndDate());
        getOrderResponse.setStartDate(orders.getStartDate());
        return getOrderResponse;
    }

    public void add(AddOrdersRequest orderRequest)
    {
        Orders order = new Orders();

        order.setAmount(orderRequest.getAmount());
        order.setStartDate(orderRequest.getStartDate());
        order.setEndDate(orderRequest.getEndDate());
        if (orderRequest.getCustomerId() != -1)
        {
            Customers customer = customersRepository.findById(orderRequest.getCustomerId()).orElseThrow();

            order.setCustomer(customer);
        }
        if (orderRequest.getCarsId() != -1)
        {
            Cars car = carsRepository.findById(orderRequest.getCarsId()).orElseThrow();

            order.setCar(car);
        }
        this.orderRepository.save(order);
    }

    public void update(UpdateOrdersRequest othOrder)
    {
        Orders orders = orderRepository.findById(othOrder.getId()).orElseThrow();

        orders.setId(othOrder.getId());
        orders.setAmount(othOrder.getAmount());
        orders.setStartDate(othOrder.getStartDate());
        orders.setEndDate(othOrder.getEndDate());
        orders.setCustomer(customersRepository.findById(othOrder.getId()).orElseThrow());
        orders.setCar(carsRepository.findById(othOrder.getCarsId()).orElseThrow());
        orderRepository.save(orders);
    }

    public void delete(int id)
    {
        this.orderRepository.deleteById(id);
    }
}
