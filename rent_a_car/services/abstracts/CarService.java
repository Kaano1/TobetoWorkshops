package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.request.car.AddCarRequest;
import com.tobeto.spring.b.services.dtos.request.car.UpdateCarRequest;
import com.tobeto.spring.b.services.dtos.response.car.GetCarListResponse;
import com.tobeto.spring.b.services.dtos.response.car.GetCarResponse;

public interface CarService {
    GetCarListResponse getAll();
    GetCarResponse getById( int id);
    void add( AddCarRequest addCarRequest);
    void update( UpdateCarRequest carRequest);
    void delete( int id);
}
