package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Payments;
import com.tobeto.spring.b.repositories.PaymentsRepository;
import com.tobeto.spring.b.services.abstracts.PaymentsService;
import com.tobeto.spring.b.services.dtos.request.payment.AddPaymentRequest;
import com.tobeto.spring.b.services.dtos.request.payment.UpdatePaymentRequest;
import com.tobeto.spring.b.services.dtos.response.payment.GetPaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PaymentsManager implements PaymentsService {
    private final PaymentsRepository paymentsRepository;

    public List<Payments> getByAll()
    {
        return paymentsRepository.findAll();
    }

    public GetPaymentResponse getById(int id)
    {
        GetPaymentResponse getPaymentResponse = new GetPaymentResponse();
        Payments payments = paymentsRepository.findById(id).orElseThrow();
        getPaymentResponse.setAmount(payments.getAmount());
        getPaymentResponse.setCardNumber(payments.getCardNumber());
        getPaymentResponse.setPayMethod(payments.getPayMethod());
        return getPaymentResponse;
    }

    public void add(AddPaymentRequest paymentRequest)
    {
        Payments payments = new Payments();
        payments.setAmount(paymentRequest.getAmount());
        payments.setPayMethod(paymentRequest.getPayMethod());
        payments.setCardNumber(paymentRequest.getCardNumber());
        payments.setAgreement(paymentRequest.getAgreement());
        paymentsRepository.save(payments);
    }

    public void update(UpdatePaymentRequest paymentRequest)
    {
        Payments Update = paymentsRepository.findById(paymentRequest.getId()).orElseThrow();
        Update.setId(paymentRequest.getId());
        Update.setAmount(paymentRequest.getAmount());
        Update.setAgreement(paymentRequest.getAgreement());
        Update.setPayMethod(paymentRequest.getPayMethod());
        Update.setCardNumber(paymentRequest.getCardNumber());
        paymentsRepository.save(Update);
    }

    public void delete(int id)
    {
        Payments payment = this.paymentsRepository.findById(id).orElseThrow();

        this.paymentsRepository.delete(payment);
    }
}
