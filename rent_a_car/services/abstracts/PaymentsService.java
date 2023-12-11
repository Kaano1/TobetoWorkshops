package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.entities.Payments;
import com.tobeto.spring.b.services.dtos.request.payment.AddPaymentRequest;
import com.tobeto.spring.b.services.dtos.request.payment.UpdatePaymentRequest;
import com.tobeto.spring.b.services.dtos.response.payment.GetPaymentResponse;

import java.util.List;


public interface PaymentsService {
    List<Payments> getByAll();
    GetPaymentResponse getById( int id);
    void add(AddPaymentRequest paymentRequest);
    void update(UpdatePaymentRequest paymentRequest);
    void delete(int id);
}
