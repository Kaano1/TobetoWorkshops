package com.tobeto.spring.b.controller;


import com.tobeto.spring.b.dtos.request.car.AddCarRequest;
import com.tobeto.spring.b.dtos.request.car.UpdateCarRequest;
import com.tobeto.spring.b.dtos.response.car.GetCarListResponse;
import com.tobeto.spring.b.dtos.response.car.GetCarResponse;
import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/car")
public class CarController {
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository)
    {
        this.carRepository = carRepository;
    }

    @GetMapping
    public GetCarListResponse getAll()
    {
        GetCarListResponse carListResponse = new GetCarListResponse();
        carListResponse.setCars(this.carRepository.findAll());
        return carListResponse;
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id)
    {
        GetCarResponse getCarResponse = new GetCarResponse();
        Car car = this.carRepository.findById(id).orElseThrow();
        getCarResponse.setModelName(car.getModelName());
        getCarResponse.setModelYear(car.getModelYear());
        return getCarResponse;
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest addCarRequest)
    {
        Car car = new Car();
        car.setModelName(addCarRequest.getModelName());
        car.setModelYear(addCarRequest.getModelYear());
        this.carRepository.save(car);
    }

    @PutMapping
    public void update(@RequestBody UpdateCarRequest carRequest)
    {
        Car carToUpdate = carRepository.findById(carRequest.getId()).orElseThrow();
        carToUpdate.setId(carRequest.getId());
        carToUpdate.setModelName(carRequest.getModelName());
        carToUpdate.setModelYear(carRequest.getModelYear());
        carRepository.save(carToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        Car car = this.carRepository.findById(id).orElseThrow();
        carRepository.delete(car);
    }
}
