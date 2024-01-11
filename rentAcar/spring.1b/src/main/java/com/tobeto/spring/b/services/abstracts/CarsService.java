package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.request.cars.AddCarsRequest;
import com.tobeto.spring.b.services.dtos.request.cars.UpdateCarsRequest;
import com.tobeto.spring.b.services.dtos.response.cars.GetCarsListResponse;
import com.tobeto.spring.b.services.dtos.response.cars.GetCarsResponse;

import java.util.List;

public interface CarsService {
    List<GetCarsListResponse> getAll();
    GetCarsResponse getById(int id);
    void add(AddCarsRequest addCarsRequest);
    void update(UpdateCarsRequest car);
    void delete(int id);
}
