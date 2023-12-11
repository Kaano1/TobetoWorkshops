package com.tobeto.spring.b.controller;


import com.tobeto.spring.b.services.concretes.CarManager;
import com.tobeto.spring.b.services.dtos.request.car.AddCarRequest;
import com.tobeto.spring.b.services.dtos.request.car.UpdateCarRequest;
import com.tobeto.spring.b.services.dtos.response.car.GetCarListResponse;
import com.tobeto.spring.b.services.dtos.response.car.GetCarResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/car")
public class CarController {
    private final CarManager carManager;

    public CarController(CarManager carManager)
    {
        this.carManager = carManager;
    }

    @GetMapping
    public GetCarListResponse getAll()
    {
        return carManager.getAll();
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id)
    {
        return carManager.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest addCarRequest)
    {
        carManager.add(addCarRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateCarRequest carRequest)
    {
        carManager.update(carRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        carManager.delete(id);
    }
}
