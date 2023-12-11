package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.repositories.CarRepository;
import com.tobeto.spring.b.services.abstracts.CarService;
import com.tobeto.spring.b.services.dtos.request.car.AddCarRequest;
import com.tobeto.spring.b.services.dtos.request.car.UpdateCarRequest;
import com.tobeto.spring.b.services.dtos.response.car.GetCarListResponse;
import com.tobeto.spring.b.services.dtos.response.car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private final CarRepository carRepository;

    public GetCarListResponse getAll()
    {
        GetCarListResponse carListResponse = new GetCarListResponse();
        carListResponse.setCars(this.carRepository.findAll());
        return carListResponse;
    }

    public GetCarResponse getById(int id)
    {
        GetCarResponse getCarResponse = new GetCarResponse();
        Car car = this.carRepository.findById(id).orElseThrow();
        getCarResponse.setModelName(car.getModelName());
        getCarResponse.setModelYear(car.getModelYear());
        return getCarResponse;
    }

    public void add(AddCarRequest addCarRequest)
    {
        Car car = new Car();
        car.setModelName(addCarRequest.getModelName());
        car.setModelYear(addCarRequest.getModelYear());
        this.carRepository.save(car);
    }

    public void update(UpdateCarRequest carRequest)
    {
        Car carToUpdate = carRepository.findById(carRequest.getId()).orElseThrow();
        carToUpdate.setId(carRequest.getId());
        carToUpdate.setModelName(carRequest.getModelName());
        carToUpdate.setModelYear(carRequest.getModelYear());
        carRepository.save(carToUpdate);
    }

    public void delete(int id)
    {
        Car car = this.carRepository.findById(id).orElseThrow();
        carRepository.delete(car);
    }
}
