package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.entities.Payments;
import com.tobeto.spring.b.services.dtos.request.payments.AddPaymentsRequest;
import com.tobeto.spring.b.services.dtos.response.payments.GetPaymentsListResponse;
import com.tobeto.spring.b.services.dtos.response.payments.GetPaymentsResponse;

import java.util.List;

public interface PaymentsService {
    void delete(int id);
    void update(Payments othPayment);
    void add(AddPaymentsRequest paymentRequest);
    GetPaymentsResponse getById(int id);
    List<GetPaymentsListResponse> getByAll();
}
