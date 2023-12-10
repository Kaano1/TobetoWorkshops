package com.tobeto.spring.b.controller;

import com.tobeto.spring.b.dtos.request.payment.AddPaymentRequest;
import com.tobeto.spring.b.dtos.request.payment.UpdatePaymentRequest;
import com.tobeto.spring.b.dtos.response.payment.GetPaymentResponse;
import com.tobeto.spring.b.entities.Payments;
import com.tobeto.spring.b.repositories.PaymentsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentsController {
    private final PaymentsRepository paymentsRepository;

    public PaymentsController(PaymentsRepository paymentsRepository)
    {
        this.paymentsRepository = paymentsRepository;
    }

    @GetMapping
    public List<Payments> getByAll()
    {
        return paymentsRepository.findAll();
    }

    @GetMapping("{id}")
    public GetPaymentResponse getById(@PathVariable int id)
    {
        GetPaymentResponse getPaymentResponse = new GetPaymentResponse();
        Payments payments = paymentsRepository.findById(id).orElseThrow();
        getPaymentResponse.setAmount(payments.getAmount());
        getPaymentResponse.setCardNumber(payments.getCardNumber());
        getPaymentResponse.setPayMethod(payments.getPayMethod());
        return getPaymentResponse;
    }

    @PostMapping
    public void add(@RequestBody AddPaymentRequest paymentRequest)
    {
        Payments payments = new Payments();
        payments.setAmount(paymentRequest.getAmount());
        payments.setPayMethod(paymentRequest.getPayMethod());
        payments.setCardNumber(paymentRequest.getCardNumber());
        payments.setAgreement(paymentRequest.getAgreement());
        paymentsRepository.save(payments);
    }

    @PutMapping
    public void update(@RequestBody UpdatePaymentRequest paymentRequest)
    {
        Payments paymentToUpdate = paymentsRepository.findById(paymentRequest.getId()).orElseThrow();
        paymentToUpdate.setId(paymentRequest.getId());
        paymentToUpdate.setAmount(paymentRequest.getAmount());
        paymentToUpdate.setAgreement(paymentRequest.getAgreement());
        paymentToUpdate.setPayMethod(paymentRequest.getPayMethod());
        paymentToUpdate.setCardNumber(paymentRequest.getCardNumber());
        paymentsRepository.save(paymentToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        Payments payment = this.paymentsRepository.findById(id).orElseThrow();

        this.paymentsRepository.delete(payment);
    }
}
