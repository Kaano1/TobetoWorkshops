package com.tobeto.spring.b.controllers;


import com.tobeto.spring.b.services.concretes.PaymentsManager;
import com.tobeto.spring.b.services.dtos.request.payments.AddPaymentsRequest;
import com.tobeto.spring.b.services.dtos.response.payments.GetPaymentsListResponse;
import com.tobeto.spring.b.services.dtos.response.payments.GetPaymentsResponse;
import com.tobeto.spring.b.entities.Payments;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/payments")
public class PaymentsController {
    private final PaymentsManager paymentsManager;


    @GetMapping
    public List<GetPaymentsListResponse> getByAll()
    {
        return paymentsManager.getByAll();
    }

    @GetMapping("{id}")
    public GetPaymentsResponse getById(@PathVariable int id)
    {
        return paymentsManager.getById(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddPaymentsRequest paymentRequest)
    {
        paymentsManager.add(paymentRequest);
    }

    @PutMapping
    public void update(@RequestBody @Valid Payments othPayment)
    {
        paymentsManager.update(othPayment);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        paymentsManager.delete(id);
    }
}