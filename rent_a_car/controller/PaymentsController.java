package com.tobeto.spring.b.controller;

import com.tobeto.spring.b.services.concretes.PaymentsManager;
import com.tobeto.spring.b.services.dtos.request.payment.AddPaymentRequest;
import com.tobeto.spring.b.services.dtos.request.payment.UpdatePaymentRequest;
import com.tobeto.spring.b.services.dtos.response.payment.GetPaymentResponse;
import com.tobeto.spring.b.entities.Payments;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentsController {
    private final PaymentsManager paymentsManager;

    public PaymentsController(PaymentsManager paymentsManager)
    {
        this.paymentsManager = paymentsManager;
    }

    @GetMapping
    public List<Payments> getByAll()
    {
        return paymentsManager.getByAll();
    }

    @GetMapping("{id}")
    public GetPaymentResponse getById(@PathVariable int id)
    {
        return paymentsManager.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddPaymentRequest paymentRequest)
    {
        paymentsManager.add(paymentRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdatePaymentRequest paymentRequest)
    {
        paymentsManager.update(paymentRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        paymentsManager.delete(id);
    }
}
