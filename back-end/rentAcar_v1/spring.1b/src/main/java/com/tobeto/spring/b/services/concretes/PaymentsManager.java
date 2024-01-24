package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Payments;
import com.tobeto.spring.b.repositories.PaymentsRepository;
import com.tobeto.spring.b.services.abstracts.PaymentsService;
import com.tobeto.spring.b.services.dtos.request.payments.AddPaymentsRequest;
import com.tobeto.spring.b.services.dtos.response.payments.GetPaymentsListResponse;
import com.tobeto.spring.b.services.dtos.response.payments.GetPaymentsResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PaymentsManager implements PaymentsService
{
    private final PaymentsRepository paymentsRepository;
    public List<GetPaymentsListResponse> getByAll()
    {
        List<Payments> payments = paymentsRepository.findAll();
        List<GetPaymentsListResponse> getPaymentsListResponse = new ArrayList<>();

        for (Payments payment : payments)
        {
            GetPaymentsListResponse pay = new GetPaymentsListResponse();

            pay.setId(payment.getId());
            pay.setLimit(payment.getLimit());
            pay.setCardNumber(payment.getCardNumber());
            pay.setPaymentMethod(payment.getPaymentMethod());

            getPaymentsListResponse.add(pay);
        }

        return getPaymentsListResponse;
    }

    public GetPaymentsResponse getById(int id)
    {
        GetPaymentsResponse getPaymentResponse = new GetPaymentsResponse();
        Payments payments = paymentsRepository.findById(id).orElseThrow();
        getPaymentResponse.setLimit(payments.getLimit());
        getPaymentResponse.setCardNumber(payments.getCardNumber());
        getPaymentResponse.setPaymentMethod(payments.getPaymentMethod());
        return getPaymentResponse;
    }

    public void add(AddPaymentsRequest paymentRequest)
    {
        Payments payments = new Payments();

        payments.setLimit(paymentRequest.getLimit());
        payments.setPaymentMethod(paymentRequest.getPaymentMethod());
        payments.setCardNumber(paymentRequest.getCardNumber());
        payments.setLimit(paymentRequest.getLimit());
        paymentsRepository.save(payments);
    }

    public void update(Payments othPayment)
    {
        Payments payment = paymentsRepository.findById(othPayment.getId()).orElseThrow();

        payment.setId(othPayment.getId());
        payment.setLimit(othPayment.getLimit());
        payment.setPaymentMethod(othPayment.getPaymentMethod());
        payment.setLimit(othPayment.getLimit());
        payment.setOrders(othPayment.getOrders());
        paymentsRepository.save(payment);
    }

    public void delete(int id)
    {
        Payments payment = this.paymentsRepository.findById(id).orElseThrow();

        this.paymentsRepository.delete(payment);
    }
}
