package com.tobeto.spring.b.controller;

import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CarController {
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository)
    {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> getAll()
    {
        return ( this.carRepository.findAll() );
    }

    @GetMapping("{id}")
    public Car getById(@PathVariable int id)
    {
        return this.carRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Car car)
    {
        this.carRepository.save(car);
    }

    @PutMapping
    public void update(@RequestBody Car car)
    {
        car.setId(1);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        Car car = this.carRepository.findById(id).orElseThrow();
        carRepository.delete(car);
    }
}
