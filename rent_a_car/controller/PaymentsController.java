package com.tobeto.spring.b.controller;

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
    public Payments getById(@PathVariable int id)
    {
        return paymentsRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Payments payments)
    {
        paymentsRepository.save(payments);
    }

    @PutMapping("{id}")
    public void update(@RequestBody Payments payment)
    {
        payment.setId(1);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        Payments payment = this.paymentsRepository.findById(id).orElseThrow();

        this.paymentsRepository.delete(payment);
    }
}
