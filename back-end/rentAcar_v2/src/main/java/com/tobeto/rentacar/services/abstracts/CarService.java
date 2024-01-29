package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.request.Car.AddCarRequest;
import com.tobeto.rentacar.services.dtos.request.Car.UpdateCarRequest;
import com.tobeto.rentacar.services.dtos.response.Car.GetCarListResponse;
import com.tobeto.rentacar.services.dtos.response.Car.GetCarResponse;

import java.util.List;


public interface CarService {
     List<GetCarListResponse> getAll();
     GetCarResponse getById(int id);
     void    add(AddCarRequest addCarRequest);
     void    update(UpdateCarRequest updateCarRequest);
     void     delete(int id);
}
